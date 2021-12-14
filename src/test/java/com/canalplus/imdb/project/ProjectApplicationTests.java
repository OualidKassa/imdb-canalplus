package com.canalplus.imdb.project;

import com.canalplus.imdb.project.controller.ImdbRestController;
import com.canalplus.imdb.project.dto.EpisodeBasicsSearch;
import com.canalplus.imdb.project.dto.NameAndProfession;
import com.canalplus.imdb.project.exception.NamesCrewNotFindException;
import com.canalplus.imdb.project.exception.SeriesNotFindException;
import com.canalplus.imdb.project.model.Name;
import com.canalplus.imdb.project.service.SearchCrewFromTitleService;
import com.canalplus.imdb.project.service.SearchNameService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProjectApplicationTests  {

    @Autowired
    SearchNameService searchNameService;

    @Autowired
    SearchCrewFromTitleService searchCrewFromTitleService;

    @Autowired
    ImdbRestController imdbRestController;

    @Test
    public void shouldReturnListSeriesWIthMostEpisode(){
        Optional<List<EpisodeBasicsSearch>> expected =  searchNameService.searchSeriesWIthMostEpisode();
        Assertions.assertFalse(expected.get().isEmpty());
        Assertions.assertEquals(expected.get().get(0).getPrimaryTitle(),"Quick Fix: Denim on Denim");
    }

    @Test
    public void shouldReturnCrewFromTitle(){
        Optional<List<Name>> getNames =  searchCrewFromTitleService.getAllNameCrewFromTitle("Carmencita");
        Assertions.assertNotNull(getNames.get());
        Assertions.assertFalse(getNames.get().isEmpty());
    }

    @Test
    public void shouldConvertBasicsToEpisodeBasicsSearch(){
        Optional<List<Name>> getNames =  searchCrewFromTitleService.getAllNameCrewFromTitle("Carmencita");
        List<Name> getNamesForConvert = getNames.get();
        List<NameAndProfession> getNamesAndProfession = searchCrewFromTitleService.convertNamesToNameAndProfession(getNamesForConvert);
        Assertions.assertNotNull(getNamesAndProfession);
    }

    @Test
    public void ShouldReturnNamesCrewOfTitleFromController() throws NamesCrewNotFindException {
        List<NameAndProfession> getResultNamesCrewOfTitle =   imdbRestController.getNamesCrewOfTitle("Carmencita");
        Assertions.assertNotNull(getResultNamesCrewOfTitle);
    }

    @Test
    public void shouldReturnTopSeriesWithMostEpisodes() throws SeriesNotFindException {
        List<EpisodeBasicsSearch> getResultTopSeriesWithMostEpisodes =  imdbRestController.getTopSeriesWithMostEpisodes();
        Assertions.assertNotNull(getResultTopSeriesWithMostEpisodes);
    }
}
