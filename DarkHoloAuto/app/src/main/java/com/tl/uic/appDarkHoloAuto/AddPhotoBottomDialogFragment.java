package com.tl.uic.appDarkHoloAuto;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.tl.uic.Tealeaf;

public class AddPhotoBottomDialogFragment extends BottomSheetDialogFragment {

    public static AddPhotoBottomDialogFragment newInstance() {
        return new AddPhotoBottomDialogFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bottom_sheet_fragment, container,
                false);

        DialogFragment dialogFragment = (DialogFragment) this;
        // get the views and attach the listener
        Tealeaf.logScreenLayoutSetOnShowListener(dialogFragment.getActivity(), dialogFragment.getDialog(), "Bottom Sheet Fragment", true);

        return view;

    }
}
