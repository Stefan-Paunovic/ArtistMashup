package com.cygni.ArtistMashup.model.dto;

import java.util.List;
import java.util.Objects;

public class ArtistDTO {

    private String id;
    private String name;
    private LifeSpanDTO lifeSpan;
    private String county;
    private String type;
    private String gender;
    private String description; //TODO WIKI
    private List<AlbumDTO> albums;

    public ArtistDTO() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LifeSpanDTO getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(LifeSpanDTO lifeSpan) {
        this.lifeSpan = lifeSpan;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<AlbumDTO> getAlbums() {
        return albums;
    }

    public void setAlbums(List<AlbumDTO> albums) {
        this.albums = albums;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtistDTO)) return false;
        ArtistDTO artistDTO = (ArtistDTO) o;
        return Objects.equals(id, artistDTO.id) &&
                Objects.equals(name, artistDTO.name) &&
                Objects.equals(lifeSpan, artistDTO.lifeSpan) &&
                Objects.equals(county, artistDTO.county) &&
                Objects.equals(type, artistDTO.type) &&
                Objects.equals(gender, artistDTO.gender) &&
                Objects.equals(description, artistDTO.description) &&
                Objects.equals(albums, artistDTO.albums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lifeSpan, county, type, gender, description, albums);
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lifeSpan=" + lifeSpan +
                ", county='" + county + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", description='" + description + '\'' +
                ", albums=" + albums +
                '}';
    }
}
