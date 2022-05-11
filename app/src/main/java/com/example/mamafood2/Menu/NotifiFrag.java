package com.example.mamafood2.Menu;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mamafood2.Activity.CheckConnect;
import com.example.mamafood2.R;
import com.example.mamafood2.Activity.Server;
import com.example.mamafood2.adapter.NotifiAdapter;
import com.example.mamafood2.model.Notifi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class NotifiFrag extends Fragment {
NotifiAdapter notifiAdapter;
RecyclerView recyclerView;
ArrayList<Notifi> lnotifi;

    public NotifiFrag(){}
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_notifi_frag,container,false);
    }
    @Override
    public void onViewCreated( View view,  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcv_noti);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        lnotifi = new ArrayList<>();
        notifiAdapter = new NotifiAdapter(getContext(),lnotifi);
        recyclerView.setAdapter(notifiAdapter);
        if (CheckConnect.haveNetworkConnection(getContext())) {
            getFood();
        }
    }

    void getFood(){
        RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Notifi, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int MaN = 0;
                    String TenN = "";
                    String MotaN = "";
                    String HinhanhN = "";
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            MaN = jsonObject.getInt("man");
                            TenN = jsonObject.getString("tenn");
                            HinhanhN = jsonObject.getString("hinhanhn");
                            MotaN = jsonObject.getString("motan");
                                lnotifi.add(new Notifi(MaN, TenN, MotaN,HinhanhN));
                                notifiAdapter.notifyDataSetChanged();
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        queue.add(jsonArrayRequest);
    }
}