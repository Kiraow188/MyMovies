package sg.edu.rp.c346.mymovies;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends ArrayAdapter {

    Context parent_context;
    int layout_id;
    ArrayList<Movie> movieList;

    public CustomAdapter(@NonNull Context context, int resource, @NonNull ArrayList<Movie> objects) {
        super(context, resource, objects);
        parent_context = context;
        layout_id = resource;
        movieList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Obtain the LayoutInflater object.
        LayoutInflater inflater = (LayoutInflater) parent_context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // Inflate a new view hierarchy from the specified xml resource (layout_id)
        // and return the root View of the inflated hierarchy.
        View rowView = inflater.inflate(layout_id, parent, false);
        TextView tvTitle = rowView.findViewById(R.id.tvTitle);
        TextView tvYear = rowView.findViewById(R.id.tvYear);
        TextView tvGenre = rowView.findViewById(R.id.tvGenre);
        ImageView ivGenre = rowView.findViewById(R.id.imgViewRating);

        Movie currentMovie = movieList.get(position);
        tvTitle.setText(currentMovie.getTitle());
        tvYear.setText(currentMovie.getYear() + " - ");
        tvGenre.setText(currentMovie.getGenre());
        if (currentMovie.getRated().equalsIgnoreCase("g")){
            ivGenre.setImageResource(R.drawable.rating_g);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("pg")){
            ivGenre.setImageResource(R.drawable.rating_pg);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("pg13")){
            ivGenre.setImageResource(R.drawable.rating_pg13);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("nc16")){
            ivGenre.setImageResource(R.drawable.rating_nc16);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("m18")){
            ivGenre.setImageResource(R.drawable.rating_m18);
        }
        else if (currentMovie.getRated().equalsIgnoreCase("r21")){
            ivGenre.setImageResource(R.drawable.rating_r21);
        }

        // Return the View corresponding to the data at the specified position.
        return rowView;
    }
}
