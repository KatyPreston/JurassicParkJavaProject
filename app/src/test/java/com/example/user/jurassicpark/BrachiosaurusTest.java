package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrachiosaurusTest {
    Brachiosaurus brachiosaurus;

    @Before
    public void before(){
        brachiosaurus = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "George");
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
    public void canEat(){
        assertEquals("Mmmm", brachiosaurus.eat());
    }
}
