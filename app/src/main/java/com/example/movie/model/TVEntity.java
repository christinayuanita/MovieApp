package com.example.movie.model;

import android.os.Parcel;
import android.os.Parcelable;

public class TVEntity implements Parcelable {

    private String tvName;
    private String tvDesc;
    private String tvGenre;
    private int tvImg;

    public TVEntity(String tvName, String tvDesc, String tvGenre, int tvImg) {
        this.tvName = tvName;
        this.tvDesc = tvDesc;
        this.tvGenre = tvGenre;
        this.tvImg = tvImg;
    }

    protected TVEntity(Parcel in) {
        tvName = in.readString();
        tvDesc = in.readString();
        tvGenre = in.readString();
        tvImg = in.readInt();
    }

    public static final Creator<TVEntity> CREATOR = new Creator<TVEntity>() {
        @Override
        public TVEntity createFromParcel(Parcel in) {
            return new TVEntity(in);
        }

        @Override
        public TVEntity[] newArray(int size) {
            return new TVEntity[size];
        }
    };

    public String getTvName() {
        return tvName;
    }

    public void setTvName(String tvName) {
        this.tvName = tvName;
    }

    public String getTvDesc() {
        return tvDesc;
    }

    public void setTvDesc(String tvDesc) {
        this.tvDesc = tvDesc;
    }

    public String getTvGenre() {
        return tvGenre;
    }

    public void setTvGenre(String tvGenre) {
        this.tvGenre = tvGenre;
    }

    public int getTvImg() {
        return tvImg;
    }

    public void setTvImg(int tvImg) {
        this.tvImg = tvImg;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(tvName);
        parcel.writeString(tvDesc);
        parcel.writeString(tvGenre);
        parcel.writeInt(tvImg);
    }
}
