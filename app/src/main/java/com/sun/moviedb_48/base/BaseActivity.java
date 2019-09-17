package com.sun.moviedb_48.base;

import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {
    public abstract void onCreateView(Bundle savedInstanceState);

    public abstract void onSetupView();

    public abstract void onBindView();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onCreateView(savedInstanceState);
        onSetupView();
        onBindView();
    }
}
