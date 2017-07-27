package com.example.android.musicplayer;

/**
 * Created by Sharareh on 7/22/2017.
 */

public class Track {

    //Title of the track
    private String mTrackTitle;
    //Title of the singer name
    private String mSinger;
    //Genre of the Track
    private String mTrackGenre;
    //Price of the Track
    private int mTrackPrice;
    //Image ID of the track
    private int mImageTrack;

    /*Default constructor of the Track Object.
    * @param trackTitle title of the Track
    * @param singer title of the singer name
    * @param genre performer of the genre
    * @param price of song
    * @param image of the track
     */

    public Track(String trackTitle, String singer, String trackGenre, int trackPrice, int imageTrack) {
        mTrackTitle = trackTitle;
        mSinger = singer;
        mTrackGenre = trackGenre;
        mTrackPrice = trackPrice;
        mImageTrack = imageTrack;
    }

    //@return title of the track
    public String getTrackTitle() {
        return mTrackTitle;
    }

    //@return title of the track
    public String getSinger() {
        return mSinger;
    }

    //@return title of the album
    public String getTrackGenre() {
        return mTrackGenre;
    }

    //@return price of the album
    public int getTrackPrice() {
        return mTrackPrice;
    }

    //@return image of the album
    public int getImageTrack() {
        return mImageTrack;
    }
}