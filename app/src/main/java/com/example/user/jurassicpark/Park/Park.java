package com.example.user.jurassicpark.Park;

import com.example.user.jurassicpark.Paddocks.Paddock;
import com.example.user.jurassicpark.Visitors.Visitor;

import java.util.ArrayList;

public class Park {
    private ArrayList<Paddock> paddocks;
    private ArrayList<Visitor> visitors;
    private double revenue;
    private int visitorCapacity;

    public Park(ArrayList<Paddock> paddocks, ArrayList<Visitor> visitors, double revenue, int visitorCapacity){
        this.paddocks = paddocks;
        this.visitors = visitors;
        this.revenue = revenue;
        this.visitorCapacity = visitorCapacity;
    }

    public double totalRevenue(){
        return this.revenue;
    }

    public int getVisitorCapacity() {
        return this.visitorCapacity;
    }

    public int visitorCount(){
        return this.visitors.size();
    }

    public void addVisitor(Visitor visitor){
        if(visitorCount() < visitorCapacity){
        this.visitors.add(visitor); }
    }

    public void removeVisitor(Visitor visitor){
        this.visitors.remove(visitor);
    }

    public int paddockCount(){
        return this.paddocks.size();
    }

    public void addPaddock(Paddock paddock){
        this.paddocks.add(paddock);
    }

    public void removePaddock(Paddock paddock){
        this.paddocks.remove(paddock);
    }

    public void chargeEntry(Visitor visitor){
        visitor.payEntry(50);
        this.addVisitor(visitor);
        this.revenue += 50;
    }


}
