package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Velociraptor;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.VelociraptorPaddock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {
    Velociraptor velociraptor;

    @Before
    public void before(){
        velociraptor = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Blue", 2);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.CARNIVORE, velociraptor.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Velociraptor", velociraptor.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Blue", velociraptor.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(2, velociraptor.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(30, velociraptor.getRampagePower());
    }

    @Test
    public void canEat(){
        velociraptor.eat();
        assertEquals(1, velociraptor.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Velociraptor velociraptor2 = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Red", 10);
        assertEquals(true, velociraptor2.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        assertEquals(false, velociraptor.rampage());
    }

}
