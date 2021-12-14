package com.canalplus.imdb.project.model;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="episode")
public class Episode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_episode")
    private Integer id_episode;
    private String tconst;
    private String parentTconst;
    private Integer seasonNumber;
    private Integer episodeNumber;
}
