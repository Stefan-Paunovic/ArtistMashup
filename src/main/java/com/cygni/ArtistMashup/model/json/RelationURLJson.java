package com.cygni.ArtistMashup.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RelationURLJson {

    @JsonProperty("resource")
    private String resource;

    @JsonProperty("id")
    private String id;

    public RelationURLJson() {
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelationURLJson)) return false;
        RelationURLJson that = (RelationURLJson) o;
        return Objects.equals(resource, that.resource) &&
                Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(resource, id);
    }

    @Override
    public String toString() {
        return "RelationURL{" +
                "resource='" + resource + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
