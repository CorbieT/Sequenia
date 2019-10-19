package com.sequenia.model.response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import javax.inject.Inject;

public class MovieResponse implements Parcelable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("localized_name")
    @Expose
    private String localizedName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("year")
    @Expose
    private int year;
    @SerializedName("rating")
    @Expose
    private float rating;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("genres")
    @Expose
    private List<String> genres;

    public MovieResponse(Parcel parcel) {
        int[] intData = new int[2];
        parcel.readIntArray(intData);
        id = intData[0];
        year = intData[1];

        String[] stringData = new String[4];
        parcel.readStringArray(stringData);
        localizedName = stringData[0];
        name = stringData[1];
        imageUrl = stringData[2];
        description = stringData[3];

        float[] floatData = new float[4];
        parcel.readFloatArray(floatData);
        rating = floatData[0];

        parcel.readList(genres, MovieResponse.class.getClassLoader());
    }

    public int getId() {
        return id;
    }

    public String getLocalizedName() {
        return localizedName;
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public float getRating() {
        return rating;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getGenres() {
        return genres;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(new int[]{id, year});
        parcel.writeStringArray(new String[]{localizedName, name, imageUrl, description});
        parcel.writeFloatArray(new float[]{rating});
        parcel.writeList(genres);
    }

    public static final Parcelable.Creator<MovieResponse> CREATOR = new Parcelable.Creator<MovieResponse>() {

        @Override
        public MovieResponse createFromParcel(Parcel parcel) {
            return new MovieResponse(parcel);
        }

        @Override
        public MovieResponse[] newArray(int size) {
            return new MovieResponse[size];
        }
    };
}
