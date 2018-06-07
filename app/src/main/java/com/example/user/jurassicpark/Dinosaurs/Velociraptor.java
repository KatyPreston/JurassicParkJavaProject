package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.Paddocks.VelociraptorPaddock;

public class Velociraptor extends Dinosaur{
    private int rampagePower;

    public Velociraptor(FeedType feedType, String type, String name){
        super(feedType, type, name);
        this.rampagePower = 30;
    }

    public int getRampagePower(){
        return this.rampagePower;
    }

    public void callForBackup(VelociraptorPaddock paddock){
        if(paddock.getDinosaurs().contains(this)){
        int dinosaurs = paddock.getDinosaurs().size() - 1;
        int power = this.rampagePower * dinosaurs;
        this.rampagePower += power;
        paddock.emptyPaddock(); }
    }

}
