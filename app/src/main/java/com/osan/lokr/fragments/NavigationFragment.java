package com.osan.lokr.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.osan.lokr.MainActivity;
import com.osan.lokr.R;
import com.osan.lokr.SplashActivity;

public class NavigationFragment extends Fragment
{
    RelativeLayout rProfile;
    ImageView imgArrow;
    RelativeLayout rOtherOption;
    RelativeLayout rProfileOption;
    RelativeLayout rHome;
    RelativeLayout rMessage;
    RelativeLayout rNotification;
    RelativeLayout rWatching;
    RelativeLayout rSaved;
    RelativeLayout rRequest;
    RelativeLayout rListing;
    RelativeLayout rHelp;
    RelativeLayout rSetting;
    RelativeLayout rProfileItem;
    RelativeLayout rSignOut;
    boolean status = false;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_navigation, container, false);
        rProfile = view.findViewById(R.id.rProfile);
        imgArrow = view.findViewById(R.id.imgArrow);
        rOtherOption = view.findViewById(R.id.rOtherOption);
        rProfileOption = view.findViewById(R.id.rProfileOption);
        rHome = view.findViewById(R.id.rHome);
        rMessage = view.findViewById(R.id.rMessage);
        rNotification = view.findViewById(R.id.rNotification);
        rWatching = view.findViewById(R.id.rWatching);
        rSaved = view.findViewById(R.id.rSaved);
        rRequest = view.findViewById(R.id.rRequest);
        rListing = view.findViewById(R.id.rListing);
        rHelp = view.findViewById(R.id.rHelp);
        rSetting = view.findViewById(R.id.rSetting);
        rProfileItem = view.findViewById(R.id.rProfileItem);
        rSignOut = view.findViewById(R.id.rSignOut);
        listener();
        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();
        rOtherOption.setVisibility(View.VISIBLE);
        rProfileOption.setVisibility(View.GONE);
    }

    private void listener()
    {
        rProfile.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                if (status)
                {
                    rOtherOption.setVisibility(View.VISIBLE);
                    rProfileOption.setVisibility(View.GONE);
                    imgArrow.setImageResource(R.drawable.i_down);
                    status = false;
                }
                else
                {
                    rOtherOption.setVisibility(View.GONE);
                    rProfileOption.setVisibility(View.VISIBLE);
                    imgArrow.setImageResource(R.drawable.i_up);
                    status = true;
                }
            }
        });

        rHome.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ((MainActivity)getActivity()).displaySelectedScreen(1, "Home");
            }
        });

        rMessage.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ((MainActivity)getActivity()).displaySelectedScreen(2, "Messages");
            }
        });
        rNotification.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ((MainActivity)getActivity()).displaySelectedScreen(3, "Notifications");
            }
        });
        rWatching.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ((MainActivity)getActivity()).displaySelectedScreen(4, "Watching");
            }
        });
        rSaved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).displaySelectedScreen(5, "Saved");
            }
        });
        rRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).displaySelectedScreen(6, "My Requests");
            }
        });
        rListing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).displaySelectedScreen(7, "My Listings");
            }
        });
        rHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).displaySelectedScreen(8, "Help & Contact");
            }
        });
        rSetting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).displaySelectedScreen(9, "Settings");
            }
        });
        rProfileItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((MainActivity)getActivity()).displaySelectedScreen(10, "My Profile");
            }
        });
        rSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               startActivity(new Intent(getActivity(), SplashActivity.class));
            }
        });
    }
}
