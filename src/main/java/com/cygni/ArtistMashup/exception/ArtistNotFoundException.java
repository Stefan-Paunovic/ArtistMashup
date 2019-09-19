package com.cygni.ArtistMashup.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.NOT_FOUND, reason="Artist not found")
public class ArtistNotFoundException extends ArtistMashupApplicationException {

    public ArtistNotFoundException(String id) {
        super("Artist with the given ID: " + id + " was not found");
    }
}