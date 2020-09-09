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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;

import androidx.fragment.app.Fragment;


public class ControlsActivity3 extends Fragment {
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		View v = inflater.inflate(R.layout.controls3, container, false);

	    EditText et = (EditText) v.findViewById(R.id.editText1);
	    
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText2);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText3);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText4);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText5);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText6);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText7);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText8);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText9);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText10);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText11);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText12);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    et = (EditText) v.findViewById(R.id.editText13);
	    TLHelper.addFocusAndRegister(et, this.getActivity());
	    
	    AutoCompleteTextView acet = (AutoCompleteTextView) v.findViewById(R.id.autoCompleteTextView1);
	    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_dropdown_item_1line, COUNTRIES);
	    acet.setAdapter(adapter);
	    TLHelper.addFocusAndRegister(acet, this.getActivity());
	    
	    MultiAutoCompleteTextView mactv = (MultiAutoCompleteTextView) v.findViewById(R.id.multiAutoCompleteTextView1);
	    mactv.setAdapter(adapter);
	    mactv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
	    TLHelper.addFocusAndRegister(mactv, this.getActivity());
	    return v;
	}
	
	private static final String[] COUNTRIES = new String[] {
        "Belgium", "France", "Italy", "Germany", "Spain"
    };
//	public boolean dispatchTouchEvent(MotionEvent e)
//	{
//		return super.dispatchTouchEvent(e);
//	}
}
