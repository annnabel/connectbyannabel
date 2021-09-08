package com.example.annabels_app.drink;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import com.example.annabels_app.CSVFile;
import com.example.annabels_app.R;
import com.example.annabels_app.converse.ConverseCategories;
import com.example.annabels_app.converse.ConverseCategoryAdapter;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static com.example.annabels_app.MainActivity.getDrinkCategories;

public class DrinkRecycler extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DrinkAdapter adapter;
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_recycler);

        // Initialise recyclerView
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);


        // Initialise layoutManager for recyclerView
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(gridLayoutManager); // set LayoutManager to RecyclerView
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.black));
        ArrayList<Question> drinkCategories = null;
        drinkCategories = getDrinkCategories();
        Log.d("Category", String.valueOf(drinkCategories.get(1)));

        // Create adapter object
        adapter = new DrinkAdapter(this, drinkCategories);

        // Attach adapter to recycler
        recyclerView.setAdapter(adapter);
    }
}
