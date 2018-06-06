package com.example.user.jurassicpark.MockTestable;

import com.example.user.jurassicpark.Paddocks.PaddockType;

public class FakePaddock {
    private PaddockType type;
    private int boundaryHealth;
    private FakeDinosaur dinosaur;

    public FakePaddock(PaddockType type,FakeDinosaur dinosaur){
        this.type = type;
        this.boundaryHealth = 100;
        this.dinosaur = dinosaur;
    }

    public int getBoundaryHealth(){
        if(this.boundaryHealth < 0){
            this.boundaryHealth = 0;
        }
        return this.boundaryHealth;
    }

    public int setBoundaryHealth(int value){
        return this.boundaryHealth = value;
    }


    public void dinosaurHitBoundary(FakeDinosaur dinosaur){
        if(dinosaur.rampage() == true)
            this.boundaryHealth -= dinosaur.getRampagePower();
    }

    public String dinosaurEscapes(FakeDinosaur dinosaur){
        if (dinosaur.rampage() == true)
            while(this.boundaryHealth > 0){
                dinosaurHitBoundary(dinosaur);
            }
        return "Run for your lives!!";
    }


}
