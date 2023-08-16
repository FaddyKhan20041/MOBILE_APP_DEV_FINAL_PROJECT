package com.my.fruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import android.widget.ImageButton;

public class FruitDetailsActivity extends AppCompatActivity {

    private ImageView fruitImage;
    private TextView descriptionText;
    private TextView titleText;
    private Button addToFavoritesButton;
    private Button viewFavButton;

    private FloatingActionButton floatingActionButton;

    private Fruit selectedFruit;
    private FruitViewModel fruitViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_details);

        fruitImage = findViewById(R.id.fruit_image);
        descriptionText = findViewById(R.id.description_text);
        addToFavoritesButton = findViewById(R.id.add_to_favorites_button);
        titleText = findViewById(R.id.fruit_title);
        viewFavButton =  findViewById(R.id.see_favorites);
        floatingActionButton = findViewById(R.id.home_fab2);

        AppDatabase database = AppDatabase.getInstance(this);
        FruitViewModelFactory factory = new FruitViewModelFactory(database);
        fruitViewModel = new ViewModelProvider(this, factory).get(FruitViewModel.class);


        // Get selected fruit from intent
        selectedFruit = getIntent().getParcelableExtra("selected_fruit");
        Log.d("myTag", selectedFruit.toString());


        if (selectedFruit != null) {
            setTitle(selectedFruit.getName());
            // Populate UI elements with selectedFruit data
            descriptionText.setText(selectedFruit.getDescription());
            titleText.setText(selectedFruit.getName());
//            Picasso.get().load(selectedFruit.getImage()).into(fruitImage);

            addToFavoritesButton.setOnClickListener(v -> addToFavorites());
        }
        viewFavButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FruitDetailsActivity.this, Favorites.class);
                startActivity(intent);
            }
        });

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an intent to navigate to the main activity
                Intent intent = new Intent(FruitDetailsActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void addToFavorites() {
        fruitViewModel.insertFavoriteFruit(selectedFruit);
        Toast.makeText(this, "Added to favorites!", Toast.LENGTH_SHORT).show();
    }



}
