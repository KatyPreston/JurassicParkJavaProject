package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.TRex;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TRexTest {
    TRex tRex;

    @Before
    public void before(){
        tRex = new TRex(FeedType.CARNIVORE, "TRex", "Grumpy");
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.CARNIVORE, tRex.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("TRex", tRex.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Grumpy", tRex.getName());
    }

    @Test
    public void canEat(){
        assertEquals("Mmmm", tRex.eat());
    }
}
