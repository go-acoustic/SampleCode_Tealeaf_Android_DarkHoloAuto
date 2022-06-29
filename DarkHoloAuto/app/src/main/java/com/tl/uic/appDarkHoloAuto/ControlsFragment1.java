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

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.Fragment;

import com.tl.uic.Tealeaf;
import com.tl.uic.appDarkHoloAuto.util.TLHelper;

/**
 * @author ohernandezltmac
 */
public class ControlsFragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.controls1, container, false);

        // Instrumentation for Scrollview screen capture
        final NestedScrollView scrollView = v.findViewById(R.id.scrollView1);
        final Activity activity = this.getActivity();

        scrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // Scroll offset before calling Tealeaf Logscreen API
                if (scrollY - oldScrollY > 100) {
                    Tealeaf.logScreenLayout(activity, "CustomScrollViewLog", 0, true);
                }
            }
        });


        /**
         * How to log screen layout
         */
        Button logScreenButton1 = (Button) v.findViewById(R.id.buttonCaptureScreen1);
        logScreenButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tealeaf.logScreenLayout(getActivity(), "CustomButtonLog", 500);
            }
        });

        Button logScreenButton2 = (Button) v.findViewById(R.id.buttonCaptureScreen2);
        logScreenButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tealeaf.logScreenLayout(getActivity(), "CustomButtonLog", 500,false);
            }
        });

        Button logScreenButton3 = (Button) v.findViewById(R.id.buttonCaptureScreen3);
        logScreenButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Tealeaf.logScreenLayout(getActivity(), "CustomButtonLog", 500, true);
            }
        });

        return v;
    }
}
