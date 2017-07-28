package com.example.android.musicplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Set a onClickListener  on Search  Music by AllMusic
        Button local = (Button) findViewById(R.id.button_all_music);
        local.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, AllMusicActivity.class);
                startActivity(numbersIntent);
            }
        });
        // Set a onClickListener  on Search  Music by Genre
        Button genres = (Button) findViewById(R.id.button_genre);
        genres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, Genres.class);
                startActivity(numbersIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu options from the res/menu/main_menu.xml file.
        // This adds menu items to the app bar.
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
            // Respond to a click on the "Local" menu option
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