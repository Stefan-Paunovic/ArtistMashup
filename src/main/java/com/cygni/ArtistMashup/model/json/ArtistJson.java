package com.cygni.ArtistMashup.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ArtistJson {

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("release-groups")
    private List<ReleaseGroupJson> releaseGroups;

    @JsonProperty("life-span")
    private LifeSpanJson lifeSpan;

    @JsonProperty("country")
    private String country;

    @JsonProperty("type")
    private String type;

    @JsonProperty("gender")
    private String gender;

    @JsonProperty("relations")
    private List<RelationJson> relations;

    public ArtistJson() {
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

    public List<ReleaseGroupJson> getReleaseGroups() {
        return releaseGroups;
    }

    public void setReleaseGroups(List<ReleaseGroupJson> releaseGroups) {
        this.releaseGroups = releaseGroups;
    }

    public LifeSpanJson getLifeSpan() {
        return lifeSpan;
    }

    public void setLifeSpan(LifeSpanJson lifeSpan) {
        this.lifeSpan = lifeSpan;
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

    public List<RelationJson> getRelations() {
        return relations;
    }

    public void setRelations(List<RelationJson> relations) {
        this.relations = relations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ArtistJson)) return false;
        ArtistJson that = (ArtistJson) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(releaseGroups, that.releaseGroups) &&
                Objects.equals(lifeSpan, that.lifeSpan) &&
                Objects.equals(country, that.country) &&
                Objects.equals(type, that.type) &&
                Objects.equals(gender, that.gender) &&
                Objects.equals(relations, that.relations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, releaseGroups, lifeSpan, country, type, gender, relations);
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", releaseGroups=" + releaseGroups +
                ", lifeSpan=" + lifeSpan +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", gender='" + gender + '\'' +
                ", relations=" + relations +
                '}';
    }
}
