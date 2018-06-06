package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.ISwim;
import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Pteranodon;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Dinosaurs.Velociraptor;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.Lagoon;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.TRexPaddock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

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
    public void canGetRampagePower(){
        assertEquals(60, tRex.getRampagePower());
    }

    @Test
    public void canGetHungerLevel(){
        TRex tRex1 = new TRex(FeedType.CARNIVORE, "TRex", "Ned");
        TRex spyTRex = Mockito.spy(tRex1);

        Mockito.when(spyTRex.getHungerLevel()).thenReturn(8);
        assertEquals(8, spyTRex.getHungerLevel());
    }

    @Test
    public void canEat(){
        tRex.eat();
        assertEquals(1, tRex.getHungerLevel());
    }

    @Test
    public void canRampage(){
        TRex tRex1 = new TRex(FeedType.CARNIVORE, "TRex", "Ned");
        TRex spyTRex = Mockito.spy(tRex1);

        Mockito.when(spyTRex.rampage()).thenReturn(true);
        assertEquals(true, spyTRex.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        TRex tRex1 = new TRex(FeedType.CARNIVORE, "TRex", "Ned");
        TRex spyTRex = Mockito.spy(tRex1);

        Mockito.when(spyTRex.rampage()).thenReturn(false);
        assertEquals(false, spyTRex.rampage());
    }



}
