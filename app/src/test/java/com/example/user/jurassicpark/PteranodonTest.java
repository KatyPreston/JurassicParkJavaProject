package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.Dinosaur;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PteranodonTest {
    Pteranodon pteranodon;

    @Before
    public void before(){
        pteranodon = new Pteranodon(FeedType.HERBIVORE, "Pteranodon", "Elvis");
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.HERBIVORE, pteranodon.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Pteranodon", pteranodon.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Elvis", pteranodon.getName());
    }

    @Test
    public void canEat(){
        assertEquals("Mmmm", pteranodon.eat());
    }
}
