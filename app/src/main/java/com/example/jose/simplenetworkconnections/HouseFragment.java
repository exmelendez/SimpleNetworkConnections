package com.example.jose.simplenetworkconnections;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.jose.simplenetworkconnections.controller.HouseAdapter;
import com.example.jose.simplenetworkconnections.model.House;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.List;


public class HouseFragment extends Fragment {
    private static final String TAG = "Connection result";
    private static String BASE_URL = "http://jsjrobotics.nyc/cgi-bin/class_12_20_2016.pl";
    private RecyclerView recyclerView;
    private View mRoot;
    private HouseAdapter adapter;
    private List<House> houseList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectToServer(BASE_URL);
    }

    private void connectToServer(String baseUrl) {
        com.squareup.okhttp.OkHttpClient client = new com.squareup.okhttp.OkHttpClient();
        com.squareup.okhttp.Request request = new com.squareup.okhttp.Request.Builder()
                .url(baseUrl)
                .build();
        com.squareup.okhttp.Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(com.squareup.okhttp.Request request, IOException e) {
                Log.d(TAG,"Failed to connect");
            }

            @Override
            public void onResponse(Response response) throws IOException {
                try {
                    String jsonString = response.body().string();
                    JSONObject jsonObject = new JSONObject(jsonString);
                    JSONArray jsonArray = jsonObject.getJSONArray("houses");
                    houseList = new Gson().fromJson(jsonArray.toString(), new TypeToken<List<House>>(){}.getType());
                    adapter = new HouseAdapter(houseList);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
                    recyclerView.setAdapter(adapter);
                } catch (Exception e) {
                    Log.e(TAG,"Exception caught: ", e);
                }
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
