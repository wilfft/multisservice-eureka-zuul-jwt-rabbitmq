package com.example.authentication.message;

import com.example.authentication.dto.LoginDTO;
import com.example.authentication.entity.Login;
import com.example.authentication.repository.LoginRepository;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;


@Component
public class LoginReceiveMessage {

    @Autowired
    LoginRepository repository;

    @RabbitListener(queues = {"${cadastro.login.rabbitmq.queue}"})
    public void receiveMessage(@Payload LoginDTO loginDTO) {
       System.out.println(loginDTO);
        repository.save(new Login(null, loginDTO.getEmail(), loginDTO.getPassword()));


    }
}


