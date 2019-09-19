package com.cygni.ArtistMashup.model.dto;

import java.net.URL;
import java.util.Objects;

public class AlbumDTO {

    private String id;
    private String title;
    private String type;
    private String releaseDate;
    private URL coverURL;

    public AlbumDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public URL getCoverURL() {
        return coverURL;
    }

    public void setCoverURL(URL coverURL) {
        this.coverURL = coverURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AlbumDTO)) return false;
        AlbumDTO albumDTO = (AlbumDTO) o;
        return Objects.equals(id, albumDTO.id) &&
                Objects.equals(title, albumDTO.title) &&
                Objects.equals(type, albumDTO.type) &&
                Objects.equals(releaseDate, albumDTO.releaseDate) &&
                Objects.equals(coverURL, albumDTO.coverURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, releaseDate, coverURL);
    }

    @Override
    public String toString() {
        return "AlbumDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", coverURL=" + coverURL +
                '}';
    }
}