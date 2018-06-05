package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Mosasaurus;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MosasaurusTest {
    Mosasaurus mosasaurus;

    @Before
    public void before(){
        mosasaurus = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Simon", 10);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.CARNIVORE, mosasaurus.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Mosasaurus", mosasaurus.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Simon", mosasaurus.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(10, mosasaurus.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(20, mosasaurus.getRampagePower());
    }

    @Test
    public void canEat(){
        mosasaurus.eat();
        assertEquals(1, mosasaurus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        ArrayList<ISwim> dinosaurs = new ArrayList<>();
        Lagoon lagoon= new Lagoon(PaddockType.LAGOON, dinosaurs);

        assertEquals("Blop Bubble Splash", mosasaurus.rampage(lagoon));
        assertEquals(80, lagoon.getBoundaryHealth());

    }
}
