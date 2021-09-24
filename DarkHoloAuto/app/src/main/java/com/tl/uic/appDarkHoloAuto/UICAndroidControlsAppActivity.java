/********************************************************************************************
* Copyright (C) 2016 Acoustic, L.P. All rights reserved.
*
* NOTICE: This file contains material that is confidential and proprietary to
* Acoustic, L.P. and/or other developers. No license is granted under any intellectual or
* industrial property rights of Acoustic, L.P. except as may be provided in an agreement with
* Acoustic, L.P. Any unauthorized copying or distribution of content from this file is
* prohibited.
********************************************************************************************/
package com.tl.uic.appDarkHoloAuto;


import android.os.Bundle;
import android.view.MotionEvent;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.tl.uic.Tealeaf;
import com.tl.uic.model.ScreenviewType;

public class UICAndroidControlsAppActivity extends AppCompatActivity {
    private TabAdapter adapter;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.tab_layout);

        viewPager = findViewById(R.id.viewpager);
        tabLayout = findViewById(R.id.sliding_tabs);
        adapter = new TabAdapter(getSupportFragmentManager(), this);
        adapter.addFragment(new ControlsFragment1(), "c1");
        adapter.addFragment(new ControlsFragment2(), "c2");
        adapter.addFragment(new ControlsFragment3(), "c3");
        adapter.addFragment(new ControlsFragment4(), "c4");
        adapter.addFragment(new ControlsFragment5(), "c5");
        adapter.addFragment(new ControlsFragment6(), "c6");
        adapter.addFragment(new ControlsFragment7(), "c7");
        adapter.addFragment(new ControlsFragment8(), "c8");

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                // Each tab contains a Fragment, we'll log a screenview and its content.  Note:  Without new screenview load, replay renders content as Dynamic type in the same bucket.
                Tealeaf.logScreenview(UICAndroidControlsAppActivity.this, adapter.getCurrentFragment().getClass().getSimpleName(), ScreenviewType.LOAD);
                Tealeaf.onResumeFragment(UICAndroidControlsAppActivity.this, null, adapter.getCurrentFragment());
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });

        // This is the Home screen Fragment content.
        Tealeaf.logScreenview(UICAndroidControlsAppActivity.this, adapter.getItem(0).getClass().getSimpleName(), ScreenviewType.LOAD);
        Tealeaf.onResumeFragment(UICAndroidControlsAppActivity.this, null, adapter.getItem(0));

    }

    /* Add touch event to collect gestures for Tealeaf.
     *
     * (non-Javadoc)
     * @see android.app.Activity#dispatchTouchEvent(android.view.MotionEvent)
     */
    public boolean dispatchTouchEvent(MotionEvent e) {
        return super.dispatchTouchEvent(e);
    }
}
