package com.pinheiro.user.services;

import com.pinheiro.user.models.UserModel;
import com.pinheiro.user.producers.UserProducer;
import com.pinheiro.user.repositories.UserRepository;
import jakarta.el.PropertyNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public List<UserModel> findAll(){
        return repository.findAll();
    }

    public Optional<UserModel> findById(UUID id) {
        return repository.findById(id);
    }

    public void deleteById(UUID id){
        repository.deleteById(id);
    }
}
