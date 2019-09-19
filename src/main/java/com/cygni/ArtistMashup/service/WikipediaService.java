package com.cygni.ArtistMashup.service;

import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Cacheable("wikipedia")
public class WikipediaService {
    private static Logger LOGGER = LoggerFactory.getLogger(WikipediaService.class);

    private static final String WIKI_PATH = "https://en.wikipedia.org/w/api.php?action=query&format=json&prop=extracts&exintro=true&redirects=true&titles={title}";
    private static final String EXTRACT = "extract";

    @GetMapping
    public String getDescription(final String title) {
        RestTemplate restTemplate = new RestTemplate();

        try {
            JsonNode jsonNode =
                    restTemplate.getForObject(
                            WIKI_PATH, JsonNode.class, title);

            if(jsonNode == null){
                LOGGER.debug("No description found for given title: " + title);
            }

            List<String> extracts =
                    jsonNode.findValuesAsText(EXTRACT);

            if (!extracts.isEmpty()) {
                return extracts.get(0);
            } else {
                return null;
            }
        } catch (RestClientException e) {
            LOGGER.debug("Exception: " + e.getMessage());
            return null;
        }

    }
}