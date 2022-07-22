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

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.tl.uic.util.DialogUtil;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

public class ControlsFragment5 extends Fragment {

    @SuppressLint("InflateParams")
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.controls5, container, false);

        // This is an example of instantiating an Alert Dialog which will auto-generate an alert
        // which contains a Title, Message, and Negative Button utilizing Tealeaf's custom AlertDialog class.
        Button button = v.findViewById(R.id.alertButton1);
        button.setOnClickListener(v13 -> {
            String title = getString(R.string.alertTitle);
            String message = getString(R.string.alertMessage1);
            //To instrument when the dialog is shown, use a custom method to show the dialog.
            DialogUtil.showDialog(getContext(), title, message, "OK");
        });

        // This is an example of instantiating an Alert Dialog which contains user-specified parameters
        // within a custom builder.  This dialog will instantiate Tealeaf's custom Alert Dialog class
        button = v.findViewById(R.id.alertButton2);
        button.setOnClickListener(v14 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v14.getContext());
            String title = getString(R.string.alertTitle);
            String message = getString(R.string.alertMessage2);
            builder.setMessage(message)
                    .setTitle(title)
                    .setCancelable(false)
                    .setPositiveButton("Dismiss", (dialog, id) -> dialog.cancel())
                    .setNegativeButton("OK", (dialog, id) -> dialog.cancel());
            final AlertDialog dialog = builder.create();
            //To instrument when the dialog is shown, use a custom method to show the dialog.
            DialogUtil.showDialog(getContext(), dialog);
        });

        // This is an example of instantiating an Alert Dialog which contains a list of values and user-specified parameters
        // within a custom builder.  This dialog will instantiate Tealeaf's custom Alert Dialog class
        button = v.findViewById(R.id.alertButtonList);
        button.setOnClickListener(v15 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v15.getContext());
            String title = getString(R.string.alertTitleList);
            builder.setTitle(title)
                    .setCancelable(false)
                    .setItems(R.array.planets_array, (dialog, which) -> {
                        // The 'which' argument contains the index position
                        // of the selected item
                    });
            final AlertDialog dialog = builder.create();
            //To instrument when the dialog is shown, use a custom method to show the dialog.
            DialogUtil.showDialog(getContext(), dialog);
        });

        // This is an example of instantiating an Alert Dialog which contains a custom message and user-specified parameters
        // within a custom builder.  This dialog will instantiate Tealeaf's custom Alert Dialog class
        button = v.findViewById(R.id.alertButtonCustomContent);
        button.setOnClickListener(v16 -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(v16.getContext());
            String title = getString(R.string.alertWithCustomContent);
            builder.setTitle(title)
                    .setCancelable(false)
                    .setView(inflater.inflate(R.layout.fragment_dialog, null))
                    .setPositiveButton("Dismiss", (dialog, id) -> dialog.cancel())
                    .setNegativeButton("OK", (dialog, id) -> dialog.cancel());
            final AlertDialog dialog = builder.create();
            //To instrument when the dialog is shown, use a custom method to show the dialog.
            DialogUtil.showDialog(getContext(), dialog);
        });

        // This is an example of instantiating a Dialog Fragment which inherits from Android's
        // DialogFragment class and will require manual instrumentation within the custom dialog to
        // instrument user interaction.
        Button dialogFragmentButton = v.findViewById(R.id.dialogFragmentButton);
        dialogFragmentButton.setOnClickListener(v1 -> {
            MyDialogFragment myDialogFragment = MyDialogFragment.newInstance("Dialog Fragment Example");
            myDialogFragment.show(requireActivity().getSupportFragmentManager(), "manual_instrumentation_dialog_fragment");
        });

        // This is an example of instantiating a Dialog Fragment (BottomSheet) which inherits from Tealeaf's
        // BottomSheet Dialog class and allows for auto instrumentation of user interaction
        // within the dialog.
        button = (Button) v.findViewById(R.id.bottomSheetButton);
        button.setOnClickListener(v12 -> {
            AddPhotoBottomDialogFragment addPhotoBottomDialogFragment = new AddPhotoBottomDialogFragment();
            addPhotoBottomDialogFragment.show(ControlsFragment5.this.getActivity().getSupportFragmentManager(), "auto_instrumentation_dialog_fragment");
        });

        return v;
    }
}
