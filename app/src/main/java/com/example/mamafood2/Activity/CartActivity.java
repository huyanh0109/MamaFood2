package com.example.mamafood2.Activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mamafood2.HomeTab.Food;
import com.example.mamafood2.R;
import com.example.mamafood2.adapter.Cart2Adapter;
import com.example.mamafood2.adapter.CartAdapter;
import com.example.mamafood2.model.Cart;


import java.text.DecimalFormat;

public class CartActivity extends AppCompatActivity {
    RecyclerView rcv_pay;
    static TextView tv_sumt,btnbackp;
    Cart2Adapter cartAdapter;
    RelativeLayout rlt;
    public static long sum;
    TextView tvmess;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        rcv_pay = findViewById(R.id.rcv_pay);
        tv_sumt = findViewById(R.id.tv_sumt);
        btnbackp = findViewById(R.id.btnbackp);
        rlt = findViewById(R.id.rlt);
        tvmess =findViewById(R.id.tvmess);
        btnbackp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CartActivity.this, MainActivity.class);
                startActivity(i);

            }
        });
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        rcv_pay.setHasFixedSize(true);
        rcv_pay.setLayoutManager(linearLayoutManager);
                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(getApplicationContext(),DividerItemDecoration.VERTICAL);
        rcv_pay.addItemDecoration(dividerItemDecoration);
        cartAdapter = new Cart2Adapter(this, Food.listcart);
        rcv_pay.setAdapter(cartAdapter);
         sum = 0;
        for (int i = 0; i< Food.listcart.size(); i++){
            sum+= Food.listcart.get(i).getGiaF();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tv_sumt.setText(decimalFormat.format(sum)+"đ");
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0,ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove( RecyclerView recyclerView, @NonNull  RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped( RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();

                        Food.listcart.remove(position);
                        cartAdapter.notifyDataSetChanged();
                        UpdateSum();
                Toast.makeText(getApplicationContext(),"Đã Xóa",Toast.LENGTH_SHORT).show();
                    }
                });
    itemTouchHelper.attachToRecyclerView(rcv_pay);
    cartAdapter.notifyDataSetChanged();
    UpdateSum();
    CheckData();
    }
    public static void UpdateSum(){
        long sum = 0;
        for (int i = 0; i< Food.listcart.size(); i++){
            sum+= Food.listcart.get(i).getGiaF();
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tv_sumt.setText(decimalFormat.format(sum)+"đ");
    }
    void  CheckData()
    {
        if(Food.listcart.size()<=0)
        {
            cartAdapter.notifyDataSetChanged();
             tvmess.setVisibility(View.VISIBLE);
            rcv_pay.setVisibility(View.INVISIBLE);
        }
        else
        {
            cartAdapter.notifyDataSetChanged();
            tvmess.setVisibility(View.INVISIBLE);
            rcv_pay.setVisibility(View.VISIBLE);
        }
    }

    public void pay(View view) {
        if (sum != 0) {
            Intent i = new Intent(getApplicationContext(), Pay.class);
            startActivity(i);
        }else {Toast.makeText(getApplicationContext(),"Giỏ hàng đang trống",Toast.LENGTH_LONG).show();}
    }
}
