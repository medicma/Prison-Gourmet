package com.wolfenterprisesllc.prisongourmet;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class RecyclerViewAdapter
        extends RecyclerView.Adapter
        <RecyclerViewAdapter.ListItemViewHolder> {

    private List<RecipieHolder> items;


    Integer choiceMade;

    RecyclerViewAdapter(List<RecipieHolder> items) {
        this.items = items;
    }


    public class ListItemViewHolder extends RecyclerView.ViewHolder implements RecyclerTouchListener.ClickListener {
        CardView cv;
        TextView recipie;
        ImageView picture;


        ListItemViewHolder(View view) {
            super(view);
            cv = view.findViewById(R.id.cv);
            recipie = view.findViewById(R.id.txt_recipie);
            recipie.setTypeface(null, Typeface.ITALIC);
            picture = view.findViewById(R.id.img_image);
        }

        @Override
        public void onClick(View view, int position) {
        }

        @Override
        public void onLongClick(View view, int position) {
        }

        public ListItemViewHolder(LayoutInflater inflater, final ViewGroup parent) {
            super(inflater.inflate(R.layout.activity_recipie, parent, false));
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
        }
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.common_item_layout, parent, false);
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        itemView.setLayoutParams(lp);
        return new RecyclerViewAdapter.ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerViewAdapter.ListItemViewHolder holder, int position) {
        //
        RecipieHolder recipieHolder = items.get(position);
        try {
            ImageView imageView = holder.picture;
            holder.recipie.setText(items.get(position).getRecipie());
            imageView.setImageResource(R.drawable.cake3);   //this sets the picture but it should
            //read.....imageView.setImageResource(dataSet.get(listPosition).getImage());
        } catch (Exception e) {

        }
    }

    @Override
    public int getItemCount() {
        try {
            return items.size();
        } catch (Exception e) {
            return items.size();
        }
    }
}
//https://stackoverflow.com/questions/30691150/match-parent-width-does-not-work-in-recyclerview
