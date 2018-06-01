package com.example.user.jurassicpark;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DinosaurTest {
    Dinosaur dinosaur;

    @Before
    public void before(){
        dinosaur = new Dinosaur(FeedType.HERBIVORE, "Iguanodon", "Elvis");
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.HERBIVORE, dinosaur.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Iguanodon", dinosaur.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Elvis", dinosaur.getName());
    }
}
