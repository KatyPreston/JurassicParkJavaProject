package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;

import org.junit.Before;
import org.junit.Test;

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
    public void canGeType(){
        assertEquals("Gallimimus", gallimimus.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Fergus", gallimimus.getName());
    }

    @Test
    public void canEat(){
        assertEquals("Mmmm", gallimimus.eat());
    }
}
