package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IFly;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Paddocks.Aviary;
import com.example.user.jurassicpark.Paddocks.Paddock;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Park.Park;
import com.example.user.jurassicpark.Visitors.Visitor;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ParkTest {
    Park park;
    Visitor visitor;
    ArrayList<Paddock> paddocks;
    ArrayList<Visitor> visitors;
    ArrayList<IFly> dinosaurs;
    Aviary aviary;

    @Before
    public void before(){
        dinosaurs = new ArrayList<>();
        aviary = new Aviary(PaddockType.AVIARY, dinosaurs);
        paddocks = new ArrayList<>();
        visitors = new ArrayList<>();
        park = new Park(paddocks, visitors, 0, 20);
    }

    @Test
    public void canGetTotalRevenue(){
        assertEquals(0, park.totalRevenue(), 0.1);
    }

    @Test
    public void canGetVisitorCapacity(){
        assertEquals(20, park.getVisitorCapacity());
    }

    @Test
    public void canAddVisitor(){
        park.addVisitor(visitor);
        assertEquals(1, park.visitorCount());
    }

    @Test
    public void cannotAddOverVisitorCapacity(){
        Park park2 = new Park(paddocks, visitors, 0, 3);
        park2.addVisitor(visitor);
        park2.addVisitor(visitor);
        park2.addVisitor(visitor);
        park2.addVisitor(visitor);

        assertEquals(3, park2.visitorCount());
    }

    @Test
    public void canRemoveVisitor(){
        park.addVisitor(visitor);
        park.removeVisitor(visitor);
        assertEquals(0, park.visitorCount());
    }

    @Test
    public void canCountVisitors(){
        assertEquals(0, park.visitorCount());

    }

    @Test
    public void canAddPaddock(){
        park.addPaddock(aviary);
        assertEquals(7, park.paddockCount());
    }

    @Test
    public void canRemovePaddock(){
        park.addPaddock(aviary);
        park.removePaddock(aviary);
        assertEquals(6, park.paddockCount());
    }

    @Test
    public void canCountPaddocks(){
        assertEquals(6, park.paddockCount());
    }

    @Test
    public void canChargeEntry(){
        visitor = new Visitor("Ted", 100);

        park.chargeEntry(visitor);
        assertEquals(50, park.totalRevenue(), 0.1);
        assertEquals(50, visitor.getWallet(), 0.1);
        assertEquals(1, park.visitorCount());
    }

    @Test
    public void canRepairPaddockBoundary(){
        TRex tRex = new TRex(FeedType.CARNIVORE, "TRex", "Sly");
        TRex spyTRex = Mockito.spy(tRex);

        Mockito.when(spyTRex.getHungerLevel()).thenReturn(8);
        aviary.dinosaurHitBoundary(spyTRex);
        assertEquals(40, aviary.getBoundaryHealth());
        park.repairPaddock(aviary);
        assertEquals(100, aviary.getBoundaryHealth());
        assertEquals(-50, park.totalRevenue(), 0.1);
    }

}
