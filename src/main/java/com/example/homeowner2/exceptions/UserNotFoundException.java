package com.example.homeowner2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.persistence.EntityNotFoundException;

@ResponseStatus(code= HttpStatus.NOT_FOUND, reason = "User does not exist with that ID")

public class UserNotFoundException  extends EntityNotFoundException {


}