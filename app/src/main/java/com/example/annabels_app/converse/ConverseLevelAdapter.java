package com.example.annabels_app.converse;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.annabels_app.R;

import java.util.ArrayList;

public class ConverseLevelAdapter extends RecyclerView.Adapter<ConverseLevelAdapter.MyViewHolder> {
    private Context mContext;
    private int categoryNumber;
    private ArrayList<ConverseLevels> levelBank;
    private ArrayList<ConverseCategories> categoryBank;

    // Constructor
    public ConverseLevelAdapter(Context context, ArrayList<ConverseLevels> levels, int categoryNumber, ArrayList<ConverseCategories> categoryBank) {
        this.levelBank = levels;
        this.mContext = context;
        this.categoryNumber = categoryNumber;
        this.categoryBank = categoryBank;
    }

    // Inflate learn_levels and return view
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_converse_level, parent, false);
        return new MyViewHolder(v);
    }

    // Replace contents of the view with data
    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.levelNameText.setText(levelBank.get(position).getLevelName());

        // On click buttons start respective activities and passes on the category
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if ((categoryBank.get(categoryNumber-1).getRelationshipType()).equals("self-reflect")) {
                    Intent intent2 = new Intent(mContext, ConverseCardSingle.class);
                    intent2.putExtra("Level Number", position+1);
                    String levelName = levelBank.get(position).getLevelName();
                    intent2.putExtra("Level Name",levelName);
                    intent2.putExtra("Category Number", categoryNumber);
                    intent2.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    mContext.startActivity(intent2); }
                 else {

                Intent intent = new Intent(mContext, ConverseCard.class);
                intent.putExtra("Level Number", position + 1);
                String levelName = levelBank.get(position).getLevelName();
                intent.putExtra("Level Name", levelName);
                intent.putExtra("Category Number", categoryNumber);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
            }

        }
        });
    }

    // Return size of dataset
    @Override
    public int getItemCount() {
        return levelBank.size();
    }

    // Create ViewHolder for learn_levels
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public CardView card;
        TextView levelNameText;

        public MyViewHolder(View itemView) {
            super(itemView);
            this.card = itemView.findViewById(R.id.cardView);
            this.levelNameText = itemView.findViewById(R.id.levelNameText);
        }
    }
}
