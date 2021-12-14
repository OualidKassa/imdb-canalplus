package com.canalplus.imdb.project.repository;

import com.canalplus.imdb.project.model.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchNameRepository extends JpaRepository<Name, Integer> {

    @Query(value = "select  n.id_name,n.nconst, n.primaryName, n.birthYear, n.deathYear, n.primaryProfession, n.knowForTitles from Name n join Title t on t.nconst = n.nconst where t.tconst in (" +
            " select  b.tconst from Basics b where b.primaryTitle = :title ) " +
            "order by n.primaryName", nativeQuery = true)
    List<Name> getCrewOfTitle(@Param("title") String title);
}
