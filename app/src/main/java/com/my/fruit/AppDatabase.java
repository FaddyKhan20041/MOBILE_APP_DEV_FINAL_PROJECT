package com.my.fruit;

import android.content.Context;

import androidx.room.*;

@Database(entities = {Fruit.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
    public abstract FruitDao fruitDao();

    private static AppDatabase instance;

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            AppDatabase.class, "fruit_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }
}
