package com.example.bookmyshow.Controllers;

import com.example.bookmyshow.RequestDto.UserRequestDto;
import com.example.bookmyshow.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/add")
  //  public ResponseEntity<String> createUser(@RequestBody()UserRequestDto userRequestDto){ //try this
    public String addUser(@RequestBody UserRequestDto userRequestDto){
        return userService.createUser(userRequestDto);
    }

}
