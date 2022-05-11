package com.example.mamafood2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.mamafood2.HomeTab.Food;
import com.example.mamafood2.R;
import com.example.mamafood2.Activity.CartActivity;
import com.example.mamafood2.model.Cart;
import com.squareup.picasso.Picasso;

import java.text.DecimalFormat;
import java.util.List;

public class Cart2Adapter extends RecyclerView.Adapter<Cart2Adapter.CartViewHolder> {
    Context context;
    private List<Cart> llistF;
    public static long giamoinhat;
    public Cart2Adapter(Context context, List<Cart> llistF){
        this.llistF = llistF;
        this.context = context;
}
    @Override
    public CartViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cart,null);
        CartViewHolder cartViewHolder = new CartViewHolder(view);
        return cartViewHolder;
    }
    @Override
    public void onBindViewHolder(Cart2Adapter.CartViewHolder holder, int position) {
        Cart cart = llistF.get(position);

            holder.tvtenf.setText(cart.getTenF());
            DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
            holder.tvgiaf.setText(decimalFormat.format(cart.getGiaF()) + "₫");
            Picasso.get().load(cart.getHinhF()).into(holder.imgcart);
            holder.btnslf.setText(Integer.toString(cart.getSoluongF()));


        int sl = Integer.parseInt(holder.btnslf.getText().toString());
        if (sl>=10){
            holder.btntru.setVisibility(View.VISIBLE);
            holder.btncong.setVisibility(View.INVISIBLE);
        }else if (sl<=1){
            holder.btntru.setVisibility(View.INVISIBLE);
        }else if (sl>=1){
            holder.btntru.setVisibility(View.VISIBLE);
            holder.btncong.setVisibility(View.VISIBLE);
        }

        holder.btncong.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slud = Integer.parseInt(holder.btnslf.getText().toString()) +1;
                int slht = Food.listcart.get(position).getSoluongF();
                long giaht = Food.listcart.get(position).getGiaF();
                Food.listcart.get(position).setSoluongF(slud);
                giamoinhat = (giaht * slud) /slht;
                Food.listcart.get(position).setGiaF(giamoinhat);
                holder.tvgiaf.setText(decimalFormat.format(giamoinhat)+"₫");
                CartActivity.UpdateSum();
                if (slud >9){
                    holder.btntru.setVisibility(View.VISIBLE);
                    holder.btncong.setVisibility(View.INVISIBLE);
                    holder.btnslf.setText(String.valueOf(slud));
                }else {
                    holder.btntru.setVisibility(View.VISIBLE);
                    holder.btncong.setVisibility(View.VISIBLE);
                    holder.btnslf.setText(String.valueOf(slud));
                }
            }
        });
        holder.btntru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int slud = Integer.parseInt(holder.btnslf.getText().toString()) -1;
                int slht = Food.listcart.get(position).getSoluongF();
                long giaht = Food.listcart.get(position).getGiaF();
                Food.listcart.get(position).setSoluongF(slud);
                 giamoinhat = (giaht * slud) /slht;
                Food.listcart.get(position).setGiaF(giamoinhat);
                holder.tvgiaf.setText(decimalFormat.format(giamoinhat)+"₫");
                CartActivity.UpdateSum();
                if (slud <2){
                    holder.btncong.setVisibility(View.VISIBLE);
                    holder.btntru.setVisibility(View.INVISIBLE);
                    holder.btnslf.setText(String.valueOf(slud));
                }else {
                    holder.btntru.setVisibility(View.VISIBLE);
                    holder.btncong.setVisibility(View.VISIBLE);
                    holder.btnslf.setText(String.valueOf(slud));
                }
            }
        });
    }
    @Override
    public int getItemCount() {
        if (llistF != null) {
            return llistF.size();
        }
        return 0;

    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        ImageView imgcart,btntru,btncong;
        TextView tvtenf, tvgiaf,btnslf;
        public CartViewHolder( View itemView) {
            super(itemView);
            imgcart = itemView.findViewById(R.id.imagecart);
            tvgiaf = itemView.findViewById(R.id.tvgiaf);
            tvtenf = itemView.findViewById(R.id.tvtenf);
            btnslf = itemView.findViewById(R.id.btnslf);
            btncong = itemView.findViewById(R.id.btncong);
            btntru = itemView.findViewById(R.id.btntru);
        }
    }
    }
