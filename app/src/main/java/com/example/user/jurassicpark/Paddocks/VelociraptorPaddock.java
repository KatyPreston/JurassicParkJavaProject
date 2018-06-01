package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
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
}
