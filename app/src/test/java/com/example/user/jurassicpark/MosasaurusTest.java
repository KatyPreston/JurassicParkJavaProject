package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Mosasaurus;

import org.junit.Before;
import org.junit.Test;

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
    public void canEat(){
        mosasaurus.eat();
        assertEquals(1, mosasaurus.getHungerLevel());
    }
}
