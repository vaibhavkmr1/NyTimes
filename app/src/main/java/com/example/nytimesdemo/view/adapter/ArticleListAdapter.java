package com.example.nytimesdemo.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nytimesdemo.R;
import com.example.nytimesdemo.dao.Result;
import com.example.nytimesdemo.view.ui.ItemClickListner;

import java.util.List;

public class ArticleListAdapter extends RecyclerView.Adapter<ArticleListAdapter.MyViewHolder> {
    private final ItemClickListner itemClickListener;
    List<Result> results;

    public ArticleListAdapter(List<Result> results, ItemClickListner itemClickListner) {
        this.results = results;
        this.itemClickListener = itemClickListner;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.title.setText(results.get(position).getTitle());
        holder.date.setText(results.get(position).getPublishedDate());
        holder.by.setText(results.get(position).getByline());


    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView date;
        public TextView by;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title_textview);
            date = itemView.findViewById(R.id.date_textview);
            by = itemView.findViewById(R.id.by_textview);

            itemView.setOnClickListener(view -> {
                itemClickListener.onItemClicked(results.get(getAdapterPosition()).getAbstract(),
                        results.get(getAdapterPosition()).getTitle());
            });
        }
    }
}
