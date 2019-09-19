package com.cygni.ArtistMashup.controller;

import com.cygni.ArtistMashup.exception.ArtistNotFoundException;
import com.cygni.ArtistMashup.model.dto.AlbumDTO;
import com.cygni.ArtistMashup.model.dto.ArtistDTO;
import com.cygni.ArtistMashup.model.json.ArtistJson;
import com.cygni.ArtistMashup.model.json.ReleaseGroupJson;
import com.cygni.ArtistMashup.service.CoverArtArchiveService;
import com.cygni.ArtistMashup.service.MusicBrainzService;

import com.cygni.ArtistMashup.service.WikipediaService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.JsonPath;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/artist")
public class ArtistMashupController {
    private static Logger LOGGER = LoggerFactory.getLogger(MusicBrainzService.class);

    @Autowired
    MusicBrainzService musicBrainzService;

    @Autowired
    WikipediaService wikipediaService;

    @Autowired
    CoverArtArchiveService coverArtArchiveService;

    @GetMapping("/{id}")
    public ArtistDTO getArtist(@PathVariable("id") final String id) throws ArtistNotFoundException {

        //MusicBrainzService
        ArtistJson artistJson =
                musicBrainzService.getArtist(id);

        if(artistJson == null) {
            throw new ArtistNotFoundException(id);
        }

        ArtistDTO artist = new ArtistDTO();

        artist.setId(artistJson.getId());
        artist.setName(artistJson.getName());
        artist.setCountry(artistJson.getCountry());
        artist.setType(artistJson.getType());
        artist.setGender(artistJson.getGender());
        if(artistJson.getLifeSpan() != null){
            artist.setEnded(artistJson.getLifeSpan().isEnded());
            artist.setBegin(artistJson.getLifeSpan().getBegin());
            artist.setEnd(artistJson.getLifeSpan().getEnd());
        }

        //WikipediaService
        ObjectMapper mapper = new ObjectMapper();
        String jsonArtistString = "";
        try {
            jsonArtistString = mapper.writeValueAsString(artistJson);

            List<String> urls =
                    JsonPath.parse(jsonArtistString)//sätt wikipedia istället för BBC
                            .read("$..relations[?(@.type == 'IMDb')].url.resource");

            if(!urls.isEmpty()){
                String path = urls.get(0);
                artist.setDescription(
                        wikipediaService.getDescription(
                                path.substring(
                                        path.lastIndexOf('/') + 1)));
            }
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        //Album + CoverArtArchiveService
        List<AlbumDTO> albums = new ArrayList<>();
        for(ReleaseGroupJson source : artistJson.getReleaseGroups()){
            AlbumDTO album = new AlbumDTO();

            album.setId(source.getId());
            album.setTitle(source.getTitle());
            album.setType(source.getType());
            album.setReleaseDate(source.getReleaseDate());

            album.setCoverURL(
                    coverArtArchiveService.getCoverArt(
                            source.getId()));
            albums.add(album);
        }
        artist.setAlbums(albums);
        return artist;
    }
}