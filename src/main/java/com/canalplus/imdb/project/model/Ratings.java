package com.canalplus.imdb.project.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name="ratings")
public class Ratings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ratings")
    private Integer id_ratings;
    private String tconst;
    private Double averageRating;
    private Integer numVotes;
}
