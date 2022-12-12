package com.example.apiserie.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Chapter implements Serializable{

    @Serial
    private static final long serialVersionUID = 1L;


    private Long chapterId;

    private String name;

    private Integer number;

    private String urlStream;

}
