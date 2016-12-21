package com.example.jose.simplenetworkconnections.controller;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.jose.simplenetworkconnections.model.House;
import com.example.jose.simplenetworkconnections.view.HouseViewHolder;

import java.util.List;


public class HouseAdapter  extends RecyclerView.Adapter<HouseViewHolder> {
    private final List<House> houseList;

    public HouseAdapter(List<House> data) {
        this.houseList = data;
    }

    @Override
    public HouseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HouseViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(HouseViewHolder holder, int position) {
        holder.bind(houseList.get(position));
    }

    @Override
    public int getItemCount() {
        return houseList.size();
    }
}
