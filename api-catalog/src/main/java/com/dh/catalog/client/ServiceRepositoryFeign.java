package com.dh.catalog.client;

import com.dh.catalog.model.Series;
import com.dh.catalog.model.dto.SeriesDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "api-serie")
public interface ServiceRepositoryFeign {

    @GetMapping("/api/v1/series/{genre}")
    List<Series> findByGenre(@PathVariable(value = "genre") String genre);
}
