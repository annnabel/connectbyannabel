package com.example.annabels_app.converse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annabels_app.R;

import java.util.ArrayList;

public class ConverseCategoryAdapter extends RecyclerView.Adapter<ConverseCategoryAdapter.MyViewHolder> {
    private Context mContext;
    private ArrayList<ConverseCategories> categoryBank;

    // Constructor
    public ConverseCategoryAdapter(Context context, ArrayList<ConverseCategories> categoryBank) {
        this.categoryBank = categoryBank;
        this.mContext = context;
    }

    // Inflate learn_levels and return view
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.category, parent, false);
        return new MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        holder.categoryNameText.setText(categoryBank.get(position).getCategoryName());
        holder.relationshipText.setText(categoryBank.get(position).getRelationshipType().toUpperCase());
        switch(categoryBank.get(position).getRelationshipType()) {
            case "anyone":
                holder.imageView.setImageResource(R.drawable.anyone);
                break;
            case "couples":
                holder.imageView.setImageResource(R.drawable.couples);
                break;
            case "friends":
                holder.imageView.setImageResource(R.drawable.friends);                break;
            case "colleagues":
                holder.imageView.setImageResource(R.drawable.coworkers);                break;
            case "self-reflect":
                holder.imageView.setImageResource(R.drawable.mirror);                break;
        }

        // On click buttons start respective activities and passes on the category
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categoryBank.get(position).isLevels() == 0) {
                    Intent intent = new Intent(mContext, ConverseCard.class);
                    intent.putExtra("Category Number", position+1);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent); }
                else {
                    Intent intent2 = new Intent(mContext, LevelRecycler.class);
                    intent2.putExtra("Category Number", position+1);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent2);
                }
            }
        });
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return categoryBank.size();
    }

    // Create ViewHolder for learn_levels
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView card;
        TextView relationshipText;
        TextView categoryNameText;
        ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.card = itemView.findViewById(R.id.cardView);
            this.relationshipText = itemView.findViewById(R.id.relationshipText);
            this.categoryNameText = itemView.findViewById(R.id.categoryNameText);
            this.imageView = itemView.findViewById(R.id.imageView);
        }
    }
}
