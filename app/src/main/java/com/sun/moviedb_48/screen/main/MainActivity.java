package com.sun.moviedb_48.screen.main;

import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sun.moviedb_48.R;
import com.sun.moviedb_48.screen.favourite.FavouriteFragment;
import com.sun.moviedb_48.screen.genres.GenresFragment;
import com.sun.moviedb_48.screen.home.HomeFragment;
import com.sun.moviedb_48.screen.search.SearchFragment;
import com.sun.moviedb_48.utils.Navigator;

public class MainActivity extends AppCompatActivity
        implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView navigationMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.itemHome:
                Navigator.loadFragment(getSupportFragmentManager(), R.id.frameLayoutMain,
                        HomeFragment.getInstance(), false, HomeFragment.class.getSimpleName());
                return true;
            case R.id.itemGenres:
                Navigator.loadFragment(getSupportFragmentManager(), R.id.frameLayoutMain,
                        GenresFragment.newInstance(), false, GenresFragment.class.getSimpleName());
                return true;
            case R.id.itemSearch:
                Navigator.loadFragment(getSupportFragmentManager(), R.id.frameLayoutMain,
                        SearchFragment.newInstance(), false, SearchFragment.class.getSimpleName());
                return true;
            case R.id.itemFavourite:
                Navigator.loadFragment(getSupportFragmentManager(), R.id.frameLayoutMain,
                        FavouriteFragment.newInstance(), false,
                        FavouriteFragment.class.getSimpleName());
                return true;
            default:
                return false;
        }
    }

    private void initView() {
        navigationMain = findViewById(R.id.bottomNavigationMain);
        navigationMain.setOnNavigationItemSelectedListener(this);
        navigationMain.setSelectedItemId(R.id.itemHome);
    }
}
