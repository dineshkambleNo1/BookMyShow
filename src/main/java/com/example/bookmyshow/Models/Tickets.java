package com.example.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Entity
@Table
@Data
public class Tickets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String alloted_seats;
    private int amount;
    private Date booked_at;

    @ManyToOne
    @JoinColumn
    private User user;

    //show
    @ManyToOne
    @JoinColumn
    private Show show;

    @OneToMany(mappedBy = "ticket",cascade = CascadeType.ALL)
    private List<ShowSeats> bookedSeats;


}
