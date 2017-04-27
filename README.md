# VoiceView
语音消息控件
==========

一、实现的功能
----------
1.由控件自己完成点击播放语音，并做播放语音动画的功能；<br>
2.由控件自己根据音频文件长度调整控件长度；<br>
3.由控件自己根据音频文件显示时间长短(单位：s)；<br>

二、使用示例
----------
```Java
VoiceView voiceView = findViewById(R.id.voice_view);
// 设置是左边还是右边
voiceView.setSide(VoiceView.LEFT);
// 设置语音文件的路径
voiceView.setVoiceFileDir(path);
```
三、效果预览
----------
![](https://github.com/weiyalong1025/VoiceView/blob/master/screenshot/S70427-143244.jpg)  

