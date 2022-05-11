package com.example.mamafood2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mamafood2.HomeTab.Food;
import com.example.mamafood2.R;
import com.example.mamafood2.model.Cart;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class CartAdapter extends BaseAdapter {
    Context context;
    ArrayList<Cart> cartlist;

    public CartAdapter(Context context, ArrayList<Cart> cartlist) {
        this.context = context;
        this.cartlist = cartlist;
    }

    @Override
    public int getCount() {
        if (cartlist != null) {
            return cartlist.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return cartlist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CViewHolder cViewHolder = null;
        if (convertView == null) {
            cViewHolder = new CViewHolder();
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_cart2, null);
            cViewHolder.imgcart = convertView.findViewById(R.id.imagecart);
//            cViewHolder.tvgiaf = convertView.findViewById(R.id.tvgiaf);
            cViewHolder.tvtenf = convertView.findViewById(R.id.tvtenf);
            cViewHolder.btnslf = convertView.findViewById(R.id.btnslf);
            cViewHolder.btncong = convertView.findViewById(R.id.btncong);
            cViewHolder.btntru = convertView.findViewById(R.id.btntru);
            convertView.setTag(cViewHolder);
        } else {
            cViewHolder = (CViewHolder) convertView.getTag();
        }
        Cart cart = (Cart) getItem(position);
        cViewHolder.tvtenf.setText(cart.getTenF());
//        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
//        cViewHolder.tvgiaf.setText(decimalFormat.format(cart.getGiaF()) + "");
        Picasso.get().load(cart.getHinhF()).into(cViewHolder.imgcart);
        cViewHolder.btnslf.setText(Integer.toString(cart.getSoluongF()));

//        int sl = Integer.parseInt(cViewHolder.btnslf.getText().toString());
//        if (sl<10){
//            cViewHolder.btntru.setVisibility(convertView.VISIBLE);
//            cViewHolder.btncong.setVisibility(convertView.INVISIBLE);
//        }else if (sl<=1){
//            cViewHolder.btntru.setVisibility(convertView.INVISIBLE);
//        }else if (sl>=1){
//            cViewHolder.btntru.setVisibility(convertView.INVISIBLE);
//            cViewHolder.btncong.setVisibility(convertView.VISIBLE);
//        }
//        int slud = Integer.parseInt(cViewHolder.btnslf.getText().toString()) +1;
//        cViewHolder.btncong.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                int slht = Food.listcart.get(position).getSoluongF();
////                long giaht = Food.listcart.get(position).getGiaF();
////                Food.listcart.get(position).setSoluongF(slud);
////                long giamoinhat = (giaht * slud) /slht;
////                Food.listcart.get(position).setGiaF(giamoinhat);
////                cViewHolder.tvgiaf.setText(decimalFormat.format());
//
//            }
//        });
//
//
//
//
//        notifyDataSetChanged();

        return convertView;
    }

    public class CViewHolder {
        ImageView imgcart,btntru,btncong;
        TextView tvtenf, tvgiaf,btnslf;
    }


}
