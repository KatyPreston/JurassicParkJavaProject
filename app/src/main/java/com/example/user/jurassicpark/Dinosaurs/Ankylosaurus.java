package com.example.user.jurassicpark.Dinosaurs;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;

public class Ankylosaurus extends Dinosaur implements IWalk{

    public Ankylosaurus(FeedType feedType, String type, String name){
        super(feedType, type, name);
    }
}
