package com.winsion.voiceview;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView lvTest;
    private List<Message> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        File file1 = new File(Environment.getExternalStorageDirectory(), "1.mp3");
        File file2 = new File(Environment.getExternalStorageDirectory(), "2.wav");
        File file3 = new File(Environment.getExternalStorageDirectory(), "3.aac");
        File file4 = new File(Environment.getExternalStorageDirectory(), "4.mp3");
        File file5 = new File(Environment.getExternalStorageDirectory(), "5.mp3");
        File file6 = new File(Environment.getExternalStorageDirectory(), "6.mp3");
        lvTest = (ListView) findViewById(R.id.lv_test);
        for (int i = 0; i < 120; i++) {
            Message message = null;
            if (i % 6 == 0) {
                message = new Message(file1.getAbsolutePath(), VoiceView.LEFT);
            } else if (i % 6 == 1) {
                message = new Message(file2.getAbsolutePath(), VoiceView.RIGHT);
            } else if (i % 6 == 2) {
                message = new Message(file3.getAbsolutePath(), VoiceView.LEFT);
            } else if (i % 6 == 3) {
                message = new Message(file4.getAbsolutePath(), VoiceView.RIGHT);
            } else if (i % 6 == 4) {
                message = new Message(file5.getAbsolutePath(), VoiceView.LEFT);
            } else if (i % 6 == 5) {
                message = new Message(file6.getAbsolutePath(), VoiceView.RIGHT);
            }
            list.add(message);
        }
        MyAdapter myAdapter = new MyAdapter(this);
        lvTest.setAdapter(myAdapter);
    }

    private class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public MyAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int position) {
            return list.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = mInflater.inflate(R.layout.item_list, null);
                holder.coverRight = convertView.findViewById(R.id.cover_right);
                holder.voiceView = (VoiceView) convertView.findViewById(R.id.voice_view);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            Message message = list.get(position);
            if (message.getSide() == VoiceView.RIGHT) {
                holder.coverRight.setVisibility(View.VISIBLE);

            } else {
                holder.coverRight.setVisibility(View.GONE);
            }
            holder.voiceView.setSide(message.getSide());
            holder.voiceView.setVoiceFileDir(message.getPath());
            return convertView;
        }

        class ViewHolder {
            public View coverRight;
            public VoiceView voiceView;
        }
    }
}
