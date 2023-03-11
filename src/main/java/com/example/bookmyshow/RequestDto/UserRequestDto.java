package com.example.bookmyshow.RequestDto;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
@Data
public class UserRequestDto {

    private String name;

    private String mobile;

// not needed :-
//    @CreationTimestamp
//    @Temporal(value = TemporalType.TIMESTAMP)
//    private Date createdOn;
}
