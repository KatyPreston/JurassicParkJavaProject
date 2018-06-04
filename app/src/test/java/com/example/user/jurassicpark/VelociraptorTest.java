package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Velociraptor;

import org.junit.Before;
import org.junit.Test;

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
    public void canEat(){
        velociraptor.eat();
        assertEquals(1, velociraptor.getHungerLevel());
    }

}
