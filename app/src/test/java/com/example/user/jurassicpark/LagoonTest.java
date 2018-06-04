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
        mosasaurus = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Simon");
        dinosaurList = new ArrayList<>();
        dinosaurList.add(mosasaurus);

        lagoon = new Lagoon(PaddockType.LAGOON, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.LAGOON, lagoon.getType());
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

}
