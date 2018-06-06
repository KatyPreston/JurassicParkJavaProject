package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;
import com.example.user.jurassicpark.Dinosaurs.Mosasaurus;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

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
    public void canGetRampagePower(){
        assertEquals(20, mosasaurus.getRampagePower());
    }

    @Test
    public void canGetHungerLevel(){
        Mosasaurus mosasaurus1 = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Gerald");
        Mosasaurus spyMosasaurus = Mockito.spy(mosasaurus1);

        Mockito.when(spyMosasaurus.getHungerLevel()).thenReturn(8);
        assertEquals(8, spyMosasaurus.getHungerLevel());
    }

    @Test
    public void canEat(){
        mosasaurus.eat();
        assertEquals(1, mosasaurus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Mosasaurus mosasaurus1 = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Gerald");
        Mosasaurus spyMosasaurus = Mockito.spy(mosasaurus1);

        Mockito.when(spyMosasaurus.rampage()).thenReturn(true);
        assertEquals(true, spyMosasaurus.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        Mosasaurus mosasaurus1 = new Mosasaurus(FeedType.CARNIVORE, "Mosasaurus", "Gerald");
        Mosasaurus spyMosasaurus = Mockito.spy(mosasaurus1);

        Mockito.when(spyMosasaurus.rampage()).thenReturn(false);
        assertEquals(false, spyMosasaurus.rampage());
    }

}
