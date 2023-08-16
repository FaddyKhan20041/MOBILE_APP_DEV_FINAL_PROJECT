package com.my.fruit;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends ListAdapter<Fruit, FruitAdapter.FruitViewHolder> {

    private OnItemClickListener onItemClickListener;

    protected FruitAdapter() {
        super(DIFF_CALLBACK);
    }

    private static final DiffUtil.ItemCallback<Fruit> DIFF_CALLBACK = new DiffUtil.ItemCallback<Fruit>() {
        @Override
        public boolean areItemsTheSame(@NonNull Fruit oldItem, @NonNull Fruit newItem) {
            return oldItem.getId() == newItem.getId();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Fruit oldItem, @NonNull Fruit newItem) {
            return oldItem.equals(newItem);
        }
    };

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_fruit, parent, false);
        return new FruitViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) {
        Fruit currentFruit = getItem(position);
        holder.fruitNameTextView.setText(currentFruit.getName());

        // Set click listener on the itemView
        holder.itemView.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(currentFruit);
            }
        });
    }

    public void setFruits(List<Fruit> fruits) {
    }

    public interface OnItemClickListener {
        void onItemClick(Fruit fruit);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.onItemClickListener = listener;
    }

    static class FruitViewHolder extends RecyclerView.ViewHolder {
        private TextView fruitNameTextView;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            fruitNameTextView = itemView.findViewById(R.id.fruit_name);
        }
    }
}
