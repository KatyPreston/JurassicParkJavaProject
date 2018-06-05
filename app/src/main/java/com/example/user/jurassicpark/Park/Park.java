package com.example.user.jurassicpark.Park;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;
import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Dinosaurs.Velociraptor;
import com.example.user.jurassicpark.Paddocks.Aviary;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.Paddock;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.TRexPaddock;
import com.example.user.jurassicpark.Paddocks.ThunderValley;
import com.example.user.jurassicpark.Paddocks.VelociraptorPaddock;
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

        ArrayList<IFly> flyers = new ArrayList<>();
        ArrayList<IWalk> walkers = new ArrayList<>();
        ArrayList<IWalk> walkers2 = new ArrayList<>();
        ArrayList<ISwim> swimmers = new ArrayList<>();
        ArrayList<TRex> tRexes = new ArrayList<>();
        ArrayList<Velociraptor> velociraptors = new ArrayList<>();
        Aviary aviary = new Aviary(PaddockType.AVIARY, flyers);
        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, walkers);
        Lagoon lagoon = new Lagoon(PaddockType.LAGOON, swimmers);
        ThunderValley thunderValley = new ThunderValley(PaddockType.THUNDERVALLEY, walkers2);
        TRexPaddock tRexPaddock = new TRexPaddock(PaddockType.TREX_PADDOCK, tRexes);
        VelociraptorPaddock velociraptorPaddock = new VelociraptorPaddock(PaddockType.VELOCIRAPTOR_PADDOCK, velociraptors);
        this.addPaddock(aviary);
        this.addPaddock(cloudForest);
        this.addPaddock(lagoon);
        this.addPaddock(thunderValley);
        this.addPaddock(tRexPaddock);
        this.addPaddock(velociraptorPaddock);
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


    public void repairPaddock(Paddock paddock){
        paddock.setBoundaryHealth(100);
        this.revenue -= 50;
    }
}
