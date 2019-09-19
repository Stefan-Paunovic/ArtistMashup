package com.cygni.ArtistMashup.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class ReleaseGroupJson {

    @JsonProperty("id")
    private String id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("primary-type")
    private String type;

    @JsonProperty("first-release-date")
    private String releaseDate;

    public ReleaseGroupJson() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ReleaseGroupJson)) return false;
        ReleaseGroupJson that = (ReleaseGroupJson) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(title, that.title) &&
                Objects.equals(type, that.type) &&
                Objects.equals(releaseDate, that.releaseDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, type, releaseDate);
    }

    @Override
    public String toString() {
        return "ReleaseGroup{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", type='" + type + '\'' +
                ", releaseDate='" + releaseDate + '\'' +
                '}';
    }
}
