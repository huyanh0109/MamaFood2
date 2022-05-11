package com.example.mamafood2.Menu;

import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mamafood2.HomeTab.Food;
import com.example.mamafood2.R;
import com.example.mamafood2.Activity.CartActivity;
import com.example.mamafood2.adapter.CartAdapter;

import java.text.DecimalFormat;

public class OrderFrag extends Fragment {
    public OrderFrag() {
    }

    ListView recyclerView;
    TextView tv_sumk;
    CartAdapter cartAdapter;
    Button btnpaym;
    TextView tvmess;
  //  Cart2Adapter testCartAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_order_frag, container, false);
    }
    ListView lv_pay;
    TextView tv_sum;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        recyclerView = view.findViewById(R.id.rcv_pay);
        tv_sumk = view.findViewById(R.id.tv_sumk);
        btnpaym = view.findViewById(R.id.btnpaym);
        tvmess = view.findViewById(R.id.tvmess);

        btnpaym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), CartActivity.class);
                startActivity(i);
            }
        });
        cartAdapter = new CartAdapter(getContext(), Food.listcart);
        recyclerView.setAdapter(cartAdapter);
        CheckData();
        UpdateSum();

    }

    public void UpdateSum() {
        long sum = 0;
        if (Food.listcart == null) {
            return;
        } else {
            for (int i = 0; i < Food.listcart.size(); i++) {
                sum += Food.listcart.get(i).getGiaF();

            }
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            tv_sumk.setText(decimalFormat.format(sum) + "đ");
        }
    }

    void  CheckData()
    {

        if (Food.listcart == null) {
            cartAdapter.notifyDataSetChanged();
             tvmess.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.INVISIBLE);
        } else {
            cartAdapter.notifyDataSetChanged();
            tvmess.setVisibility(View.INVISIBLE);
            recyclerView.setVisibility(View.VISIBLE);
        }
    }
}