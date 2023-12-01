package com.swapi.controller;

import com.swapi.exception.NotFoundException;
import com.swapi.model.dao.Film;
import com.swapi.service.IFilmService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class FilmController {

    private final IFilmService filmService;

    public FilmController(IFilmService filmService) {
        this.filmService = filmService;
    }


    @GetMapping("/film/{id}")
    public Film getFilm(@Valid @PathVariable Integer id)  throws NotFoundException {
        return filmService.findAll(id);
    }


}
