package com.genonbeta.TrebleShot.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.genonbeta.TrebleShot.R;
import com.genonbeta.TrebleShot.activity.ConnectionManagerActivity;
import com.genonbeta.TrebleShot.activity.ContentSharingActivity;
import com.genonbeta.TrebleShot.ui.callback.IconSupport;
import com.genonbeta.TrebleShot.ui.callback.TitleSupport;

import co.aenterhy.toggleswitch.ToggleSwitchButton;

public class FragmentTransferHome extends Fragment implements IconSupport, TitleSupport {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_transfer_home, container, false);

        ToggleSwitchButton toggle = (ToggleSwitchButton) view.findViewById(R.id.toggle);
        toggle.setOnTriggerListener(new ToggleSwitchButton.OnTriggerListener() {
            @Override
            public void toggledUp() {
                startActivity(new Intent(getContext(), ContentSharingActivity.class));
            }

            @Override
            public void toggledDown() {
                startActivity(new Intent(getContext(), ConnectionManagerActivity.class)
                        .putExtra(ConnectionManagerActivity.EXTRA_ACTIVITY_SUBTITLE, getString(R.string.text_receive))
                        .putExtra(ConnectionManagerActivity.EXTRA_REQUEST_TYPE, ConnectionManagerActivity.RequestType.MAKE_ACQUAINTANCE.toString()));
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    @Override
    public int getIconRes() {
        return R.drawable.ic_swap_vert_white_24dp;
    }

    @Override
    public CharSequence getTitle(Context context) {
        return "Send & Receive";
    }
}