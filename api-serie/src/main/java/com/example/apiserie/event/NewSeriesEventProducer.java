package com.example.apiserie.event;

import com.example.apiserie.config.RabbitMQConfig;
import com.example.apiserie.model.Chapter;
import com.example.apiserie.model.Season;
import com.example.apiserie.model.Serie;
import com.example.apiserie.model.dto.ChapterDTO;
import com.example.apiserie.model.dto.SeasonDTO;
import com.example.apiserie.model.dto.SerieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Component
@Slf4j
public class NewSeriesEventProducer {

    private final RabbitTemplate rabbitTemplate;

    public NewSeriesEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void execute(Serie serie) {
        SerieDTO serieDTO = new SerieDTO();
        BeanUtils.copyProperties(serie, serieDTO);
        for (Season s :
                serie.getSeasons()) {
            SeasonDTO sDTO = new SeasonDTO();
            BeanUtils.copyProperties(s, sDTO);
            for (Chapter c :
                    s.getChapters()) {
                ChapterDTO cDTO = new ChapterDTO();
                BeanUtils.copyProperties(c, cDTO);
                sDTO.getChapters().add(cDTO);
            }

            serieDTO.getSeasons().add(sDTO);
    }
        if (serieDTO.getSeasons().get(0).getChapters().get(0) != null && serie.getSeasons().get(0).getChapters().get(0) != null) {
            rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, RabbitMQConfig.TOPIC_NEW_SERIES, serieDTO);
        }

    }


}