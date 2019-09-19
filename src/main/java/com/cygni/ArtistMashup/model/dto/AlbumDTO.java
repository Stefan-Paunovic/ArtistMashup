package com.cygni.ArtistMashup.model.dto;

import java.util.Objects;

public class AlbumDTO {

    private String id;
    private String title;
    private String type;
    private String releaseDate;
    private String url;  //TODO COVER ART - BTY från string till URL ?

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
                Objects.equals(url, albumDTO.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, releaseDate, url);
    }

    @Override
    public String toString() {
        return "AlbumDTO{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                ", url='" + url + '\'' +
                '}';
    }
}
