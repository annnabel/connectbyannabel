package com.example.annabels_app.drink;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annabels_app.R;
import com.example.annabels_app.converse.ConverseCard;
import com.example.annabels_app.converse.ConverseCardSingle;
import com.example.annabels_app.converse.ConverseCategories;
import com.example.annabels_app.converse.ConverseCategoryAdapter;
import com.example.annabels_app.converse.LevelRecycler;

import java.util.ArrayList;

public class DrinkAdapter extends RecyclerView.Adapter<DrinkAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<Question> categoryBank;

    public DrinkAdapter(Context context, ArrayList<Question> categoryBank) {
        this.categoryBank = categoryBank;
        this.mContext = context;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.drink_category, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.categoryNameText.setText(categoryBank.get(position).getCategoryName());
        switch(position) {
            case 0:
                holder.imageView.setImageResource(R.drawable.never_have_i_ever);
                break;
            case 1:
                holder.imageView.setImageResource(R.drawable.voting_game);
                break;
            case 2:
                holder.imageView.setImageResource(R.drawable.check);                break;
            case 3:
                holder.imageView.setImageResource(R.drawable.do_drink);                break;
        }
        holder.card.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                    Intent intent = new Intent(mContext, ConverseCardSingle.class);
                    intent.putExtra("Category Number", position + 1);
                    intent.putExtra("Drink", 1);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return categoryBank.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView card;
        TextView categoryNameText;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.card = itemView.findViewById(R.id.cardView);
            this.categoryNameText = itemView.findViewById(R.id.categoryNameText);
            this.imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
