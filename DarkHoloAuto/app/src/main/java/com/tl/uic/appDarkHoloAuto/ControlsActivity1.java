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

import com.tl.uic.appDarkHoloAuto.util.TLHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.ToggleButton;

import androidx.fragment.app.Fragment;

/**
 * @author ohernandezltmac
 *
 */
public class ControlsActivity1 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.controls1, container, false);

	    TextView t = (TextView) v.findViewById(R.id.textView1);
	    t.setOnClickListener(TLHelper.getOnClickListener());
	    t = (TextView) v.findViewById(R.id.textView2);
	    t.setOnClickListener(TLHelper.getOnClickListener());
	    t = (TextView) v.findViewById(R.id.textView3);
	    t.setOnClickListener(TLHelper.getOnClickListener());
	    t = (TextView) v.findViewById(R.id.textView4);
	    t.setOnClickListener(TLHelper.getOnClickListener());

	    Button b = (Button) v.findViewById(R.id.button5);
	    b.setOnClickListener(TLHelper.getOnClickListener());

	    b = (Button) v.findViewById(R.id.button6);
	    b.setOnClickListener(TLHelper.getOnClickListener());

	    ImageButton ib = (ImageButton) v.findViewById(R.id.imageButton);
	    ib.setOnClickListener(TLHelper.getOnClickListener());

	    ImageView iv = (ImageView) v.findViewById(R.id.imageView1);
	    iv.setOnClickListener(TLHelper.getOnClickListener());

	    ToggleButton tb = (ToggleButton) v.findViewById(R.id.toggleButton1);
	    tb.setOnClickListener(TLHelper.getOnClickListener());

	    MediaController mc = (MediaController) v.findViewById(R.id.mediaController1);
	    mc.setOnClickListener(TLHelper.getOnClickListener());

	    CheckBox cb = (CheckBox) v.findViewById(R.id.checkBox1);
	    cb.setOnClickListener(TLHelper.getOnClickListener());
	    return v;
	}
//	public boolean dispatchTouchEvent(MotionEvent e)
//	{
//		return super.dispatchTouchEvent(e);
//	}
}
