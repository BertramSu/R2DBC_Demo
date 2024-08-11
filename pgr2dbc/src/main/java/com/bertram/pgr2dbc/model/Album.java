package com.bertram.pgr2dbc.model;
import org.springframework.data.annotation.Id;

public class Album {
    @Id
    private int id;
    private String title;
    private String artist;
    private double price;

    // Default constructor
    public Album() {
    }

    // Parameterized constructor
    public Album(String title, String artist, double price) {
        this.title = title;
        this.artist = artist;
        this.price = price;
    }

    // Getter and Setter for id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for title
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Getter and Setter for artist
    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    // Getter and Setter for price
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", price=" + price +
                '}';
    }
}
