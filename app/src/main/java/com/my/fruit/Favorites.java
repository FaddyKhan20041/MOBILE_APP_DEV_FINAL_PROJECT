package com.my.fruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.List;

public class Favorites extends AppCompatActivity {
    private RecyclerView favoritesRecyclerView;
    private FruitAdapter favoritesAdapter;
    private FruitViewModel fruitViewModel;

    private FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);
        AppDatabase appDatabase = AppDatabase.getInstance(this);
        FruitViewModelFactory viewModelFactory = new FruitViewModelFactory(appDatabase);
        fruitViewModel = new ViewModelProvider(this, viewModelFactory).get(FruitViewModel.class);

        favoritesRecyclerView = findViewById(R.id.favorites_recycler_view);
        favoritesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        favoritesAdapter = new FruitAdapter();
        favoritesRecyclerView.setAdapter(favoritesAdapter);
        floatingActionButton = findViewById(R.id.home_fab);




//        List<Fruit> fruits = fruitViewModel.getFavoriteFruits();
//        favoritesAdapter.submitList(fruits);
        fruitViewModel.getFavoriteFruits().observe(this, fruits -> {
            favoritesAdapter.submitList(fruits);
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the main activity
                Intent intent = new Intent(Favorites.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
}
