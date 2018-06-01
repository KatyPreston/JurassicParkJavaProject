package com.example.user.jurassicpark.Paddocks;



public abstract class Paddock {
    private PaddockType type;

    public Paddock(PaddockType type){
        this.type = type;
    }

    public PaddockType getType() {
        return this.type;
    }

    public abstract int dinosaurCount();


}
