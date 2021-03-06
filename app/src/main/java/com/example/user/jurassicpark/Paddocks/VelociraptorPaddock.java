package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.Dinosaurs.Velociraptor;

import java.util.ArrayList;

public class VelociraptorPaddock extends Paddock {
    private ArrayList<Velociraptor> dinosaurList;

    public VelociraptorPaddock(PaddockType type, ArrayList<Velociraptor> dinosaurList){
        super(type);
        this.dinosaurList = dinosaurList;
    }

    public int dinosaurCount(){
        return this.dinosaurList.size();
    }

    public void addDinosaur(Velociraptor dinosaur){
        this.dinosaurList.add(dinosaur);
    }

    public void removeDinosaur(Velociraptor dinosaur){
        this.dinosaurList.remove(dinosaur);
    }

    public ArrayList getDinosaurs(){
        return this.dinosaurList;
    }

    public void emptyPaddock(){
        this.dinosaurList.clear();
    }
}
