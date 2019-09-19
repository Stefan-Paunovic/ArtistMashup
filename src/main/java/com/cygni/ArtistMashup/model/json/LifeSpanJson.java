package com.cygni.ArtistMashup.model.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LifeSpanJson {

    @JsonProperty("ended")
    private boolean ended;

    @JsonProperty("begin")
    private String begin;

    @JsonProperty("end")
    private String end;

    public LifeSpanJson() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LifeSpanJson)) return false;
        LifeSpanJson lifeSpanJson = (LifeSpanJson) o;
        return ended == lifeSpanJson.ended &&
                Objects.equals(begin, lifeSpanJson.begin) &&
                Objects.equals(end, lifeSpanJson.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ended, begin, end);
    }

    @Override
    public String toString() {
        return "LifeSpan{" +
                "ended=" + ended +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
