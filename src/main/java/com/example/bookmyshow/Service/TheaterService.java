package com.example.bookmyshow.Service;

import com.example.bookmyshow.Enums.SeatType;
import com.example.bookmyshow.Models.Theater;
import com.example.bookmyshow.Models.TheaterSeat;
import com.example.bookmyshow.Repository.TheaterRepository;
import com.example.bookmyshow.Repository.TheaterSeatRepository;
import com.example.bookmyshow.RequestDto.TheaterRequestDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class TheaterService {

    @Autowired
    TheaterSeatRepository theaterSeatRepository;

    @Autowired
    TheaterRepository theaterRepository;

    public String createTheater(TheaterRequestDto theaterRequestDto){

        //1 set theater entity, i.e fill values got in DTOs
        Theater theater = Theater.builder().name(theaterRequestDto.getName()).city(theaterRequestDto.getCity()).address(theaterRequestDto.getAddress()).build();
//no,type,rate
// 2.1  List<TheaterSeat> bhi needed to set as its attribute of theater entity, so 1st get/create List<Seat>
//  than set list as we set other attributes.
        List<TheaterSeat> theaterSeatList = createTheaterSeat();
//2.3 list of seats we created below is stored in theaterSeatList, so now set it also
        theater.setTheaterSeats(theaterSeatList);  //due to bidirectinal

//2.4 For each theater Seat : we need to set the theaterEntity
        for(TheaterSeat theaterSeat :theaterSeatList ){
            theaterSeat.setTheater(theater);
        }
        theaterRepository.save(theater);
        return "Theater added successfully";
    }

//2.2
    private List<TheaterSeat> createTheaterSeat(){

        List<TheaterSeat> seats = new ArrayList<>();

        TheaterSeat theaterSeat1 = new TheaterSeat("1A", SeatType.CLASSIC, 100); //parameters A/Q to constructor
        TheaterSeat theaterSeat2 = new TheaterSeat("1B", SeatType.CLASSIC, 100);
        TheaterSeat theaterSeat3 = new TheaterSeat("1C", SeatType.CLASSIC, 100);
        TheaterSeat theaterSeat4 = new TheaterSeat("1D", SeatType.CLASSIC, 100);
        TheaterSeat theaterSeat5 = new TheaterSeat("1E", SeatType.CLASSIC, 100);

        TheaterSeat theaterSeat6 = new TheaterSeat("2A", SeatType.PLATINUM, 200);
        TheaterSeat theaterSeat7 = new TheaterSeat("2B", SeatType.PLATINUM, 200);
        TheaterSeat theaterSeat8 = new TheaterSeat("2C", SeatType.PLATINUM, 200);
        TheaterSeat theaterSeat9 = new TheaterSeat("2D", SeatType.PLATINUM, 200);
        TheaterSeat theaterSeat10 = new TheaterSeat("2E", SeatType.PLATINUM, 200);

        seats.add(theaterSeat1);
        seats.add(theaterSeat2);
        seats.add(theaterSeat3);
        seats.add(theaterSeat4);
        seats.add(theaterSeat5);
        seats.add(theaterSeat6);
        seats.add(theaterSeat7);
        seats.add(theaterSeat8);
        seats.add(theaterSeat9);
        seats.add(theaterSeat10);

        theaterSeatRepository.saveAll(seats);

        return seats;
    }
}
