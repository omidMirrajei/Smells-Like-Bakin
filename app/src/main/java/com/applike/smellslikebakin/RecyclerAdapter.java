package com.applike.smellslikebakin;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by omid mirrajei on 29/09/2019
 */
public abstract class RecyclerAdapter extends RecyclerView.Adapter {

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(getLayoutId(), viewGroup, false);
        return new ListViewHolder(view);
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int i) {
        ((ListViewHolder) holder).bindView(i);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView textViewItem;
        private ImageView imageViewItem;
        private int mIndex;

        public ListViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewItem = itemView.findViewById(R.id.text_item);
            imageViewItem = itemView.findViewById(R.id.image_item);

            itemView.setOnClickListener(this);

        }

        public void bindView(int position) {
            mIndex = position;
            textViewItem.setText(Recipes.names[position]);
            imageViewItem.setImageResource(Recipes.resourceIds[position]);
        }

        @Override
        public void onClick(View v) {
            onRecipeSelected(mIndex);
        }
    }

    protected abstract void onRecipeSelected(int mIndex);
}
