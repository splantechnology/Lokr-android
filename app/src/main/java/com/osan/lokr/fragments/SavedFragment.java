package com.osan.lokr.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.osan.lokr.R;

public class SavedFragment extends Fragment
{
    LinearLayout linearLayoutContainer;
    String [] month = {"September 2018", "August 2018", "July 2018"};
    int[] msg = new int[] {3, 2, 4};

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_saved, container, false);
        linearLayoutContainer = (LinearLayout) view.findViewById(R.id.linearLayoutContainer);
        addData();
        return view;
    }
    private void addData()
    {
        linearLayoutContainer.removeAllViews();
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        for (int i = 0; i < month.length; i++)
        {
            View view = inflater.inflate(R.layout.layout_saved_month, null);
            TextView tvMonth = (TextView) view.findViewById(R.id.tvMonth);
            tvMonth.setText(month[i]);
            linearLayoutContainer.addView(view);
            for (int j = 0; j < msg.length; j++)
            {
                View viewChild = inflater.inflate(R.layout.layout_saved, null);
                TextView tvName = (TextView) viewChild.findViewById(R.id.tvName);
                ImageView imgType = (ImageView) viewChild.findViewById(R.id.imgType);
                if (j==2)
                {
                    imgType.setImageResource(R.drawable.i_hanshake);
                }
                linearLayoutContainer.addView(viewChild);
            }
        }
    }
}
