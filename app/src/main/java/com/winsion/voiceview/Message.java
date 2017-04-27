package com.winsion.voiceview;

/**
 * Created by wyl on 2017/4/27.
 */

public class Message {
    private String path;
    private int side;

    public Message(String path, int side) {
        this.path = path;
        this.side = side;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int getSide() {
        return side;
    }

    public void setSide(int side) {
        this.side = side;
    }
}
