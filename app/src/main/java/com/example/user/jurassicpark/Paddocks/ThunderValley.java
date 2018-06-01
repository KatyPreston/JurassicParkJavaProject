package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

import java.util.ArrayList;

public class ThunderValley extends Paddock {
    private ArrayList<IWalk> dinosaurList;

    public ThunderValley(PaddockType type, ArrayList<IWalk> dinosaurList){
        super(type);
        this.dinosaurList = dinosaurList;
    }

    public int dinosaurCount(){
        return this.dinosaurList.size();
    }
}