package com.cygni.ArtistMashup.model.dto;

import java.util.Objects;

public class LifeSpanDTO {

    private boolean ended;
    private String begin;
    private String end;

    public LifeSpanDTO() {
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
        if (!(o instanceof LifeSpanDTO)) return false;
        LifeSpanDTO that = (LifeSpanDTO) o;
        return ended == that.ended &&
                Objects.equals(begin, that.begin) &&
                Objects.equals(end, that.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ended, begin, end);
    }

    @Override
    public String toString() {
        return "LifeSpanDTO{" +
                "ended=" + ended +
                ", begin='" + begin + '\'' +
                ", end='" + end + '\'' +
                '}';
    }
}
