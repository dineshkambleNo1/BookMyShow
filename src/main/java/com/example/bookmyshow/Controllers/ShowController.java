package com.example.bookmyshow.Controllers;

import com.example.bookmyshow.RequestDto.ShowRequestDto;
import com.example.bookmyshow.Service.ShowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/show")

public class ShowController {

    @Autowired
    ShowService showService;

    @PostMapping("/add")
     public String createShow(@RequestBody ShowRequestDto showRequestDto){
        return showService.addShow(showRequestDto);
    }
}
