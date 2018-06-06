package com.example.user.jurassicpark.MockTestable;

public class FakeDinosaur {
    private int hungerLevel;
    private int rampagePower;

    public FakeDinosaur(int hungerLevel){
        this.hungerLevel = hungerLevel;
        this.rampagePower = 50;
    }


    public int getRampagePower(){
        return this.rampagePower;
    }

    public int getHungerLevel(){
        if(this.hungerLevel < 0){
            this.hungerLevel = 0;
        }
        return this.hungerLevel;
    }


    public boolean rampage(){
        if(this.hungerLevel >= 6){
            return true;
        }
        else return false;
    }
}
