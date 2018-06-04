package com.example.user.jurassicpark.Park;

import com.example.user.jurassicpark.Paddocks.Paddock;
import com.example.user.jurassicpark.Visitors.Visitor;

import java.util.ArrayList;

public class Park {
    private ArrayList<Paddock> paddocks;
    private ArrayList<Visitor> visitors;
    private double money;

    public Park(ArrayList<Paddock> paddocks, ArrayList<Visitor> visitors, double money){
        this.paddocks = paddocks;
        this.visitors = visitors;
        this.money = money;
    }

    public double totalMoney(){
        return this.money;
    }

    public int visitorCount(){
        return this.visitors.size();
    }

    public void addVisitor(Visitor visitor){
        this.visitors.add(visitor);
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
}
