package sg.edu.rp.c346.mymovies;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class MovieDetailsActivity extends AppCompatActivity {

    ImageView ivRating;
    TextView tvTitle, tvYear, tvGenre, tvDesc, tvTheatre, tvWatchedOn;
    RatingBar rbRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_details);
        tvTitle = findViewById(R.id.tvTitle1);
        tvDesc = findViewById(R.id.tvDesc);
        tvGenre = findViewById(R.id.tvGenre1);
        tvTheatre = findViewById(R.id.tvTheatre);
        tvWatchedOn = findViewById(R.id.tvWatched);
        tvYear = findViewById(R.id.tvYear1);
        ivRating = findViewById(R.id.imageViewRating);
        rbRating = findViewById(R.id.ratingBar);

        Intent intentReceived = getIntent();
        String title = intentReceived.getStringExtra("title");
        String year = intentReceived.getStringExtra("year");
        String genre = intentReceived.getStringExtra("genre");
        String desc = intentReceived.getStringExtra("desc");
        String rated = intentReceived.getStringExtra("rated");
        String theatre = intentReceived.getStringExtra("theatre");
        String watched_on = intentReceived.getStringExtra("watched_on");
        int rating = Integer.parseInt(intentReceived.getStringExtra("rating"));

        tvTitle.setText(title);
        tvYear.setText(year + " - ");
        tvWatchedOn.setText("Watched on: " + watched_on);
        tvTheatre.setText("In Theatre: " + theatre);
        tvGenre.setText(genre);
        tvDesc.setText(desc);
        rbRating.setRating(rating);
        rbRating.setIsIndicator(true);

        if (rated.equalsIgnoreCase("g")){
            ivRating.setImageResource(R.drawable.rating_g);
        }
        else if (rated.equalsIgnoreCase("pg")){
            ivRating.setImageResource(R.drawable.rating_pg);
        }
        else if (rated.equalsIgnoreCase("pg13")){
            ivRating.setImageResource(R.drawable.rating_pg13);
        }
        else if (rated.equalsIgnoreCase("nc16")){
            ivRating.setImageResource(R.drawable.rating_nc16);
        }
        else if (rated.equalsIgnoreCase("m18")){
            ivRating.setImageResource(R.drawable.rating_m18);
        }
        else if (rated.equalsIgnoreCase("r21")){
            ivRating.setImageResource(R.drawable.rating_r21);
        }

    }
}
