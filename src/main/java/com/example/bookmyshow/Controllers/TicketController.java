package com.example.bookmyshow.Controllers;


import com.example.bookmyshow.RequestDto.BookTicketRequestDto;
import com.example.bookmyshow.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;

    @PostMapping("/book")
    public String bookTicket(BookTicketRequestDto bookTicketRequestDto){

        try {
            return ticketService.bookTicket(bookTicketRequestDto);
        }catch (Exception e){
            return "Requested Seats not available";
        }

    }
}

