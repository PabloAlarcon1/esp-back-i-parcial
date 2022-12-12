package com.example.apiserie.model;


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
public class Season implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;


    private Long seasonId;

    private Integer seasonNumber;

    private List<Chapter> chapters = new ArrayList<>();



}
