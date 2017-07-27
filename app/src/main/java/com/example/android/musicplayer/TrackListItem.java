package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TrackListItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.track_list_item);


        //Get the details of the track from the previous activity
        Bundle b = getIntent().getExtras();
        if (b != null) {
            String trackGenre = b.getString("trackGenre");
            String singer = b.getString("singer");
            String trackTitle = b.getString("trackTitle");
            int trackPrice = b.getInt("trackPrice");
            int trackImage = b.getInt("trackImage");


            //Set the title of the track
            this.setTitle(trackTitle);


            //Display the track image
            ImageView albumImageView = (ImageView) findViewById(R.id.track_image);
            albumImageView.setImageResource(trackImage);

            //Display the track title
            TextView trackTitleTextView = (TextView) findViewById(R.id.track_title);
            trackTitleTextView.setText(trackTitle);

            //Display the track artist
            TextView artistTextView = (TextView) findViewById(R.id.track_singer);
            artistTextView.setText(singer);

            //Display the genre title
            TextView genreTitleTextView = (TextView) findViewById(R.id.genre_title);
            genreTitleTextView.setText(trackGenre);

            //Get the price textView and the buy button
            TextView trackPriceTextView = (TextView) findViewById(R.id.track_price);
            Button buyButton = (Button) findViewById(R.id.buy_button);

            //If price is not 0, so if it is not bought yet, display the price and the buy button
            if (trackPrice != 0) {
                //Display the track price and the set the text of the button to "Buy this track now"
                trackPriceTextView.setText(getString(R.string.dollars) + trackPrice);
                buyButton.setText(getString(R.string.buyTrack));

                final Intent paymentIntent = new Intent(TrackListItem.this, PaymentActivity.class);

                //Put the details of the Track Object into the intent
                paymentIntent.putExtra("trackGenre", trackGenre);
                paymentIntent.putExtra("singer", singer);
                paymentIntent.putExtra("trackTitle", trackTitle);
                paymentIntent.putExtra("trackImage", trackImage);
                paymentIntent.putExtra("trackPrice", trackPrice);

                // Set a click listener on listItemView
                buyButton.setOnClickListener(new View.OnClickListener() {

                    // The code in this method will be executed when the "Buy this track now" button is clicked on.
                    @Override
                    public void onClick(View view) {
                        startActivity(paymentIntent);
                    }
                });
            }
            //If price is 0, so if it is already bought, hide the price but change the text of the button to "Play this track"
            else {
                //Hide the track price and the set the text of the button to "Play this track"
                trackPriceTextView.setVisibility(View.GONE);
                buyButton.setText(getString(R.string.playTrack));

                //Create a new Intent for playing a track
                final Intent paymentIntent = new Intent(TrackListItem.this, AllMusicActivity.class);

                //Put the details of the Track Object into the intent
                paymentIntent.putExtra("trackGenre", trackGenre);
                paymentIntent.putExtra("singer", singer);
                paymentIntent.putExtra("trackTitle", trackTitle);
                paymentIntent.putExtra("trackImage", trackImage);
                paymentIntent.putExtra("trackPrice", trackPrice);

                // Set a click listener on "Play this track" button
                buyButton.setOnClickListener(new View.OnClickListener() {

                    // The code in this method will be executed when the "Play this track" button is clicked on.
                    @Override
                    public void onClick(View view) {
                        startActivity(paymentIntent);
                    }
                });
            }

        }
    }
    // menu code ///////////////////////////////////////////////////
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // User clicked on a menu option in the app bar overflow menu
        switch (item.getItemId()) {
            // Respond to a click on the "About" menu option
            case R.id.About_id:
                Toast.makeText(getApplicationContext(), "This app is a student project for Udacity", Toast.LENGTH_LONG).show();
                return true;
            // Respond to a click on the "home" menu option
            case R.id.home_action:
                startActivity(new Intent(this, MainActivity.class));
                return true;
            // Respond to a click on the "Genre" menu option
            case R.id.genres_id:
                startActivity(new Intent(this, Genres.class));
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }
}