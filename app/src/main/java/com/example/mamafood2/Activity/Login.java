package com.example.mamafood2.Activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.mamafood2.R;
import com.example.mamafood2.model.User;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Login extends AppCompatActivity {
    public static ArrayList<User> listu = new ArrayList<>();
    public static ArrayList<User> listul = new ArrayList<>();
    public static boolean k = false;
    EditText edtuser, edtpass;
    Button btnlogin;
    User muser;
    TextView tvbot,signnow,tvmess;
    CheckBox cbsave;
    ProgressDialog progressDialog;

    long backp;
    @Override
    public void onBackPressed() {
        if (backp +2000 > System.currentTimeMillis()){
            finishAffinity();
            super.onBackPressed();
            return;
        }else {
            Toast.makeText(Login.this,"Nhấn thêm lần nữa để thoát",Toast.LENGTH_LONG).show();
        }
        backp = System.currentTimeMillis();

    }

    @Override
    protected void onResume() {
        super.onResume();
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.show();
                String txtuser = edtuser.getText().toString().trim();
                String txtpass = edtpass.getText().toString().trim();
                if (listu == null || listu.isEmpty()) {
                    return;
                }

                boolean isHasuser = false;
                for (User user : listu) {
                    if (txtuser.equals(user.getTdnU()) && txtpass.equals(user.getPassU())) {
                        isHasuser = true;
                        login(v);
                        muser = user;
                        k = true;
                        listul.clear();
                        listul.add(new User(user.getTenU(), user.getDiachiU(), user.getGmailU(), user.getAnhU(), user.getTdnU(), user.getPassU(), user.getMaU(), user.getSdtU()));
                    }
                    if(isHasuser == false){
                        progressDialog.dismiss();
                        tvmess.setText("Tài khoản hoặc mật khẩu không chính xác");
                    }else{
                        tvmess.setText("");
                    }
                }
                if (isHasuser == true) {

                    Intent i = new Intent(Login.this, MainActivity.class);
                    startActivity(i);
                }
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edtuser = findViewById(R.id.edtuser);
        edtpass = findViewById(R.id.edtpass);
        btnlogin = findViewById(R.id.btnlogin);
        cbsave = findViewById(R.id.cbsave);
        tvbot = findViewById(R.id.tvbot);
        signnow = findViewById(R.id.tvsignnow);
        tvmess = findViewById(R.id.tvmess);

        Typeface myTypeface = Typeface.createFromAsset(getAssets(), "fonts/UTM Androgyne_1.ttf"); // dat fonts
        tvbot.setTypeface(myTypeface);




        progressDialog = new ProgressDialog(this);
        progressDialog.dismiss();
        resto();
        signnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this,SignNow.class);
                startActivity(i);
            }
        });




        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Server.User, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                if (response != null) {
                    String tenU = "";
                    String diachiU = "";
                    String gmailU = "";
                    String anhU = "";
                    int maU = 0;
                    int sdtU = 0;
                    String TdnU = "";
                    String PassU = "";
                    for (int i = 0; i < response.length(); i++) {
                        try {
                            JSONObject jsonObject = response.getJSONObject(i);
                            tenU = jsonObject.getString("nameu");
                            diachiU = jsonObject.getString("adressu");
                            gmailU = jsonObject.getString("gmailu");
                            anhU = jsonObject.getString("imgu");
                            TdnU = jsonObject.getString("tdnu");
                            PassU = jsonObject.getString("passu");
                            maU = jsonObject.getInt("idu");
                            sdtU = jsonObject.getInt("numberu");
                            listu.add(new User(tenU, diachiU, gmailU, anhU, TdnU, PassU, maU, sdtU));
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

    public void login(View view) {
        SharedPreferences sharedPreferences = getSharedPreferences("file", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        String user = edtuser.getText().toString();
        String pass = edtpass.getText().toString();
        boolean check = cbsave.isChecked();
        if (!check) {
            editor.clear();
        } else {
            editor.putString("username", user);
            editor.putString("password", pass);
            editor.putBoolean("savestatus", check);
        }
        editor.commit();

    }

    private void resto() {
        SharedPreferences pref = getSharedPreferences("file", MODE_PRIVATE);
        boolean check = pref.getBoolean("savestatus", false);
        if (check) {
            String user = pref.getString("username", "");
            String pass = pref.getString("password", "");
            edtuser.setText(user);
            edtpass.setText(pass);
        }
        cbsave.setChecked(check);
    }

}