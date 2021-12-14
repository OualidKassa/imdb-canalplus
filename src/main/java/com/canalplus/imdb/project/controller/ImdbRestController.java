package com.canalplus.imdb.project.controller;

import com.canalplus.imdb.project.exception.NamesCrewNotFindException;
import com.canalplus.imdb.project.exception.SeriesNotFindException;
import com.canalplus.imdb.project.dto.EpisodeBasicsSearch;
import com.canalplus.imdb.project.dto.NameAndProfession;
import com.canalplus.imdb.project.service.SearchCrewFromTitleService;
import com.canalplus.imdb.project.service.SearchNameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/canalplus/imdb")
public class ImdbRestController {


    private  final SearchCrewFromTitleService searchCrewFromTitleService;


    private  final SearchNameService searchNameService;

    @Autowired
    public ImdbRestController(SearchCrewFromTitleService searchCrewFromTitleService, SearchNameService searchNameService) {
        this.searchCrewFromTitleService = searchCrewFromTitleService;
        this.searchNameService = searchNameService;
    }


    @GetMapping("/crews/{title}")
    @ResponseBody
    public List<NameAndProfession> getNamesCrewOfTitle(@PathVariable String title) throws NamesCrewNotFindException {
            return searchCrewFromTitleService
                    .convertNamesToNameAndProfession(searchCrewFromTitleService.getAllNameCrewFromTitle(title)
                            .orElseThrow(() -> new NamesCrewNotFindException("Title not find !")));
    }

    @GetMapping("/mostepisode")
    @ResponseBody
    public List<EpisodeBasicsSearch> getTopSeriesWithMostEpisodes() throws SeriesNotFindException {
        return searchNameService.searchSeriesWIthMostEpisode().orElseThrow(() -> new SeriesNotFindException("Series not find !"));
    }

}
