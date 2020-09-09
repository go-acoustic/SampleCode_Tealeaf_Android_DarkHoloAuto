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

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {
    private final List<Fragment> mFragmentList = new ArrayList<>();
    private final List<String> mFragmentTitleList = new ArrayList<>();
    private Context context;

    TabAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }
    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }
    public void addFragment(Fragment fragment, String title) {
        mFragmentList.add(fragment);
        mFragmentTitleList.add(title);
    }
    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitleList.get(position);
    }
    @Override
    public int getCount() {
        return mFragmentList.size();
    }

//    public View getTabView(int position) {
//        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
//        TextView tabTextView = view.findViewById(R.id.tabTextView);
//        tabTextView.setText(mFragmentTitleList.get(position));
//        return view;
//    }
//
//    public View getSelectedTabView(int position) {
//        View view = LayoutInflater.from(context).inflate(R.layout.custom_tab, null);
//        TextView tabTextView = view.findViewById(R.id.tabTextView);
//        tabTextView.setText(mFragmentTitleList.get(position));
//        tabTextView.setTextSize(26); // for big text, increase text size
//        tabTextView.setTextColor(ContextCompat.getColor(context, R.color.yellow));
//        return view;
//    }
}
