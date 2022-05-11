package com.example.mamafood2.Test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.example.mamafood2.HomeTab.Food;
import com.example.mamafood2.R;
import com.example.mamafood2.adapter.CartAdapter;

import java.text.DecimalFormat;

public class Order extends AppCompatActivity {
    ListView lv_pay;
    TextView tv_sum;
    CartAdapter cartAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_pay);
        lv_pay = findViewById(R.id.lv_pay);
        tv_sum = findViewById(R.id.tv_sum);

        cartAdapter = new CartAdapter(this, Food.listcart);
        lv_pay.setAdapter(cartAdapter);
        UpdateSum();
        CheckData();
    }
    public void UpdateSum(){
        long sum = 0;
        for (int i = 0; i< Food.listcart.size(); i++){
            sum+= Food.listcart.get(i).getGiaF();

        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        tv_sum.setText(decimalFormat.format(sum)+"đ");
    }
    void  CheckData()
    {
        if(Food.listcart.size()<=0)
        {
            cartAdapter.notifyDataSetChanged();
            // txtThongbao.setVisibility(View.VISIBLE);
            lv_pay.setVisibility(View.INVISIBLE);
        }
        else
        {
            cartAdapter.notifyDataSetChanged();
//            txtThongbao.setVisibility(View.INVISIBLE);
            lv_pay.setVisibility(View.VISIBLE);
        }
    }
}