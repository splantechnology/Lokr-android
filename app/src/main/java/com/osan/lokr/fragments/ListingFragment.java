package com.osan.lokr.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.osan.lokr.R;
import com.osan.lokr.adapter.RecyclerAdapter;
import com.osan.lokr.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ListingFragment extends Fragment
{
    RecyclerView recyclerviewContainer;
    GridLayoutManager gridLayoutManager;
    List<Product> productList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_listing, container, false);
        recyclerviewContainer = (RecyclerView) view.findViewById(R.id.recyclerviewContainer);

        gridLayoutManager = new GridLayoutManager(getActivity(),3);
        recyclerviewContainer.setHasFixedSize(true);
        recyclerviewContainer.setLayoutManager(gridLayoutManager);

        productList.add(new Product(R.drawable.c9, "Headphone", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c8, "Chair", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c7, "Pendrive", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c6, "Mobile", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c5, "Cofee Table", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c4, "Laptop Table", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c2, "Camera", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c3, "Mobile", "₹ 150/Day"));
        productList.add(new Product(R.drawable.c1, "Camera", "₹ 250/Day"));
        productList.add(new Product(R.drawable.c9, "Headphone", "₹ 250/Day"));

        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(getActivity(), productList);
        recyclerviewContainer.setAdapter(recyclerAdapter);
        return view;
    }
}
