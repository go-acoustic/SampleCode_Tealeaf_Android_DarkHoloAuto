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
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;

import com.ibm.eo.EOCore;
import com.tl.uic.Tealeaf;
import com.tl.uic.TealeafEOLifecycleObject;
import com.tl.uic.appDarkHoloAuto.util.TLHelper;


public class ControlsFragment3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.controls3, container, false);

        EditText et = v.findViewById(R.id.editText1);

        TLHelper.addFocusAndRegister(et, this.getActivity());
        et = v.findViewById(R.id.editText2);
        TLHelper.addFocusAndRegister(et, this.getActivity());
        et = v.findViewById(R.id.editText3);
        TLHelper.addFocusAndRegister(et, this.getActivity());
        et = v.findViewById(R.id.editText4);
        TLHelper.addFocusAndRegister(et, this.getActivity());
        et = v.findViewById(R.id.editText5);
        TLHelper.addFocusAndRegister(et, this.getActivity());

        final EditText postMessageUrl = v.findViewById(R.id.postMessageUrl);
        postMessageUrl.setText(EOCore.getConfigItemString(Tealeaf.TLF_POST_MESSAGE_URL, TealeafEOLifecycleObject.getInstance()));

        final EditText appKey = v.findViewById(R.id.appKey);
        appKey.setText(EOCore.getConfigItemString(Tealeaf.TLF_APP_KEY, TealeafEOLifecycleObject.getInstance()));

        Button btn = v.findViewById(R.id.saveButton);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean configModified = false;
                if (!postMessageUrl.getText().equals((EOCore.getConfigItemString(Tealeaf.TLF_POST_MESSAGE_URL, TealeafEOLifecycleObject.getInstance())))) {
                    EOCore.updateConfig(Tealeaf.TLF_POST_MESSAGE_URL, postMessageUrl.getText().toString(), TealeafEOLifecycleObject.getInstance());
                    configModified = true;
                }
                if (!appKey.getText().equals((EOCore.getConfigItemString(Tealeaf.TLF_APP_KEY, TealeafEOLifecycleObject.getInstance())))) {
                    EOCore.updateConfig(Tealeaf.TLF_APP_KEY, appKey.getText().toString(), TealeafEOLifecycleObject.getInstance());
                    configModified = true;
                }

                if (configModified) {
                    Tealeaf.disable();
                    Tealeaf.enable();
                }

                Tealeaf.logFormCompletion(true);
            }
        });

        AutoCompleteTextView acet = v.findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_dropdown_item_1line, COUNTRIES);
        acet.setAdapter(adapter);
        TLHelper.addFocusAndRegister(acet, this.getActivity());
        return v;
    }

    private static final String[] COUNTRIES = new String[]{
            "Belgium", "France", "Italy", "Germany", "Spain"
    };
}
