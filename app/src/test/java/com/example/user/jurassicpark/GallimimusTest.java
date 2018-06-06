package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GallimimusTest {
    Gallimimus gallimimus;

    @Before
    public void before(){
        gallimimus = new Gallimimus(FeedType.OMNIVORE, "Gallimimus", "Fergus");
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.OMNIVORE, gallimimus.getFeedType());
    }

    @Test
    public void canGetType(){
        assertEquals("Gallimimus", gallimimus.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Fergus", gallimimus.getName());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(20, gallimimus.getRampagePower());
    }

    @Test
    public void canEat(){
        gallimimus.eat();
        assertEquals(1, gallimimus.getHungerLevel());
    }

}
