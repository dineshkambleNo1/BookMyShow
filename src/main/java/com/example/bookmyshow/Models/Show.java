package com.example.bookmyshow.Models;

import jakarta.persistence.*;
import lombok.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="shows")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Show {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate showDate;

    private LocalTime showTime;

    private double multiplier;

    @CreationTimestamp
    private Date createdOn;

    @UpdateTimestamp
    private Date updatedOn;

    @ManyToOne
    @JoinColumn
    private Movies movie;

    //theater
    @ManyToOne
    @JoinColumn
    private Theater theater;

    @OneToMany(mappedBy = "show",cascade = CascadeType.ALL)
    private List<Tickets> listofTickets;


    //show seat
    @OneToMany(mappedBy = "show", cascade = CascadeType.ALL)
    private List<ShowSeats> listOfSeats;//virtualSeats for booking,which are replica of actual theater seats

}
