package com.example.movie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class MovieEntity implements Parcelable {

    private String movieName;
    private String movieDesc;
    private String movieGenre;
    private int movieImg;

    public MovieEntity(String movieName, String movieDesc, String movieGenre, int movieImg) {
        this.movieName = movieName;
        this.movieDesc = movieDesc;
        this.movieGenre = movieGenre;
        this.movieImg = movieImg;
    }

    protected MovieEntity(Parcel in) {
        movieName = in.readString();
        movieDesc = in.readString();
        movieGenre = in.readString();
        movieImg = in.readInt();
    }

    public static final Creator<MovieEntity> CREATOR = new Creator<MovieEntity>() {
        @Override
        public MovieEntity createFromParcel(Parcel in) {
            return new MovieEntity(in);
        }

        @Override
        public MovieEntity[] newArray(int size) {
            return new MovieEntity[size];
        }
    };

    public String getMovieName() {
        return movieName;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public String getMovieDesc() {
        return movieDesc;
    }

    public void setMovieDesc(String movieDesc) {
        this.movieDesc = movieDesc;
    }

    public String getMovieGenre() {
        return movieGenre;
    }

    public void setMovieGenre(String movieGenre) {
        this.movieGenre = movieGenre;
    }

    public int getMovieImg() {
        return movieImg;
    }

    public void setMovieImg(int movieImg) {
        this.movieImg = movieImg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(movieName);
        parcel.writeString(movieDesc);
        parcel.writeString(movieGenre);
        parcel.writeInt(movieImg);
    }
}
