package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class BrachiosaurusTest {
    Brachiosaurus brachiosaurus;

    @Before
    public void before(){
        brachiosaurus = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "George", 1);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.HERBIVORE, brachiosaurus.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Brachiosaurus", brachiosaurus.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("George", brachiosaurus.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(1, brachiosaurus.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(70, brachiosaurus.getRampagePower());
    }

    @Test
    public void canEat(){
        brachiosaurus.eat();
        assertEquals(1, brachiosaurus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Brachiosaurus brachiosaurus2 = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "Sean", 6);
        assertEquals(true, brachiosaurus2.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry() {
        assertEquals(false, brachiosaurus.rampage());
    }
}
