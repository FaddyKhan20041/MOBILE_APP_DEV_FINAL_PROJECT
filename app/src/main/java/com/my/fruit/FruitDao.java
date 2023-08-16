package com.my.fruit;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;


import java.util.List;


@Dao
public interface FruitDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Fruit fruit);

    @Query("SELECT * FROM favorite_fruits")
    List<Fruit> getAllFavoriteFruits();
    @Update
    void update(Fruit fruit);

    @Delete
    void delete(Fruit fruit);
    @Query("SELECT * FROM favorite_fruits")
    LiveData<List<Fruit>> getSpecialFruits();
}
