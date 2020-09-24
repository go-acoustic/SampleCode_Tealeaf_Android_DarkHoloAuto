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
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.tl.uic.app.model.Items;
import com.tl.uic.app.model.Items.Item;
import com.tl.uic.appDarkHoloAuto.util.TLHelper;

import java.util.ArrayList;

public class ControlsFragment6 extends Fragment {
    private ArrayList<? extends Item> data;
    private Items items = Items.getInstance();
    private String packageName;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.controls6, container, false);

        packageName = this.getActivity().getApplicationContext().getPackageName();
        data = items.getCategories();

        ListView lv = v.findViewById(R.id.listing1);
        lv.setAdapter(new MyCustomAdapter(this.getActivity()));
        return v;
    }

    static class Vholder {
        TextView name;
        ImageView thumb;
    }

    public class MyCustomAdapter extends BaseAdapter {
        Context context;

        MyCustomAdapter(Context context) {
            this.context = context;
        }

        public int getCount() {
            return data.size();
        }

        public Object getItem(int position) {
            return data.get(position);
        }

        public long getItemId(int position) {
            return data.get(position).getId();
        }

        public View getView(final int position, View convertView, ViewGroup parent) {
            Vholder vh;

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.listitem, null);
                vh = new Vholder();
                vh.name = convertView.findViewById(R.id.item_name);
                vh.thumb = convertView.findViewById(R.id.item_icon);
                convertView.setTag(vh);
                try {
                    final Resources resources = getResources();
                    int idItemName = resources.getIdentifier("item_name_" + position, "id", packageName);
                    int idItemIcon = resources.getIdentifier("item_icon_" + position, "id", packageName);
                    vh.name.setId(idItemName);
                    vh.thumb.setId(idItemIcon);
                } catch (final Exception e) {
                    Log.d("SP", "Trying to get id property value.", e);
                }
            } else {
                vh = (Vholder) convertView.getTag();
            }

            vh.name.setText(data.get(position).getName());
            vh.thumb.setImageResource(data.get(position).getThumbnail());

            convertView.setOnClickListener(TLHelper.getOnClickListener());
            return convertView;
        }
    }
}
