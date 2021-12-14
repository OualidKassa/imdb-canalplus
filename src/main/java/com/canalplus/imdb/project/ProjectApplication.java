package com.canalplus.imdb.project;

import com.canalplus.imdb.project.controller.ImdbRestController;
import com.canalplus.imdb.project.repository.SearchNameRepository;
import com.canalplus.imdb.project.repository.SearchSeriesRepository;
import com.canalplus.imdb.project.repository.SearchSeriesRepositoryImpl;
import com.canalplus.imdb.project.service.SearchCrewFromTitleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjectApplication {



    public static void main(String[] args) {
        SpringApplication.run(ProjectApplication.class, args);
    }

}
