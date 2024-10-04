package com.example.moviefinal;

public class Movie {
    private String title;
    private String director;
    private String stars;
    private String description;
    private double price;
    private int imageID;

    public Movie(String title, String director, String stars, String description, double price, int imageID) {
        this.title = title;
        this.director = director;
        this.stars = stars;
        this.description = description;
        this.price = price;
        this.imageID = imageID;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getStars() {
        return stars;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public int getImageID() {
        return imageID;
    }
}