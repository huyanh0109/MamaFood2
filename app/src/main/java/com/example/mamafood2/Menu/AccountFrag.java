package com.example.mamafood2.Menu;

import androidx.fragment.app.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.mamafood2.Activity.Login;
import com.example.mamafood2.R;

public class AccountFrag extends Fragment {
    public AccountFrag() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_account_frag, container, false);
    }

    TextView tvname, tvsdt, tvthanhpho, tvgmail;
    Button btnout;


    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvname = view.findViewById(R.id.tvname);
        tvsdt = view.findViewById(R.id.tvsdt);
        tvthanhpho = view.findViewById(R.id.tvthanhpho);
        tvgmail = view.findViewById(R.id.tvgmail);
        btnout = view.findViewById(R.id.logout);

        int i = 0;
            String name = Login.listul.get(i).getTenU();
            tvname.setText(name);
            tvthanhpho.setText(Login.listul.get(i).getDiachiU());
            tvsdt.setText(Login.listul.get(i).getSdtU() + "");
            tvgmail.setText(Login.listul.get(i).getGmailU());
        btnout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
              //  builder.setTitle("Delete");
                builder.setMessage("Bạn có muốn đăng xuất?");
                builder.setCancelable(true);
                builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(getContext(), Login.class);
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
        });
    }


}