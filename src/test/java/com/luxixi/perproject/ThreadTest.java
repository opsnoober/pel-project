package com.luxixi.perproject;

import io.swagger.models.auth.In;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootTest
public class ThreadTest {

    @Test
    void test01(){
        String str = "﻿H21tIsda";
    }
    @Test
    void test02(){
        String content = "http://aispeech-callcenter-sqc.oss-cn-hangzhou.aliyuncs.com/record/914013215/2020-10-19/2020-10-19-14-27-10_013402653848%2460903301_00572_914013215_013402653848%26460be3e9363616c6c05aef0ce%4047.110.228.58.wav?Expires=1918448866&OSSAccessKeyId=LTAIph2xelG1RKze&Signature=%2BUZuN6C4jiLvxbtJERYEFccTK40%3D";
        int i = content.lastIndexOf("?");
        System.out.println(i);
        System.out.println(content.substring(0,208));
        content = content.substring(0,208);
        int lastIndexOf = content.lastIndexOf(".");
        System.out.println(content.substring(lastIndexOf+1));
    }

    @Test
    void test03(){
        Integer a = new Integer("0");
        System.out.println(0==a);
    }

    @Test
    void test04(){
        try {
            URL url = new URL("http://aispeech-callcenter-sqc.oss-cn-hangzhou.aliyuncs.com/record/914013215/2020-10-22/2020-10-22-13-45-43_015051511728%2460903301_00572_914013215_015051511728%26437694bcb63616c6c05b47689%4047.110.228.58.wav?Expires=1918705592&OSSAccessKeyId=LTAIph2xelG1RKze&Signature=T7y7pCHCq5IsXT5mu%2F0%2BYGpSB54%3D");
            HttpURLConnection urlConnection = null;
            urlConnection = (HttpURLConnection) url.openConnection();
            // 防止报403错误。
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            urlConnection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36");
            urlConnection.connect();
            System.out.println(urlConnection.getResponseCode());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
