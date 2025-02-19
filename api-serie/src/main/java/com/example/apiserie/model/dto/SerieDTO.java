package com.example.apiserie.model.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SerieDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String serieId;

    private String name;

    private String genre;

    private List<SeasonDTO> seasons = new ArrayList<>();

}
