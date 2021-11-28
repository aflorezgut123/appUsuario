package co.org.poli.appusuarios;

import java.io.Serializable;
import java.util.List;

public class User implements Serializable {
    private String name;
    private String genre;
    private String description;
    private String urlImage;

    public User() {}

    public User(String name, String genre, String description, String urlImage) {
        this.name = name;
        this.genre = genre;
        this.description = description;
        this.urlImage = urlImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrlImage() {
        return urlImage;
    }

    public void setUrlImage(String urlImage) {
        this.urlImage = urlImage;
    }
}
