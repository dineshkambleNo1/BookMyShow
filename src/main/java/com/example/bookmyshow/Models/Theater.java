package com.example.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Theater {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String address;
    private String city;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<Show> listOfShows;

    @OneToMany(mappedBy = "theater",cascade = CascadeType.ALL)
    private List<TheaterSeat> theaterSeats;

}
