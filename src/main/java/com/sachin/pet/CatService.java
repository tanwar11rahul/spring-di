package com.sachin.pet;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class CatService implements PetService{
    @Override
    public String favPet() {
        return "Cats are the best!";
    }
}
