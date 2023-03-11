package com.example.bookmyshow.Models;

import com.example.bookmyshow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.*;


import java.util.Date;

@Entity
@Table
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class ShowSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

   // private int rate;

    private String seatNo;

    @Enumerated(value=EnumType.STRING) //to tell sql ki u consider it as string

    private SeatType seatType;

    private boolean booked;

    private Date bookedAt;

    @ManyToOne
    @JoinColumn
    private Show show;

    @ManyToOne
    @JoinColumn
    private Tickets ticket;





}
