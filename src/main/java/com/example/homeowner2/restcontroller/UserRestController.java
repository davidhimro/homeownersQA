package com.example.homeowner2.restcontroller;


import com.example.homeowner2.domain.User2;
import com.example.homeowner2.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

//Annotation telling spring this class manages the income Rest API requests//
//This has to be before the component class public class Controller to work//

@RestController //Deals with JSON Data//
@RequestMapping("/user") //http://localhost:8080/user/...
// 200 - OK, 201 - Created, 202 - Accepted, 204 - No Content, 400 - Bar Request, 404 - Not Found
public class UserRestController {

    //Connects the controller to the service class
    private UserService service;

    //Constructor Injection to Utilise Inversion of Control to initiate the Service Bean
    //and pull into the inversion of control container / or "Bean Bag"
    public  UserRestController(UserService service){
        this.service = service;
    }

    @GetMapping("/hello") //http://localhost:8080/user/hello
    public String helloWorld() {
        return "Hello, World";
    }

    // Create method. Creates an object and the RequestBody annotation expects JSON Data from post request//
    @PostMapping("/create")
    public ResponseEntity<User2> create(@RequestBody User2 user){
        //Adds the income post request json data to the user object
        //this.users.add(user);
        // Returns most recently added user from the list//
        // Returns http status code is post request is successful along with the User object
        return new ResponseEntity<User2>(this.service.create(user), HttpStatus.CREATED);
        //return this.users.get(this.users.size()-1);
    }

    //Read - Maps the get request from to retrieve a list of all records in the user database
    @GetMapping("/getAll")
    public ResponseEntity<List<User2>> getAll() {
        //return the whole list//
        return new ResponseEntity<List<User2>>(this.service.getAll(), HttpStatus.OK);
    }
    // Creates a mapping request to fetch a single record by their id.
    @GetMapping("getOne/{id}")
    public ResponseEntity<User2> getById(@PathVariable Long id){
        return new ResponseEntity<User2>(this.service.getById(id),HttpStatus.OK);
    }
    // Custom Query - Get by username
    @GetMapping("/get")
    public ResponseEntity<List<User2>> getByFirstName(@PathParam("firstName") String firstName){
        return new ResponseEntity<>(this.service.getByFirstName(firstName), HttpStatus.OK);
    }

    //Update endpoint
    @PutMapping("/update/{id}")
    public ResponseEntity<User2> update(@PathVariable Long id, @PathVariable User2 user){
        return new ResponseEntity<User2>(this.service.update(id, user),HttpStatus.ACCEPTED );
    }
    //Delete endpoint
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<User2> delete(@PathVariable Long id) {
        return this.service.delete(id) ?
                new ResponseEntity<User2>(HttpStatus.NO_CONTENT):
                new ResponseEntity<User2>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
