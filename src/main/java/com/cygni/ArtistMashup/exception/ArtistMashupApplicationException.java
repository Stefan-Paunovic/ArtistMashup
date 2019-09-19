package com.cygni.ArtistMashup.exception;

public class ArtistMashupApplicationException extends Exception {

    protected ArtistMashupApplicationException() {}

    protected ArtistMashupApplicationException(String message) {
        super(message);
    }

    protected ArtistMashupApplicationException(String message, Throwable cause){
        super(message, cause);
    }

    protected ArtistMashupApplicationException(Throwable cause){
        super(cause);
    }

    protected ArtistMashupApplicationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace){
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
