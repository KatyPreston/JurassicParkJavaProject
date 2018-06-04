package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.Dinosaurs.TRex;

import java.util.ArrayList;

public class TRexPaddock extends Paddock {
    private ArrayList<TRex> dinosaurList;

    public TRexPaddock(PaddockType type, ArrayList<TRex> dinosaurList){
        super(type);
        this.dinosaurList = dinosaurList;
    }

    public int dinosaurCount(){
        return this.dinosaurList.size();
    }

    public void addDinosaur(TRex dinosaur){
        this.dinosaurList.add(dinosaur);
    }

    public void removeDinosaur(TRex dinosaur){
        this.dinosaurList.remove(dinosaur);
    }

}
