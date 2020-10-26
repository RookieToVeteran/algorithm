package com.algorithm.test.publishandlisten;

import com.algorithm.dto.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class RegisterControll {

    @Autowired
    private RegisterService registerService;


    @GetMapping("register")
    public void register(){
        User user = new User();
        user.setName("王鹏鹏");
        user.setPhone("13671737928");
        registerService.register(user);
    }
}
