package com.example.juanlu.filmapp.model;

import java.io.Serializable;

public class Film implements Serializable{
    private String name;
    private String cover;
    private String date;
    private String category;
    private String created_at;
    private String updated_at;

    public Film(String name, String cover, String date, String category, String created_at, String updated_at) {
        this.name = name;
        this.cover = cover;
        this.date = date;
        this.category = category;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public Film() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getCategory() {
        return category;
    }

    public void setCategorys(String category) {
        this.category = category;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }

    @Override
    public String toString() {
        return name;
    }
}
