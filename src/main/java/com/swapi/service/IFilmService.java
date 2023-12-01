package com.swapi.service;

import com.swapi.exception.NotFoundException;
import com.swapi.model.dao.Film;

public interface IFilmService {
    Film findAll(Integer id) throws NotFoundException;
}
