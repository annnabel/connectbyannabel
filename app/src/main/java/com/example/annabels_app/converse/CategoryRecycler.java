package com.example.annabels_app.converse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.annabels_app.CSVFile;
import com.example.annabels_app.R;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.annabels_app.MainActivity.getCategories;

public class CategoryRecycler extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private ConverseCategoryAdapter adapter;

        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_recycler);



        // Initialise recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        // Initialise layoutManager for recyclerView
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList<ConverseCategories> categoryBank = null;
            categoryBank = getCategories();

            // Create adapter object
        adapter = new ConverseCategoryAdapter(this, categoryBank);

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);
    }


}
