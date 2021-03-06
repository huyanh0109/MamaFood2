package com.example.mamafood2.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.mamafood2.R;

import java.util.HashMap;
import java.util.Map;

public class SignNow extends AppCompatActivity {
    EditText edtnames, edtsdts, edtadrrs, edttdns, edtpasss, edtrepasss, edtgmails;
    TextView Nnames, Nsdts, Nadrrs, Ntdns, Npasss, Nrepasss, Ngmails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_now);
        edtnames = findViewById(R.id.edtnames);
        edtsdts = findViewById(R.id.edtnumbers);
        edtadrrs = findViewById(R.id.edtadrrs);
        edttdns = findViewById(R.id.edttdns);
        edtpasss = findViewById(R.id.edtpasss);
        edtrepasss = findViewById(R.id.edtrepasss);
        edtgmails = findViewById(R.id.edtgmails);

        Nnames = findViewById(R.id.Nnames);
        Nsdts = findViewById(R.id.Nnumbers);
        Nadrrs = findViewById(R.id.Nadrrs);
        Ntdns = findViewById(R.id.Ntdns);
        Npasss = findViewById(R.id.Npasss);
        Nrepasss = findViewById(R.id.Nrepasss);
        Ngmails = findViewById(R.id.Ngmails);

        String url = "https://huyanh0109999.000webhostapp.com/insertuser.php";
        findViewById(R.id.btnsignnow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean f=false;
                String x = edtpasss.getText().toString();
                if (edtnames.length() == 0) {
                    Nnames.setText("Kh??ng ????? tr???ng ph???n n??y!");
                } else
//                        int sdt = Integer.parseInt(edtsdts.getText().toString().trim());
//                        try {
//
//                        } catch (Exception e) {
//                            Nsdts.setText("Ch??a ????ng ?????nh d???ng s??? ??i???n tho???i");
//                        }
                    if (edtsdts.length() == 0) {
                        Nsdts.setText("Kh??ng ????? tr???ng ph???n n??y!");
                    } else if (edtsdts.length() != 10) {
                        Nsdts.setText("Ch??a ????ng ?????nh d???ng s??? ??i???n tho???i");
                    } else if (edttdns.length() == 0) {
                        Ntdns.setText("Kh??ng ????? tr???ng ph???n n??y!");
                    } else if (edttdns.length() < 6) {
                        Ntdns.setText("T??n ????ng nh???p ph???i c?? 6 k?? t???");
                    } else if (edtadrrs.length() == 0) {
                        Nadrrs.setText("Kh??ng ????? tr???ng ph???n n??y!");
                    } else if (edtpasss.length() < 6) {
                        Npasss.setText("M???t kh???u ph???i c?? 6 k?? t???");
                    } else if (edtgmails.length() == 0) {
                        Ngmails.setText("Kh??ng ????? tr???ng ph???n n??y!");
                    }else if (!isEmailValid(edtgmails.getText())){
                        Ngmails.setText("Kh??ng ????ng ?????nh d???ng email");

                    } else if (!edtrepasss.getText().toString().equals(x)) {
                        Nrepasss.setText("M???t kh???u kh??ng gi???ng nhau");
                    } else {
                        f = true;
                        if (f = true) {
                            AddUser(url);
                        }
                    }

            }
        });

    }
    boolean isEmailValid(CharSequence email) {
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email)
                .matches();
    }
    public void backh(View view) {
        Intent i = new Intent(SignNow.this, Login.class);
        startActivity(i);
    }
    public void AddUser(String url){
        RequestQueue queue  = Volley.newRequestQueue(this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (response.trim().equals("success")) {
                    Toast.makeText(getApplicationContext(), "T???o th??nh c??ng", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(SignNow.this, Login.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"L???i th??m",Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(),"???? x???y ra l???i",Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("nameU", edtnames.getText().toString());
                params.put("tdnU", edttdns.getText().toString().trim());
                params.put("passU", edtpasss.getText().toString().trim());
      //          params.put("imgU", edtnames.getText().toString().trim());
                params.put("adressU", edtadrrs.getText().toString());
                params.put("gmailU", edtgmails.getText().toString().trim());
                params.put("numberU", edtsdts.getText().toString().trim());
                return params;
            }
        };
        queue.add(stringRequest);
    }
}