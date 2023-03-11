package com.example.bookmyshow.Service;

import com.example.bookmyshow.Models.User;
import com.example.bookmyshow.Repository.UserRepository;
import com.example.bookmyshow.RequestDto.UserRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public String createUser(UserRequestDto userRequestDto){
        //cnverting userREqDto to user entity...can different use converter layer
        User user =User.builder().name(userRequestDto.getName()).mobile(userRequestDto.getMobile()).build();
        try {
            userRepository.save(user);
        }
        catch (Exception e){
           return  "User could not be added";
        }
        return "User added successfully";

    }


}
