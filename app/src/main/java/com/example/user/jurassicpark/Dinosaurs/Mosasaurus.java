package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;

public class Mosasaurus extends Dinosaur implements ISwim {

    public Mosasaurus(FeedType feedType, String type, String name){
        super(feedType, type, name);
    }
}