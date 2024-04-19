package com.pinheiro.user.services;

import com.pinheiro.user.models.UserModel;
import com.pinheiro.user.producers.UserProducer;
import com.pinheiro.user.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserProducer producer;

    @Autowired
    private UserRepository repository;

    @Transactional
    public UserModel save(UserModel userModel){
        userModel = repository.save(userModel);
        producer.publishMessage(userModel);
        return userModel;
    }
}
