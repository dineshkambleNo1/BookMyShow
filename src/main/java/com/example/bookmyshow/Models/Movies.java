package com.example.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.*;

@Entity
@Table//(name="movies")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Movies {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false,unique = true)
    private String name;

    private Date releaseDate;

    private int duration;

    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Show> listOfShows;

}
