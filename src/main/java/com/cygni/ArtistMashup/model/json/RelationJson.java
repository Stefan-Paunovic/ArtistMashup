package com.cygni.ArtistMashup.model.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public class RelationJson {

    @JsonProperty("type")
    private String type;

    @JsonProperty("url")
    private RelationURLJson relationURL;

    public RelationJson() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public RelationURLJson getRelationURL() {
        return relationURL;
    }

    public void setRelationURL(RelationURLJson relationURL) {
        this.relationURL = relationURL;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RelationJson)) return false;
        RelationJson relation = (RelationJson) o;
        return Objects.equals(type, relation.type) &&
                Objects.equals(relationURL, relation.relationURL);
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, relationURL);
    }

    @Override
    public String toString() {
        return "Relation{" +
                "type='" + type + '\'' +
                ", relationURL=" + relationURL +
                '}';
    }
}
