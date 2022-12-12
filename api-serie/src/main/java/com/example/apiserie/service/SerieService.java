package com.example.apiserie.service;

import com.example.apiserie.model.Chapter;
import com.example.apiserie.model.Season;
import com.example.apiserie.model.Serie;

import java.util.List;

public interface SerieService {

    Serie save (Serie serie);

    List<Serie> getAll();

    Serie getById(String id);

    void deleteById(String id);

    void update(Serie serie);

    List<Serie> findByGenre(String genre);

    void addChapter(String serieId, String seasonId, Chapter chapter) throws Exception;

    void addSeason(String serieId, Season season) throws Exception;


}
