package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.Show;
import com.example.bookmyshow.Models.ShowSeats;
import com.example.bookmyshow.Models.Tickets;
import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Repository.ShowRepository;
import com.example.bookmyshow.Repository.UserRepository;
import com.example.bookmyshow.RequestDto.BookTicketRequestDto;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Data
public class TicketService {

    @Autowired
    ShowRepository showRepository;

    @Autowired
    UserRepository userRepository;

    public String bookTicket(BookTicketRequestDto bookTicketRequestDto)throws Exception {
        //get the req seats
        List<String> requestedSeats = bookTicketRequestDto.getRequestSeats();

        //get show id and save in show entity and user id form user
        Show show = showRepository.findById(bookTicketRequestDto.getShowId()).get();

        User user = userRepository.findById(bookTicketRequestDto.getUserId()).get();

        //To validate the showSeats with req seats, get list<ShowSeats> from Show
        List<ShowSeats> virtualSeats = show.getListOfSeats(); //ShowEntity line 54

        //comparing with req seats and if available add in
        List<ShowSeats> bookedSeats = new ArrayList<>();

        for (ShowSeats showSeat : virtualSeats) {
            String seatNo = showSeat.getSeatNo();
            if (requestedSeats.contains(seatNo) && showSeat.isBooked() == false) {
                bookedSeats.add(showSeat);
            }
        }
        //FAILURE
        if (bookedSeats.size() != requestedSeats.size()) {
            //seats are not available
            throw new Exception("Requested seats are not available");
        }

        //Success, if statement not executed,seats are validated and are available
        //setting/filling attributes of ticket entity and show entity.
        Tickets ticket = new Tickets();

        double multiplier = show.getMultiplier();
        double totalAmount = 0;

        String allotedSeats = "";
        int rate = 0;

        for (ShowSeats bookedSeat : bookedSeats) {

            bookedSeat.setBooked(true);
            bookedSeat.setBookedAt(new Date());
            bookedSeat.setTicket(ticket);
            bookedSeat.setShow(show);

            String seatNo = bookedSeat.getSeatNo();
            allotedSeats = allotedSeats + seatNo + ",";

            if (seatNo.charAt(0) == '1')
                rate = 100;
            else
                rate = 200;

            totalAmount = totalAmount + multiplier * rate;

        }
        return "Sucessfully created a ticket";
    }
}
