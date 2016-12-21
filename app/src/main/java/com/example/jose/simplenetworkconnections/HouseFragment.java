package com.example.jose.simplenetworkconnections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jose.simplenetworkconnections.backend.HouseService;
import com.example.jose.simplenetworkconnections.controller.HouseAdapter;
import com.example.jose.simplenetworkconnections.model.HouseResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class HouseFragment extends Fragment {
    private static final String TAG = "Connection result";
    private static String BASE_URL = "http://jsjrobotics.nyc/cgi-bin/";
    private RecyclerView recyclerView;
    private View mRoot;
    private HouseAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectToServer(BASE_URL);
    }

    private void connectToServer(String baseUrl) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build();
        HouseService service = retrofit.create(HouseService.class);
        Call<HouseResponse> call = service.getHouses();
        call.enqueue(new Callback<HouseResponse>() {
            @Override
            public void onResponse(Call<HouseResponse> call, Response<HouseResponse> response) {
                adapter = new HouseAdapter(response.body());
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<HouseResponse> call, Throwable t) {
                Log.d(TAG,"Failed to connect");
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.house_fragment,parent,false);
        recyclerView = (RecyclerView) mRoot.findViewById(R.id.recycler_view);
        return mRoot;
    }
}
