package com.example.bookmyshow.Models;

import com.example.bookmyshow.Enums.SeatType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="theater_seats")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TheaterSeat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String seatNo;

    @Enumerated(value=EnumType.STRING)
    private SeatType seatType;

    private int rate; // can we automatically set rate A/Q to seat type???

    @ManyToOne
    @JoinColumn
    private Theater theater;

    public TheaterSeat(String seatNo, SeatType seatType, int rate) {
        this.seatNo = seatNo;
        this.seatType = seatType;
        this.rate = rate;
    }
}
