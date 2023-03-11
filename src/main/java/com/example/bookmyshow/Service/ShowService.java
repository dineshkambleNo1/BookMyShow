package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.*;
import com.example.bookmyshow.Repository.MovieRepository;
import com.example.bookmyshow.Repository.ShowRepository;
import com.example.bookmyshow.Repository.ShowSeatRepository;
import com.example.bookmyshow.Repository.TheaterRepository;
import com.example.bookmyshow.RequestDto.ShowRequestDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class ShowService {

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    TheaterRepository theaterRepository;

    @Autowired
    ShowSeatRepository showSeatRepository;
    @Autowired
    ShowRepository showRepository;


    public String addShow(ShowRequestDto showRequestDto){

        //date and time we will get from dto
        Show show = Show.builder().showDate(showRequestDto.getShowDate()).multiplier(showRequestDto.getMultiplier()).showTime(showRequestDto.getShowTime()
        ).build();

        //movie we got from dto need to find in repo
        Movies movie = movieRepository.findByname(showRequestDto.getMovieName());

        //theaterId we got from dto need to find in repo
        Theater theater = theaterRepository.findById(showRequestDto.getTheaterId()).get();

        //set theater and movie in show entity
        show.setTheater(theater);
        show.setMovie(movie);

        //due bidirectional mapping
        //Optional things :
//        List<ShowEntity> currentListOfShow = movieEntity.getListOfShows();
//        currentListOfShow.add(showEntity);
//        movieEntity.setListOfShows(currentListOfShow); // same we need as theater OR

        movie.getListOfShows().add(show);
        theater.getListOfShows().add(show);
        //theaterRepository.save(theaterEntity);


//list<Show seats> attribute is also there,so we need to tackle that
        List<ShowSeats> seatsList  = createShowSeats(theater.getTheaterSeats());
        show.setListOfSeats(seatsList);


 //For each ShowSeat :we need to mark that to which show it belongs (foriegn key will be filled )

        for(ShowSeats showSeat:seatsList){
            showSeat.setShow(show);
        }
        showRepository.save(show);

        movieRepository.save(movie);
        theaterRepository.save(theater);
        //showRepository.save(showEntity); this doessnt need to be called bcz parent(movie  )save function is being called.

        return "Show added successfully";

    }
    public List<ShowSeats> createShowSeats(List<TheaterSeat> theaterSeats){
        List<ShowSeats> seats = new ArrayList<>();

        for(TheaterSeat theaterSeat : theaterSeats){     //iterating over the actual tehater seat list that i got from parameter line 39 and creating show seat from that;
            ShowSeats showSeats = ShowSeats.builder().seatType(theaterSeat.getSeatType()).seatNo(theaterSeat.getSeatNo()).build();
            seats.add(showSeats);
        }
        showSeatRepository.saveAll(seats);
        return  seats;
    }
}
