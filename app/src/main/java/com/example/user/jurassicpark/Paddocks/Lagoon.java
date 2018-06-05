package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;

import java.util.ArrayList;

public class Lagoon extends Paddock {
    private ArrayList<ISwim> dinosaurList;

    public Lagoon(PaddockType type, ArrayList<ISwim> dinosaurList){
        super(type);
        this.dinosaurList = dinosaurList;
    }

    public int dinosaurCount(){
        return this.dinosaurList.size();
    }

    public void addDinosaur(ISwim dinosaur){
        this.dinosaurList.add(dinosaur);
    }

    public void removeDinosaur(ISwim dinosaur){
        this.dinosaurList.remove(dinosaur);
    }
}
