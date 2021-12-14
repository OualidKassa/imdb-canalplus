package com.canalplus.imdb.project.dto;

import com.canalplus.imdb.project.repository.SearchSeriesRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeBasicsSearch {
    private String primaryTitle;

    private Integer episodeNumber;
}
