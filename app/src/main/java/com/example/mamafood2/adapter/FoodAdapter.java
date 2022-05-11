package com.example.mamafood2.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mamafood2.Activity.Index;
import com.squareup.picasso.Picasso;
import com.example.mamafood2.R;
import com.example.mamafood2.model.MamaFood;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewholder> implements Filterable {
    Context context;
    private List<MamaFood> mlistF;
    private List<MamaFood> mlistOld;

    public FoodAdapter(Context context, List<MamaFood> mlistF) {
        this.mlistF = mlistF;
        this.context = context;
        this.mlistOld = mlistF;
    }

    @Override
    public FoodViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_food, null);
        FoodViewholder foodViewholder = new FoodViewholder(view);
        return foodViewholder;
    }

    @Override
    public void onBindViewHolder(FoodViewholder holder, int position) {
        MamaFood food = mlistF.get(position);
        if (food == null) {
            return;
        }
        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        holder.nameF.setText(food.getTenF());
        holder.priceF.setText(decimalFormat.format(food.getGiaF()) + "đ");
//        holder.motaF.setText("Mô tả:"+food.getMotaF());
        Picasso.get().load(food.getHinhanhF()).placeholder(R.drawable.baseline_rotate_left_24).error(R.drawable.baseline_broken_image_24).into(holder.hinhanhF);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToIndex(food);
            }
        });
    }

    public void goToIndex(MamaFood mamaFood) {
        Intent i = new Intent(context, Index.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("food", mamaFood);
        i.putExtras(bundle);
        context.startActivity(i);
    }

    @Override
    public int getItemCount() {
        return mlistF.size();
    }

    @Override
    public Filter getFilter() {
        return new Filter() {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {
                String strSearch = constraint.toString();
                if (strSearch.isEmpty()) {
                    mlistF = mlistOld;
                } else {
                    List<MamaFood> listsf = new ArrayList<>();
                    for (MamaFood mamaFood : mlistOld) {
                        if (mamaFood.getTenF().toLowerCase().contains(strSearch.toLowerCase())) {
                            listsf.add(mamaFood);
                        }
                        ;
                    }
                    mlistF = listsf;
                }
                FilterResults filterResults = new FilterResults();
                filterResults.values = mlistF;
                return filterResults;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                mlistF = (List<MamaFood>) results.values;
                notifyDataSetChanged();
            }
        };
    }

    public class FoodViewholder extends RecyclerView.ViewHolder {
        private TextView nameF, priceF, motaF;
        private ImageView hinhanhF;
        CardView cardView;

        public FoodViewholder(View itemView) {
            super(itemView);
            nameF = itemView.findViewById(R.id.nameF);
            priceF = itemView.findViewById(R.id.priceF);
            hinhanhF = itemView.findViewById(R.id.hinhanhF);
            cardView = itemView.findViewById(R.id.cvf);
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.transition);
        }

    }
}
