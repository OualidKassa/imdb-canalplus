package com.canalplus.imdb.project.service;

import com.canalplus.imdb.project.dto.NameAndProfession;
import com.canalplus.imdb.project.model.Name;
import java.util.List;
import java.util.Optional;


public interface SearchCrewFromTitleService {
    Optional<List<Name>> getAllNameCrewFromTitle(String title);
    List<NameAndProfession> convertNamesToNameAndProfession(List<Name> names);
}
