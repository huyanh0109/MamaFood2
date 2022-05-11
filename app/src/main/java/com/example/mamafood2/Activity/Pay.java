package com.example.mamafood2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mamafood2.HomeTab.Food;
import com.example.mamafood2.R;
import com.example.mamafood2.adapter.Cart2Adapter;
import com.example.mamafood2.model.User;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class Pay extends AppCompatActivity {
EditText edtname,edtsdt,edtadr;
TextView tvsumLL,tvsumKK;

    @Override
    protected void onResume() {
        super.onResume();
        int u =0;
        edtname.setText(Login.listul.get(u).getTenU());
        edtsdt.setText(Login.listul.get(u).getSdtU()+"");
        edtadr.setText(Login.listul.get(u).getDiachiU());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
        edtadr = findViewById(R.id.edtadr);
        edtname = findViewById(R.id.edtname);
        edtsdt = findViewById(R.id.edtsdt);
        tvsumKK =  findViewById(R.id.tvsumKK);
        tvsumLL = findViewById(R.id.tvsumLL);


        CartActivity.UpdateSum();
        long sum = 0;
        for (int i = 0; i< Food.listcart.size(); i++){
            sum+= Food.listcart.get(i).getGiaF();
        }
        if (Food.listcart.size()<1){
            Toast.makeText(getApplicationContext(),"Giỏ hàng đang trống, không thể thanh toán",Toast.LENGTH_SHORT).show();
            Intent it = new Intent(getApplicationContext(),CartActivity.class);
            startActivity(it);
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        tv_sumt.setText(decimalFormat.format(sum)+"đ");
//        long olg = Cart2Adapter.giamoinhat;
//        if (olg ==0) {
//            long old = (CartActivity.sum);
////        Bundle bundle = getIntent().getExtras();
////        Intent  i = getIntent();
////        String old = i.getIntExtra("sum",sum);
            tvsumKK.setText(sum + "");
            Double oldofold = Double.valueOf(sum * 10 / 100 + sum + 30000);
            tvsumLL.setText(oldofold + "₫");
//        }else {
//            tvsumKK.setText(olg + "");
//            Double oldofold = Double.valueOf(olg * 10 / 100 + olg + 30000);
//            tvsumLL.setText(oldofold + "₫");
//        }
    }

    public void backh(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        //  builder.setTitle("Delete");
        builder.setMessage("Đang thanh toán, bạn có muốn thoát?");
        builder.setCancelable(false);
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Pay.this, CartActivity.class);
                startActivity(intent);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.create().show();
    }
}