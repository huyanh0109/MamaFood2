package com.example.mamafood2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mamafood2.R;
import com.example.mamafood2.model.Notifi;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class NotifiAdapter extends RecyclerView.Adapter<NotifiAdapter.ViewHolder> {
    List<Notifi> notifis;
    Context context;

    public NotifiAdapter(Context context, List<Notifi> notifis) {
        this.context = context;
        this.notifis = notifis;
    }

    @Override
    public NotifiAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_notifi, null);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(NotifiAdapter.ViewHolder holder, int position) {
        Notifi notifi = notifis.get(position);
        holder.ntitle.setText(notifi.getTitleN());
        holder.ncontent.setText(notifi.getContentN());
        Picasso.get().load(notifi.getImgN()).placeholder(R.drawable.baseline_rotate_left_24).error(R
                .drawable.baseline_broken_image_24).into(holder.nimg);
    }

    @Override
    public int getItemCount() {
        return notifis.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView nimg;
        TextView ntitle, ncontent;

        public ViewHolder(View itemView) {
            super(itemView);
            nimg = itemView.findViewById(R.id.nimg);
            ncontent = itemView.findViewById(R.id.ncontent);
            ntitle = itemView.findViewById(R.id.ntitle);
        }
    }
}
