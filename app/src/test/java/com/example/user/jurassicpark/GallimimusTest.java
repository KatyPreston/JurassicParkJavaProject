package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;
import com.example.user.jurassicpark.Dinosaurs.Mosasaurus;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

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
    public void canGetHungerLevel(){
        Gallimimus gallimimus1 = new Gallimimus(FeedType.OMNIVORE, "Gallimimus", "Max");
        Gallimimus spyGallimimus = Mockito.spy(gallimimus1);

        Mockito.when(spyGallimimus.getHungerLevel()).thenReturn(8);
        assertEquals(8, spyGallimimus.getHungerLevel());
    }

    @Test
    public void canEat(){
        gallimimus.eat();
        assertEquals(1, gallimimus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Gallimimus spyGallimimus = Mockito.spy(gallimimus);

        Mockito.when(spyGallimimus.getHungerLevel()).thenReturn(6);
        assertEquals(true, spyGallimimus.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        Gallimimus spyGallimimus = Mockito.spy(gallimimus);

        Mockito.when(spyGallimimus.getHungerLevel()).thenReturn(1);
        assertEquals(false, spyGallimimus.rampage());
    }


}
