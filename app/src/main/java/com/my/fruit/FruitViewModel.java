package com.my.fruit;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;
import android.os.AsyncTask;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import java.util.List;

public class FruitViewModel extends ViewModel {
    private List<Fruit> favoriteFruits;
    private LiveData<List<Fruit>> specialFruits;

    private FruitDao fruitDao;
    private AppDatabase appDb;

    public FruitViewModel(AppDatabase appDatabase) {
        appDb = appDatabase;
        fruitDao = appDatabase.fruitDao();
//
    }


    public LiveData<List<Fruit>> getFavoriteFruits() {
//        favoriteFruits = fruitDao.getAllFavoriteFruits();
//        return favoriteFruits;
        LiveData<List<Fruit>> favoriteFruits = fruitDao.getSpecialFruits();
        return  favoriteFruits;

    }

    public void insertFavoriteFruit(Fruit fruit) {
        new InsertAsyncTask(fruitDao).execute(fruit);
    }

    public void deleteFavoriteFruit(Fruit fruit) {
        new DeleteAsyncTask(fruitDao).execute(fruit);
    }

    public void updateFavoriteFruit(Fruit fruit) {
        new UpdateAsyncTask(fruitDao).execute(fruit);
    }

    private static class InsertAsyncTask extends AsyncTask<Fruit, Void, Void> {
        private FruitDao asyncTaskDao;

        InsertAsyncTask(FruitDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Fruit... params) {
            asyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class DeleteAsyncTask extends AsyncTask<Fruit, Void, Void> {
        private FruitDao asyncTaskDao;

        DeleteAsyncTask(FruitDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Fruit... params) {
            asyncTaskDao.delete(params[0]);
            return null;
        }
    }

    private static class UpdateAsyncTask extends AsyncTask<Fruit, Void, Void> {
        private FruitDao asyncTaskDao;

        UpdateAsyncTask(FruitDao dao) {
            asyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Fruit... params) {
            asyncTaskDao.update(params[0]);
            return null;
        }
    }
}
