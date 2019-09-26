package com.sun.moviedb_48.screen.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.sun.moviedb_48.R;
import com.sun.moviedb_48.data.model.Movie;
import com.sun.moviedb_48.data.source.remote.OnFetchImageListener;
import com.sun.moviedb_48.utils.Constant;
import java.util.ArrayList;

import static com.sun.moviedb_48.utils.Common.getImageUrl;

public class MovieUpcomingAdapter extends RecyclerView.Adapter<MovieUpcomingAdapter.ViewHolder> {

    private ArrayList<Movie> mUpcomingMovie = new ArrayList<>();

    public MovieUpcomingAdapter(ArrayList<Movie> upcomingMovie) {
        mUpcomingMovie = upcomingMovie;
    }

    public void updateData(ArrayList<Movie> movies) {
        mUpcomingMovie.clear();
        mUpcomingMovie.addAll(movies);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_upcoming, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(mUpcomingMovie.get(position));
    }

    @Override
    public int getItemCount() {
        return mUpcomingMovie != null ? mUpcomingMovie.size() : 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements OnFetchImageListener {

        private ImageView mImageViewUpcoming;
        private TextView mTextViewMovieName, mTextViewAverage, mTextViewReleaseDate;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewMovieName = itemView.findViewById(R.id.textViewMovieName);
            mTextViewAverage = itemView.findViewById(R.id.textViewAvanrage);
            mTextViewReleaseDate = itemView.findViewById(R.id.textViewReleaseDate);
            mImageViewUpcoming = itemView.findViewById(R.id.imageViewBackdropUpcoming);
        }

        @Override
        public void onImageLoaded(Bitmap bitmap) {
            mImageViewUpcoming.setImageBitmap(bitmap);
        }

        @Override
        public void onImageError(Exception e) {
            Toast.makeText(itemView.getContext(), R.string.msg_fail_image_loading, Toast.LENGTH_SHORT).show();
        }

        public void bindView(Movie movie) {
            getImageUrl(
                    Constant.BASE_IMAGE_URL + Constant.IMAGE_ORIGIN + movie.getBackDropPathUrl(),
                    this);
            mTextViewMovieName.setText(movie.getTitle());
            mTextViewAverage.setText(String.valueOf(movie.getVoteAverage()));
            mTextViewReleaseDate.setText(String.valueOf(movie.getReleaseDate()));
        }
    }
}
