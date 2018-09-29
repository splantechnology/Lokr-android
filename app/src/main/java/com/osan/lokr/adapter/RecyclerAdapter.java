package com.osan.lokr.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.osan.lokr.R;
import com.osan.lokr.model.Product;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.MyHolder>
{
    private Context context;
    private List<Product> productList;

    public RecyclerAdapter(Context context, List<Product> productList)
    {
        this.context = context;
        this.productList = productList;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_product_grid, null);
        MyHolder myHolder = new MyHolder(view);
        return myHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int i)
    {
        holder.imgProduct.setImageResource(productList.get(i).getThumbUrl());
        holder.tvName.setText(productList.get(i).getName());
        holder.tvPrice.setText(productList.get(i).getPrice());
    }

    @Override
    public int getItemCount()
    {
        return productList.size();
    }

    public static class MyHolder extends RecyclerView.ViewHolder
    {
        ImageView imgProduct;
        TextView tvName;
        TextView tvPrice;

        public MyHolder(View itemView)
        {
            super(itemView);
            imgProduct = (ImageView) itemView.findViewById(R.id.imgProduct);
            tvName = (TextView) itemView.findViewById(R.id.tvName);
            tvPrice = (TextView) itemView.findViewById(R.id.tvPrice);
        }
    }
}
