package com.example.annabels_app.converse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.annabels_app.R;
import com.example.annabels_app.converse.ConverseCategories;
import com.example.annabels_app.converse.ConverseLevelAdapter;
import com.example.annabels_app.converse.ConverseLevels;

import java.util.ArrayList;

import static com.example.annabels_app.MainActivity.getCategories;
import static com.example.annabels_app.MainActivity.getLevels;

public class LevelRecycler extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ConverseLevelAdapter adapter;
    private int categoryNumber;
    private TextView categoryName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_recycler);
        categoryName = findViewById(R.id.categoryName);


        // Initialise recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        // Initialise layoutManager for recyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        Intent intent = getIntent();
        categoryNumber = intent.getIntExtra("Category Number", 0);

        ArrayList<ConverseCategories> categoryBank = getCategories();
        categoryName.setText(categoryBank.get(categoryNumber-1).getCategoryName());
        Log.v("TAG", "Category = " + categoryNumber);
        ArrayList<ConverseLevels> levelBank = null;
        levelBank = getLevels(categoryNumber);

        // Create adapter object
        adapter = new ConverseLevelAdapter(this, levelBank, categoryNumber, categoryBank);

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);

    }
}
