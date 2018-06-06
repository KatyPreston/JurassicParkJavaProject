package com.example.user.jurassicpark.MockTestable;


public class FakePark {
    private FakePaddock paddock;
    private double revenue;

    public FakePark(FakePaddock paddock){
        this.paddock = paddock;
        this.revenue = 0;
    }

    public double totalRevenue(){
        return this.revenue;
    }

    public void repairPaddock(FakePaddock paddock){
        paddock.setBoundaryHealth(100);
        this.revenue -= 50;
    }
}
