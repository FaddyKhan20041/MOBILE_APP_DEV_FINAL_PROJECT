package com.my.fruit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.util.List;

import retrofit2.*;
public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private FruitAdapter fruitAdapter;
    private ApiService apiService;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        fruitAdapter = new FruitAdapter();
        recyclerView.setAdapter(fruitAdapter);

        fruitAdapter.setOnItemClickListener(fruit -> {

            Intent intent = new Intent(MainActivity.this, FruitDetailsActivity.class);
            intent.putExtra("selected_fruit", fruit);
            Log.d("onCreate: ", fruit.toString());
            startActivity(intent);
        });

        apiService = RetrofitClient.getInstance().create(ApiService.class);
        fetchFruits();

    }

    private void fetchFruits() {
        Call<List<Fruit>> call = apiService.getAllFruits();
        call.enqueue(new Callback<List<Fruit>>() {
            @Override
            public void onResponse(Call<List<Fruit>> call, Response<List<Fruit>> response) {
                if (response.isSuccessful()) {
                    Log.d("onResponse: ",response.body().toString());
                    List<Fruit> fruits = response.body();


//                    fruitAdapter.setFruits(fruits);
                    fruitAdapter.submitList(fruits);
                }
            }

            @Override
            public void onFailure(Call<List<Fruit>> call, Throwable t) {
                // Handle API call failure
            }
        });
    }


}