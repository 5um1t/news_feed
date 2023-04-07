package com.example.newsfeed;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class CategoryRVModel implements Parcelable {
    private String category;
    private String categoryImageUrl;

    public CategoryRVModel() {

    }

    protected CategoryRVModel(Parcel in) {
        category = in.readString();
        categoryImageUrl = in.readString();
    }

    public static final Creator<CategoryRVModel> CREATOR = new Creator<CategoryRVModel>() {
        @Override
        public CategoryRVModel createFromParcel(Parcel in) {
            return new CategoryRVModel(in);
        }

        @Override
        public CategoryRVModel[] newArray(int size) {
            return new CategoryRVModel[size];
        }
    };

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategoryImageUrl() {
        return categoryImageUrl;
    }

    public void setCategoryImageUrl(String categoryImageUrl) {
        this.categoryImageUrl = categoryImageUrl;
    }

    public CategoryRVModel(String category, String categoryImageUrl) {
        this.category = category;
        this.categoryImageUrl = categoryImageUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeString(category);
        dest.writeString(categoryImageUrl);
    }
}
