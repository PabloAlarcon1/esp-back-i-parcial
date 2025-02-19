package com.dh.catalog.model;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Season implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Integer seasonId;

    private Integer seasonNumber;

    private List<Chapter> chapters = new ArrayList<>();



}
