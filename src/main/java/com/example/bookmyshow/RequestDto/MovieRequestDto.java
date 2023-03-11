package com.example.bookmyshow.RequestDto;

import lombok.Data;

import java.sql.Date;

@Data
public class MovieRequestDto {

    private String name;
    private Date releaseDate;
    private int duration;

}
