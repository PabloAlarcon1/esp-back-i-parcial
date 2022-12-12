package com.example.apiserie.controller;

import com.example.apiserie.model.Serie;
import com.example.apiserie.service.SeasonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/v1/series")
public class SerieController {

    private final SeasonService service;

    public SerieController(SeasonService service) {
        this.service = service;
    }

    @GetMapping()
    private ResponseEntity<List<Serie>> getAllSeries(){
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{genre}")
    private ResponseEntity<List<Serie>> findByGenre(@PathVariable String genre){
        return ResponseEntity.ok(service.findByGenre(genre));
    }

    @PostMapping()
    private Serie postSeries(@RequestBody Serie serie){
        return service.save(serie);
    }




    /*@PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public ResponseEntity<Long> create(@RequestBody Serie serie) {
        service.save(serie);
        return ResponseEntity.ok(serie.getSerieId());
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity update(@RequestBody Serie serie) {
        serieService.update(serie);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<List<Serie>> getAll() {
        return ResponseEntity.ok(serieService.getAll());
    }

    @GetMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity<Serie> getById(@PathVariable Long id) {
        return ResponseEntity.ok(serieService.getById(id));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.OK)
    public ResponseEntity delete(@PathVariable Long id) {
        serieService.deleteById(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{genre}")
    ResponseEntity<List<Serie>> getSerieByGenre(@PathVariable String genre) {
        return ResponseEntity.ok().body(serieService.findByGenre(genre));
    }
*/



}
