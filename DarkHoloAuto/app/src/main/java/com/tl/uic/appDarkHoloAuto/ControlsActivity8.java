/*******************************************************************************
 * Licensed Materials - Property of IBM
 * 5725-K23
 * (c) Copyright IBM Corp. 2013, 2014
 * US Government Users Restricted Rights - Use, duplication or disclosure restricted by GSA ADP Schedule Contract with IBM Corp.
 ******************************************************************************/
package com.tl.uic.appDarkHoloAuto;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

/**
 * @author ohernandezltmac
 *
 */
public class ControlsActivity8 extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.controls8);
    }

    public boolean dispatchTouchEvent(MotionEvent e)
    {
        return super.dispatchTouchEvent(e);
    }
}
