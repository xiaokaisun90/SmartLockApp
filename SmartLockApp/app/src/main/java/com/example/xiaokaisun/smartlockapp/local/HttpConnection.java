package com.example.xiaokaisun.smartlockapp.local;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownServiceException;

/**
 * Created by xiaokaisun on 7/18/15.
 */

//This class is used to build the connection between android device and remote server
public class HttpConnection {
    public static void connect() {
        try {
            URL oracle = new URL("http://www.oracle.com/");
            URLConnection yc = oracle.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    yc.getInputStream()));
            String inputLine;
            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (UnknownServiceException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
