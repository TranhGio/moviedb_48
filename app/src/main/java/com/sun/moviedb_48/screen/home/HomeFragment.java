package com.sun.moviedb_48.screen.home;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sun.moviedb_48.R;
import com.sun.moviedb_48.base.BaseFragment;
import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.repository.MovieRepository;
import com.sun.moviedb_48.data.source.local.MovieLocalDataSource;
import com.sun.moviedb_48.data.source.remote.MovieRemoteDataSource;
import com.sun.moviedb_48.screen.adapter.MovieUpcomingAdapter;
import com.sun.moviedb_48.utils.Categories;
import java.util.ArrayList;

public class HomeFragment extends BaseFragment implements HomeContract.View {

    private static final String TAG = HomeFragment.class.getSimpleName();
    private HomeContract.Presenter mPresenter;
    private MovieUpcomingAdapter mMovieUpcomingAdapter;
    private RecyclerView mUpcomingRecyclerView;
    private ArrayList<Movie> mUpcomingMovies = new ArrayList<>();

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void initView(View view) {
        mMovieUpcomingAdapter = new MovieUpcomingAdapter(mUpcomingMovies);
        mUpcomingRecyclerView = view.findViewById(R.id.recyclerViewUpcoming);
        mUpcomingRecyclerView.setHasFixedSize(true);
        DividerItemDecoration dividerItemDecorationUpcoming =
                new DividerItemDecoration(getContext(), RecyclerView.HORIZONTAL);
        mUpcomingRecyclerView.addItemDecoration(dividerItemDecorationUpcoming);
        mUpcomingRecyclerView.setAdapter(mMovieUpcomingAdapter);
    }

    @Override
    public void initData() {
        MovieRemoteDataSource movieRemoteDataSource = MovieRemoteDataSource.getInstance();
        MovieLocalDataSource movieLocalDataSource = MovieLocalDataSource.getInstance();
        MovieRepository movieRepository =
                MovieRepository.getInstance(movieRemoteDataSource, movieLocalDataSource);
        mPresenter = new HomePresenter(movieRepository);
        mPresenter.setView(this);
        mPresenter.getMoviesByCategories(Categories.UPCOMING);
    }

    @Override
    public void initListener() {

    }

    @Override
    public void showMovies(ArrayList<Movie> movies, @Categories String category) {
        switch (category) {
            case Categories.UPCOMING:
                mUpcomingMovies = movies;
                mMovieUpcomingAdapter.updateData(mUpcomingMovies);
                break;
            default:
                break;
        }
    }

    @Override
    public void showError(String exceptionMessage) {
        Toast.makeText(getContext(), R.string.mgs_fail_load_movie_by_categories, Toast.LENGTH_SHORT)
                .show();
        Log.e(TAG, exceptionMessage);
    }
}
