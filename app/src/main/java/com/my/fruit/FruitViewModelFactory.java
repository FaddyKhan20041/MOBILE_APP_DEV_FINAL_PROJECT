package com.my.fruit;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.my.fruit.AppDatabase;
import com.my.fruit.FruitDao;

public class FruitViewModelFactory implements ViewModelProvider.Factory {
    private final AppDatabase appDatabase;

    public FruitViewModelFactory(AppDatabase appDatabase) {
        this.appDatabase = appDatabase;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        if (modelClass.isAssignableFrom(FruitViewModel.class)) {
            return (T) new FruitViewModel(appDatabase);
        }
        throw new IllegalArgumentException("Unknown ViewModel class");
    }
}
