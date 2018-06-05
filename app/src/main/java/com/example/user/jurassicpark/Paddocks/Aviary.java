package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;

import java.util.ArrayList;

public class Aviary extends Paddock {
    private ArrayList<IFly> dinosaurList;

    public Aviary(PaddockType type, ArrayList<IFly> dinosaurList){
        super(type);
        this.dinosaurList = dinosaurList;
    }

    public int dinosaurCount(){
        return this.dinosaurList.size();
    }

    public void addDinosaur(IFly dinosaur){
        this.dinosaurList.add(dinosaur);
    }

    public void removeDinosaur(IFly dinosaur){
        this.dinosaurList.remove(dinosaur);
    }
}
