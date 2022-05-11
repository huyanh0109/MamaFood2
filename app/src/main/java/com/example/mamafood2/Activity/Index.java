package com.example.mamafood2.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mamafood2.HomeTab.Food;
import com.example.mamafood2.R;
import com.example.mamafood2.model.Photo;
import com.example.mamafood2.adapter.IndexAdapter;
import com.example.mamafood2.model.Cart;
import com.example.mamafood2.model.MamaFood;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import me.relex.circleindicator.CircleIndicator3;

public class Index extends AppCompatActivity {
    TextView tvidname, tvidprice, tvidinf, btnback;
    Button  btnthanhtoan;
    Spinner spinner;
    int id;
    int Gia;
    String Ten;
    String Hinh;
    ViewPager2 viewPager2;
    CircleIndicator3 indicator3;
    IndexAdapter indexAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_index);
        btnback = findViewById(R.id.btnback);
        tvidinf = findViewById(R.id.tvidinf);
        tvidprice = findViewById(R.id.tvidprice);
        tvidname = findViewById(R.id.tvidname);
        btnthanhtoan = findViewById(R.id.btnthanhtoan);
        spinner = findViewById(R.id.spinner);
        viewPager2 = findViewById(R.id.vp2);
        indicator3 = findViewById(R.id.cit);

        Bundle bundle = getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        MamaFood mamaFood = (MamaFood) bundle.get("food");
        tvidname.setText(mamaFood.getTenF());
        tvidprice.setText(decimalFormat.format((mamaFood.getGiaF())) + "₫" );
        tvidinf.setText("Mô tả:" +mamaFood.getMotaF());
        List<Photo> imglist = new ArrayList();
        imglist.add(new Photo(mamaFood.getHinhanhF()));
        imglist.add(new Photo(mamaFood.getHinhanhF2()));
        imglist.add(new Photo(mamaFood.getHinhanhF3()));
        QSpinner();
        id = mamaFood.getMaF();
        Gia = mamaFood.getGiaF();
        Ten = mamaFood.getTenF();
        Hinh = mamaFood.getHinhanhF();
        indexAdapter = new IndexAdapter(imglist);
        viewPager2.setAdapter(indexAdapter);
        indicator3.setViewPager(viewPager2);
        ProgressDialog progressDialog= new ProgressDialog(this)  ;
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void QSpinner() {
        Integer[] soluong = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line, soluong);
        spinner.setAdapter(arrayAdapter);
    }

    public void buy(View view) {
        if (Food.listcart.size() > 0) {
            int soluong = Integer.parseInt(spinner.getSelectedItem().toString());
            boolean tontaif = false;
            for (int i = 0; i < Food.listcart.size(); i++) {
                if (Food.listcart.get(i).getIdF() == id) {
                    Food.listcart.get(i).setSoluongF(Food.listcart.get(i).getSoluongF() + soluong);
                    if (Food.listcart.get(i).getSoluongF() >= 10) {
                        Food.listcart.get(i).setSoluongF(10);
                    }
                    Food.listcart.get(i).setGiaF(Gia * Food.listcart.get(i).getSoluongF());
                    tontaif = true;
                }
            }
            if (tontaif == false) {
                int sl1 = Integer.parseInt(spinner.getSelectedItem().toString());
                long tien2 = sl1 * Gia;
                Food.listcart.add(new Cart(id, sl1, tien2, Ten, Hinh));
            }
        } else {
            int sl2 = Integer.parseInt(spinner.getSelectedItem().toString());
            long tien2 = sl2 * Gia;
            Food.listcart.add(new Cart(id, sl2, tien2, Ten, Hinh));
        }
        if (Food.listcart.size()<1){
            Toast.makeText(getApplicationContext(),"Giỏ hàng rỗng",Toast.LENGTH_SHORT).show();
        }else {
            Intent i = new Intent(getApplicationContext(), CartActivity.class);
            startActivity(i);
        }
    }


}