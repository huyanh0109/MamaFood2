package com.example.mamafood2.HomeTab;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mamafood2.Activity.CheckConnect;
import com.example.mamafood2.R;
import com.example.mamafood2.Activity.Server;
import com.example.mamafood2.adapter.FoodAdapter;
import com.example.mamafood2.model.Cart;
import com.example.mamafood2.model.MamaFood;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.android.volley.RequestQueue;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Food extends Fragment {
    public Food() {

    }
    public static ArrayList<Cart> listcart;
    ArrayList<MamaFood> listFood;
    FoodAdapter foodAdapter;
    private RecyclerView recyclerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_food, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        SearchView searchView=view.findViewById(R.id.search_food);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                foodAdapter.getFilter().filter(newText);
                return false;
            }
        });


        if (listcart!=null){

        }else{
            listcart= new ArrayList<>();
        }

        recyclerView = view.findViewById(R.id.rcv_food);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);
//        RecyclerView.ItemDecoration itemDecoration = new DividerItemDecoration(getContext(),DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(itemDecoration);
//        recyclerView.addItemDecoration( new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
// //       itemDecorator.setDrawable(ContextCompat.getDrawable(getContext(),R.drawable.divider));
//        recyclerView.setItemAnimator(new DefaultItemAnimator());
        listFood =new ArrayList<>();
        foodAdapter = new FoodAdapter(getContext(),listFood);
        recyclerView.setAdapter(foodAdapter);
        if (CheckConnect.haveNetworkConnection(getContext())) {
            getFood();
        }

    }


//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL);
//        recyclerView.addItemDecoration(dividerItemDecoration);
//        mlistf = new ArrayList<>();
//        adapter = new FoodAdapter(mlistf);
//        recyclerView.setAdapter(adapter);
//        getListRealTime();
//    }
//
//    private void getListRealTime() {
//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myref = database.getReference("list_food");
//
//        myref.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange( DataSnapshot snapshot) {
//            for (DataSnapshot dataSnapshot : snapshot.getChildren()){
//                MamaFood mamaFood = dataSnapshot.getValue(MamaFood.class);
//                mlistf.add(mamaFood);
//            }
//            adapter.notifyDataSetChanged();
//            }
//
//            @Override
//            public void onCancelled( DatabaseError error) {
//                Toast.makeText(getActivity(), "Get list fail", Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
    void getFood(){
RequestQueue queue = Volley.newRequestQueue(getContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.Food, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    int MaF = 0;
                    String TenF = "";
                    int IdF = 0;
                    String MotaF = "";
                    String HinhanhF = "";
                    String HinhanhF2 = "";
                    String HinhanhF3 = "";
                    int GiaF = 0;
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            MaF = jsonObject.getInt("maf");
                            TenF = jsonObject.getString("tenf");
                            GiaF = jsonObject.getInt("giaf");
                            HinhanhF = jsonObject.getString("hinhanhf");
                            HinhanhF2 = jsonObject.getString("hinhanhf2");
                            HinhanhF3 = jsonObject.getString("hinhanhf3");

                            MotaF = jsonObject.getString("motaf");
                            IdF = jsonObject.getInt("id");
                            if (IdF ==1) {
                                listFood.add(new MamaFood(TenF, MotaF, HinhanhF,HinhanhF2,HinhanhF3, GiaF, MaF, IdF));
                                foodAdapter.notifyDataSetChanged();
                            }else {

                            }
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