package com.example.mamafood2.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mamafood2.R;
import com.example.mamafood2.model.Photo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class IndexAdapter extends RecyclerView.Adapter<IndexAdapter.PhotoViewHolder> {
    List<Photo> lfood;

    public IndexAdapter(List<Photo> lfood) {
        this.lfood = lfood;
    }

    @Override
    public IndexAdapter.PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_photo, parent, false);

        return new IndexAdapter.PhotoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(IndexAdapter.PhotoViewHolder holder, int position) {
        Photo food = lfood.get(position);
        if (food == null) {
            return;
        }
        Picasso.get().load(food.getIdPhoto1()).placeholder(R.drawable.baseline_rotate_left_24).error(R.drawable.baseline_broken_image_24).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        if (lfood != null) {
            return lfood.size();
        }
        return 0;
    }


    public class PhotoViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;

        public PhotoViewHolder(@NonNull View iview) {
            super(iview);
            imageView = iview.findViewById(R.id.photo);
        }
    }
}
