/*******************************************************************************
 * Licensed Materials - Property of IBM
 * (C) Copyright IBM Corp. 2018
 * US Government Users Restricted Rights - Use, duplication or disclosure
 * restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/
package com.tl.uic.appDarkHoloAuto;

import com.tl.uic.appDarkHoloAuto.util.TLHelper;

import android.os.Bundle;
import android.widget.Switch;

/**
 * @author ohernandezltmac
 *
 */
public class ControlsActivity8 extends BaseActivity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls8);

        Switch sUw = findViewById(R.id.saveUname_switch);
        sUw.setOnCheckedChangeListener(TLHelper.getCompoundButtonOnCheckedChangeListener());

        Switch sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(TLHelper.getCompoundButtonOnCheckedChangeListener());
    }
}
