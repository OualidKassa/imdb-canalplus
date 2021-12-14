package com.canalplus.imdb.project.repository;

import com.canalplus.imdb.project.dto.EpisodeBasicsSearch;

import java.util.List;


public interface SearchSeriesRepository  {

    List<EpisodeBasicsSearch> searchSeriesNameWithGreatestNumberEpisodes();


}
