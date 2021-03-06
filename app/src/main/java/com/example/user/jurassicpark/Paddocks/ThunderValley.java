package com.example.user.jurassicpark.Paddocks;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.FeedType;

import java.util.ArrayList;

public class ThunderValley extends Paddock {
    private ArrayList<IWalk> dinosaurList;

    public ThunderValley(PaddockType type, ArrayList<IWalk> dinosaurList) {
        super(type);
        this.dinosaurList = dinosaurList;
    }

    public int dinosaurCount() {
        return this.dinosaurList.size();
    }

    public void addDinosaur(IWalk dinosaur) {
        this.dinosaurList.add(dinosaur);
    }

    public void removeDinosaur(IWalk dinosaur) {
        this.dinosaurList.remove(dinosaur);
    }

    public void transferHerbivore(IWalk dinosaur, CloudForest paddock) {
        if (dinosaur.getFeedType() == FeedType.HERBIVORE) {
            this.removeDinosaur(dinosaur);
            paddock.addDinosaur(dinosaur);
        }

    }
}
