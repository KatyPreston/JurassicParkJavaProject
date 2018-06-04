package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AnkylosaurusTest {
    Ankylosaurus ankylosaurus;

    @Before
    public void before(){
        ankylosaurus = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Stompy", 1);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.HERBIVORE, ankylosaurus.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Ankylosaurus", ankylosaurus.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Stompy", ankylosaurus.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(1, ankylosaurus.getHungerLevel());
    }

    @Test
    public void canEat(){
        ankylosaurus.eat();
        assertEquals(1, ankylosaurus.getHungerLevel());
    }
}
