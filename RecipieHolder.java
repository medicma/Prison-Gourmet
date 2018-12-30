package com.wolfenterprisesllc.prisongourmet;

import android.media.Image;

public class RecipieHolder {
    private String recipie;
    private String favorite;
    public int image;


    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    private int _id;

    public String getFavorite() {
        return favorite;
    }

    public void setFavorite(String favorite) {
        this.favorite = favorite;
    }


    public RecipieHolder() {
    }

    public RecipieHolder(String recipie) {
        this.recipie = recipie;
        this.image=image;
        this.favorite = favorite;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_id() {
        return _id;
    }

    public String getRecipie() {
        return recipie;
    }

    public void setRecipie(String recipie) {
        this.recipie = recipie;
    }




}