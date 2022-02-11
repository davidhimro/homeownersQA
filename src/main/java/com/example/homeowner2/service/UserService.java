package com.example.homeowner2.service;
import org.springframework.stereotype.Service;

import com.example.homeowner2.domain.User2;
import com.example.homeowner2.userrepo.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    // Temporary storage
    //private List<User> users = new ArrayList<>();

    private UserRepo repo;

    public UserService(UserRepo repo){
        this.repo=repo;}

    //Create service method
    public User2 create(User2 user){
        return this.repo.saveAndFlush(user);
    }

    //Read All - Return a response entity containing the whole list
    public List<User2> getAll(){
        return repo.findAll();
    }

    //Read One By Id -
    public User2 getById(Long id){
        return this.repo.findById(id).orElseThrow(/*UserNotFoundException::new*/);
        //or else throws custom exception to say entity not found instead of
        // failing with a null value.
    }

}