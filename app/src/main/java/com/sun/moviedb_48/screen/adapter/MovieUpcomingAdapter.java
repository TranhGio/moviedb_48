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

    Context mContext;
    ArrayList<Movie> mUpcomingMovie;

    public MovieUpcomingAdapter(Context context, ArrayList<Movie> upcomingMovie) {
        mContext = context;
        mUpcomingMovie = upcomingMovie;
    }

    public void updateData(ArrayList<Movie> movies){
        mUpcomingMovie.clear();
        mUpcomingMovie.addAll(movies);
        notifyItemInserted(movies.size());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_upcoming, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindView(position);
    }

    @Override
    public int getItemCount() {
        return mUpcomingMovie != null ? mUpcomingMovie.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements OnFetchImageListener {

        ImageView mImageView;
        TextView mTextViewMovieName, mTextViewDirector, mTextViewAverage, mTextViewDuration;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewMovieName = itemView.findViewById(R.id.movieName);
            mTextViewDirector = itemView.findViewById(R.id.directorName);
            mTextViewAverage = itemView.findViewById(R.id.avanrage);
            mTextViewDuration = itemView.findViewById(R.id.duration);
            mImageView = itemView.findViewById(R.id.imageViewBackdropUpcoming);
        }

        @Override
        public void onImageLoaded(Bitmap bitmap) {
            mImageView.setImageBitmap(bitmap);
        }

        @Override
        public void onImageError(Exception e) {
            Toast.makeText(mContext, "Load image fail", Toast.LENGTH_SHORT).show();
        }

        public void bindView(int position) {
            getImageUrl(
                    Constant.BASE_IMAGE_URL + Constant.IMAGE_ORIGIN+ mUpcomingMovie.get(position)
                            .getBackDropPathUrl(), this);
            mTextViewMovieName.setText(mUpcomingMovie.get(position).getTitle());
            mTextViewAverage.setText(String.valueOf(mUpcomingMovie.get(position).getVoteAverage()));
//            mTextViewDuration.setText(String.valueOf(mUpcomingMovie.get(position).get));
        }
    }
}
