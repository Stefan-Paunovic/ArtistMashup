package com.cygni.ArtistMashup.model.dto;

import java.util.List;
import java.util.Objects;

public class ArtistDTO {

    private String id;
    private String name;
    private String country;
    private String type;
    private String gender;
    private boolean ended;
    private String begin;
    private String end;
    private String description;
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

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
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

    public boolean isEnded() {
        return ended;
    }

    public void setEnded(boolean ended) {
        this.ended = ended;
    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
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
        return ended == artistDTO.ended &&
                Objects.equals(id, artistDTO.id) &&
                Objects.equals(name, artistDTO.name) &&
                Objects.equals(country, artistDTO.country) &&
                Objects.equals(type, artistDTO.type) &&
                Objects.equals(gender, artistDTO.gender) &&
                Objects.equals(begin, artistDTO.begin) &&
                Objects.equals(end, artistDTO.end) &&
                Objects.equals(description, artistDTO.description) &&
                Objects.equals(albums, artistDTO.albums);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, country, type, gender, ended, begin, end, description, albums);
    }

    @Override
    public String toString() {
        return "ArtistDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", ended=" + ended +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                ", description='" + description + '\'' +
                ", albums=" + albums +
                '}';
    }
}
