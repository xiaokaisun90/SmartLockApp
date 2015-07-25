package com.example.simsim.local;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class HttpConnection {

    // Send post request with an object to a URL, return an object from response.
    public static Object httpPost(String urlString, Object object) throws IOException, ClassNotFoundException{

        URL url = new URL(urlString);
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        urlConnection.setDoInput(true);
        urlConnection.setDoOutput(true);
        urlConnection.setRequestMethod("POST");
        urlConnection.setUseCaches(false);
        urlConnection.connect();

        ObjectOutputStream out = new ObjectOutputStream(urlConnection.getOutputStream());
        out.writeObject(object);
        out.flush();
        out.close();

        ObjectInputStream in = new ObjectInputStream(urlConnection.getInputStream());
        Object o = in.readObject();
        in.close();

        urlConnection.disconnect();

        return o;

    }
}