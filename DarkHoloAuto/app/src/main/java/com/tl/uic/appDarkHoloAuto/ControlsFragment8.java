/********************************************************************************************
 * Copyright (C) 2020 Acoustic, L.P. All rights reserved.
 *
 * NOTICE: This file contains material that is confidential and proprietary to
 * Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
 * industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
 * Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
 * prohibited.
 ********************************************************************************************/
package com.tl.uic.appDarkHoloAuto;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.tl.uic.Tealeaf;
import com.tl.uic.model.Connection;
import com.tl.uic.util.TLFConnectionUtil;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLConnection;
import java.util.Date;
import java.util.HashMap;

/**
 * @author ohernandezltmac
 */
public class ControlsFragment8 extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.controls8, container, false);

        Button button = v.findViewById(R.id.button1);
        final HashMap<String, String> data = new HashMap<>();
        data.put("Foo", "Bar");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tealeaf.logCustomEvent("MyEvent", data);
            }
        });

        button = v.findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value = data.get("key");
                if (value == null) {
                    Tealeaf.logException(new Exception("Custom Exception"));
                }
            }
        });

        button = v.findViewById(R.id.button3);
        button.setOnClickListener(view -> {

            Thread thread = new Thread(() -> {
                try {
                    String siteUrl = "https://acoustic.com";
                    URL url = new URL(siteUrl);

                    // Create a new TLFConnectionUtil object.
                    TLFConnectionUtil connectionUtil = new TLFConnectionUtil();

                    // Open the connection.
                    Object[] clientObject = connectionUtil.openConnection(
                            this.getContext(),
                            siteUrl,
                            TLFConnectionUtil.ConnectionType.URL,
                            TLFConnectionUtil.ResponseType.DEFAULT,
                            null);

                    //example of automatically opening an http connection and logging the Connection properties
//                    Object[] httpClient = TLFConnectionUtil.openConnection(url);
                    URLConnection httpClient = (URLConnection) clientObject[0];

                    //example of updating the connection properties using the currently open http connection
                    //this is only needed if the app needs to modify/update specific data values
                    //otherwise, the above openConnection method is the only piece of code needed
                    //to re-iterate, the following lines of code are optional
                    Connection connection = TLFConnectionUtil.getConnection();
                    //example of updating an existing property
                    connection.setLoadTime(50);
                    //calculate approximate response time
                    connection.setResponseTime(new Date().getTime() - connection.getInitTime());
                    //will need to manually make another call  after updating properties
                    TLFConnectionUtil.setConnection(connection);

                    //example of how the response data can be extracted
                    BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream()));
                    String inputLine;
                    while ((inputLine = in.readLine()) != null) {
                        Log.d("TESTING", inputLine);
                    }
                    in.close();

                } catch (Exception e) {
                    e.printStackTrace();
                }

            });
            thread.start();
        });

        button = v.findViewById(R.id.button5);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String imageUrl = "http://www.google.com/";
                            URL url = new URL(imageUrl);

                            Connection connection = new com.tl.uic.model.Connection();
                            connection.setUrl(imageUrl);
                            connection.setInitTime(new Date().getTime());

                            HttpURLConnection httpClient = (HttpURLConnection) url.openConnection();

                            connection.setStatusCode(httpClient.getResponseCode());
                            connection.setResponseDataSize(httpClient.getContentLength());
                            Tealeaf.logConnection(connection);
                        } catch (Exception e) {
                            Tealeaf.logException(e);
                        }
                    }
                });
                thread.start();
            }
        });


        button = v.findViewById(R.id.button4);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Tealeaf.logFormCompletion(true, true);
            }
        });
        return v;
    }
}
