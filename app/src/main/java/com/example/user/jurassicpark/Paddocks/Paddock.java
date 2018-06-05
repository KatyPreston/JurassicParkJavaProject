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
        if(this.boundaryHealth < 0){
            this.boundaryHealth = 0;
        }
        return this.boundaryHealth;
    }

    public abstract int dinosaurCount();

    public String feedDinosaur(Dinosaur dinosaur){
        dinosaur.eat();
        return "Mmmm";
    }

    public void dinosaurHitBoundary(Dinosaur dinosaur){
        if(dinosaur.rampage() == true)
        this.boundaryHealth -= dinosaur.getRampagePower();
    }


    public String dinosaurEscapes(Dinosaur dinosaur){
        if (dinosaur.rampage() == true)
        while(this.boundaryHealth > 0){
        dinosaurHitBoundary(dinosaur);
        }
        return "Run for your lives!!";
    }



}
