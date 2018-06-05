package com.example.user.jurassicpark.Paddocks;


import com.example.user.jurassicpark.Dinosaurs.Dinosaur;

public abstract class Paddock {
    private PaddockType type;
    private int boundaryHealth;

    public Paddock(PaddockType type){
        this.type = type;
        this.boundaryHealth = 100;
    }

    public PaddockType getType() {
        return this.type;
    }

    public int getBoundaryHealth(){
        return this.boundaryHealth;
    }

    public abstract int dinosaurCount();

    public String feedDinosaur(Dinosaur dinosaur){
        dinosaur.eat();
        return "Mmmm";
    }

    public void dinosaurRampage(Dinosaur dinosaur){
        this.boundaryHealth -= dinosaur.getRampagePower();
    }



}
