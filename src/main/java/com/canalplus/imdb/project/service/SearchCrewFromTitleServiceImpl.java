package com.canalplus.imdb.project.service;

import com.canalplus.imdb.project.dto.NameAndProfession;
import com.canalplus.imdb.project.model.Name;
import com.canalplus.imdb.project.repository.SearchNameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SearchCrewFromTitleServiceImpl implements SearchCrewFromTitleService {


    private  SearchNameRepository searchNameRepository;

    @Autowired
    public SearchCrewFromTitleServiceImpl(SearchNameRepository searchNameRepository) {
        this.searchNameRepository = searchNameRepository;
    }



    @Override
    public Optional<List<Name>> getAllNameCrewFromTitle(String title) {
        List<Name> getNames = searchNameRepository.getCrewOfTitle(title);
        return Optional.of(getNames);
    }

    @Override
    public List<NameAndProfession> convertNamesToNameAndProfession(List<Name> names) {
        return names
                .stream()
                .map(elt -> new NameAndProfession(elt.getPrimaryName(), elt.getPrimaryProfession()))
                .collect(Collectors.toList());
    }
}
