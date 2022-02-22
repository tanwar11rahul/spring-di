package com.sachin.pet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class DogService implements PetService{
    @Override
    public String favPet() {
        return "Dogs are the best!";
    }
}
