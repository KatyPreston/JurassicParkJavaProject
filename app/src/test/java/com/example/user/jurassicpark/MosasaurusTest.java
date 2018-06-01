package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Mosasaurus;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MosasaurusTest {
    Mosasaurus mosasaurus;

    @Before
    public void before(){
        mosasaurus = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Simon");
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
    public void canEat(){
        assertEquals("Mmmm", mosasaurus.eat());
    }
}
