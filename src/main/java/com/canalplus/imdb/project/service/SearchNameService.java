package com.canalplus.imdb.project.service;

import com.canalplus.imdb.project.dto.EpisodeBasicsSearch;
import java.util.List;
import java.util.Optional;


public interface SearchNameService {

    Optional<List<EpisodeBasicsSearch>> searchSeriesWIthMostEpisode();

}
