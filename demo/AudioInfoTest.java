package com.zgs.trace.send.test;

import it.sauronsoftware.jave.AudioAttributes;
import it.sauronsoftware.jave.Encoder;
import it.sauronsoftware.jave.EncodingAttributes;

import java.io.File;

/**
 * @author Shmily
 * @email shmily_zgs@163.com
 * @date 2017/12/21 12:03
 */
public class AudioInfoTest {
    public static void main(String[] args) {
        try{
            /**
             * 比特率
               就是你说的第一个,应该是Kbps, 应为32-320, 32以下的音频听起来模糊不清,而且杂音甚重.
               而320则是MP3文件比特率的上限.(MP3 PRO支持动态比特率和高于320K的,但是手机普遍不支持MP3 PRO)
               采样率
               一般来讲手机可以支持 44100和48000. 44100是最普遍的音频采样率, 不过现在使用48000的也有不好.
             */
            testCompressMp3Samll();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void testCompressMp3Samll() throws Exception{
        Long t1 = System.currentTimeMillis();
        AudioAttributes audio = new AudioAttributes();
        audio.setCodec("libmp3lame");
        audio.setBitRate(32000);//设置比特率
        audio.setSamplingRate(44100);//设置采样率
        EncodingAttributes attrs = new EncodingAttributes();
        attrs.setFormat("mp3");//设置格式
        attrs.setAudioAttributes(audio);
// attrs.setDuration(360f); // 设置截取的时长
        Encoder encoder = new Encoder();
        encoder.encode(new File("d:/audio/audiosource-128kbs.mp3"), new File("d:/audio/audiosource-32kbs.mp3"), attrs);
        Long t2= System.currentTimeMillis();
        System.out.println("消耗："+(t2-t1)+"ms");
    }
}