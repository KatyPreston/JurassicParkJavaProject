package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Mosasaurus;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class LagoonTest {
    Lagoon lagoon;
    Mosasaurus mosasaurus;
    ArrayList<ISwim> dinosaurList;

    @Before
    public void before(){
        mosasaurus = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Simon", 2);
        dinosaurList = new ArrayList<>();
        dinosaurList.add(mosasaurus);

        lagoon = new Lagoon(PaddockType.LAGOON, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.LAGOON, lagoon.getType());
    }

    @Test
    public void canGetBoundaryHealth(){
        assertEquals(100, lagoon.getBoundaryHealth());
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, lagoon.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        lagoon.addDinosaur(mosasaurus);
        assertEquals(2, lagoon.dinosaurCount());
    }

    @Test
    public void canRemoveDinosaur(){
        lagoon.removeDinosaur(mosasaurus);
        assertEquals(0, lagoon.dinosaurCount());
    }

    @Test
    public void canFeedDinosaur(){
        assertEquals("Mmmm", lagoon.feedDinosaur(mosasaurus));
        assertEquals(1, mosasaurus.getHungerLevel());
    }

    @Test
    public void dinosaurCanRampage(){
        lagoon.dinosaurRampage(mosasaurus);
        assertEquals(80, lagoon.getBoundaryHealth());
    }

}
