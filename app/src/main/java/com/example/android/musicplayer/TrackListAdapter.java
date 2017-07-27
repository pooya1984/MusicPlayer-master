package com.example.android.musicplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Sharareh on 7/22/2017.
 */

public class TrackListAdapter extends ArrayAdapter<Track> {
    //Constructor of the TrackListAdapter
    public TrackListAdapter(Activity context, ArrayList<Track> tracks) {
        super(context, 0, tracks);
    }

    @Override

    public View getView(int position, View convertView, ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        // Get the {@link Track} object located at this position in the list
        Track currentTrack = getItem(position);

        //Get the details of the current Track Object
        String trackTitle = currentTrack.getTrackTitle();
        String singer = currentTrack.getSinger();
        String trackGenre = currentTrack.getTrackGenre();
        int trackPrice = currentTrack.getTrackPrice();
        int trackImage = currentTrack.getImageTrack();

        // Find the ImageView in the track_list_item.xml_item.xml layout with the ID track_image
        ImageView albumImageView = (ImageView) listItemView.findViewById(R.id.track_image);

        // Get the album image of the current Track object and
        // set this image on the track image TextView
        albumImageView.setImageResource(trackImage);

        // Find the TextView in the track_list_item.xml_item.xml layout with the ID track_title
        TextView trackTitleTextView = (TextView) listItemView.findViewById(R.id.track_title);

        // Get the track title of the current Track object and
        // set this text on the track title TextView
        trackTitleTextView.setText(trackTitle);

        // Find the TextView in the track_list_item.xml_item.xml layout with the ID singer
        TextView singerTextView = (TextView) listItemView.findViewById(R.id.track_singer);

        // Get the track title of the current Track object and
        // set this text on the track title TextView
        singerTextView.setText(singer);

        // Find the TextView in the all_music list_ item list_item.xml layout with the ID genre_title
        TextView genreTitleTextView = (TextView) listItemView.findViewById(R.id.genre_title);

        // Get the genre title of the current Track object and
        // set this text on the album title TextView

        genreTitleTextView.setText(trackGenre);


        //Get the context of the List Item and create an Intent for its unique activity
        final Context context = listItemView.getContext();
        final Intent MainListItemIntent = new Intent(context, TrackListItem.class);

        //Put the details of the Track Object into the intent
        MainListItemIntent.putExtra("trackImage", trackImage);
        MainListItemIntent.putExtra("singer", singer);
        MainListItemIntent.putExtra("trackGenre", trackGenre);
        MainListItemIntent.putExtra("trackTitle", trackTitle);
        MainListItemIntent.putExtra("trackPrice", trackPrice);


        // Set a click listener on listItemView
        listItemView.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the ListItemView is clicked on.
            @Override
            public void onClick(View view) {
                context.startActivity(MainListItemIntent);
            }
        });

        return listItemView;
    }
}