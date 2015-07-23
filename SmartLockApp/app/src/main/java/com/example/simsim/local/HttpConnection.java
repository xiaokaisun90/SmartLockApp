package com.example.simsim.local;

import java.net.HttpURLConnection;

/**
 * Created by xiaokaisun on 7/18/15.
 */

//This class is used to build the connection between android device and remote server
public class HttpConnection {

    private static HttpURLConnection httpURLConnection;

    public static void open(){

    };

    public static HttpURLConnection getConnection(){
        return httpURLConnection;
    }

    public static void close(){

    }
}
