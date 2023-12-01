package com.swapi.service;

import com.swapi.exception.NotFoundException;
import com.swapi.model.dao.Film;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
public class FilmImpl implements IFilmService {
    @Value("${base.url}")
    private String baseUrl;

    private final RestTemplate restTemplate;

    public FilmImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    @Override
    public Film findAll(Integer id) throws NotFoundException {
        HttpEntity<Void> requestEntity = null;
        ResponseEntity<Film> response = null;
        String uri = baseUrl + id.toString();

        try{
            response = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, Film.class);
            if(response.getStatusCode().is2xxSuccessful()){
                return response.getBody();
            }
        }catch(HttpClientErrorException e){
            e.printStackTrace();
            throw new NotFoundException("Film is not available");
        }
        return response.getBody();
    }
}
