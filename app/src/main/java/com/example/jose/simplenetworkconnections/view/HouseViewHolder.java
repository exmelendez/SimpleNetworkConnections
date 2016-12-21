package com.example.jose.simplenetworkconnections.view;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.jose.simplenetworkconnections.R;
import com.example.jose.simplenetworkconnections.model.House;

public class HouseViewHolder extends RecyclerView.ViewHolder {
    private final View mRoot;
    private TextView styleTextView;
    private TextView priceTextView;
    private TextView locationTextView;

    public HouseViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mRoot = itemView;
        styleTextView = (TextView) mRoot.findViewById(R.id.style_text_view);
        priceTextView = (TextView) mRoot.findViewById(R.id.price_text_view);
        locationTextView = (TextView) mRoot.findViewById(R.id.location_text_view);
    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.house_list_item,parent,false);
    }

    public void bind(House house) {
        styleTextView.setText(house.getStyle());
        priceTextView.setText(house.getPrice());
        locationTextView.setText(house.getLocation());
    }
}
