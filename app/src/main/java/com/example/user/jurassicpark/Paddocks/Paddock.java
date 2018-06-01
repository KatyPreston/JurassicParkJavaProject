package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.Dinosaurs.Dinosaur;

import java.util.ArrayList;

public abstract class Paddock {
    private PaddockType type;
    private ArrayList<Dinosaur> dinosaurList;

    public Paddock(PaddockType type, ArrayList<Dinosaur> dinosaurList){
        this.type = type;
        this.dinosaurList = dinosaurList;
    }
}
