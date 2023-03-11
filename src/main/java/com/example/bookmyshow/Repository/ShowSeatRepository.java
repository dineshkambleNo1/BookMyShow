package com.example.bookmyshow.Repository;

import com.example.bookmyshow.Models.ShowSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeats, Integer> {
}
