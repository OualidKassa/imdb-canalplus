package com.canalplus.imdb.project.repository;

import com.canalplus.imdb.project.dto.EpisodeBasicsSearch;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class SearchSeriesRepositoryImpl implements SearchSeriesRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<EpisodeBasicsSearch> searchSeriesNameWithGreatestNumberEpisodes() {



        String queryStr =
                "select new com.canalplus.imdb.project.dto.EpisodeBasicsSearch(b.primaryTitle, e.episodeNumber) from Basics b " +
                        "             inner join fetch Episode e on e.tconst = b.tconst " +
                        "             where   e.episodeNumber in " +
                        "             (select e.episodeNumber from Episode e ) order by e.episodeNumber " +
                        "             desc  ";
        List<EpisodeBasicsSearch> query =
                em.createQuery(queryStr, EpisodeBasicsSearch.class).setMaxResults(10).getResultList();
        return query;
    }
}
