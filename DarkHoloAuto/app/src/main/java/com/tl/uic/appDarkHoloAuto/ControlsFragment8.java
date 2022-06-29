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
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.tl.uic.Tealeaf;
import com.tl.uic.model.Connection;

import java.net.HttpURLConnection;
import java.net.URL;
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
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Thread thread = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            String imageUrl = "https://acoustic.com/";
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
