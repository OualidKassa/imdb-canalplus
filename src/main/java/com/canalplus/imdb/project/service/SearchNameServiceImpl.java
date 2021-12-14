package com.canalplus.imdb.project.service;

import com.canalplus.imdb.project.dto.EpisodeBasicsSearch;
import com.canalplus.imdb.project.repository.SearchSeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SearchNameServiceImpl implements SearchNameService {

    private final SearchSeriesRepository searchSeriesRepository;

    @Autowired
    public SearchNameServiceImpl(SearchSeriesRepository searchSeriesRepository) {
        this.searchSeriesRepository = searchSeriesRepository;
    }

    @Override
    public Optional<List<EpisodeBasicsSearch>> searchSeriesWIthMostEpisode() {
        List<EpisodeBasicsSearch> searchMostepisodes = searchSeriesRepository.searchSeriesNameWithGreatestNumberEpisodes();
        return Optional.of(searchMostepisodes);
    }


}
