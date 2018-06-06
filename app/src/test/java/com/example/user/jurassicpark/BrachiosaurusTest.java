package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

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
    public void canGetRampagePower(){
        assertEquals(70, brachiosaurus.getRampagePower());
    }

    @Test
    public void canGetHungerLevel(){
        Brachiosaurus brachiosaurus1 = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "John");
        Brachiosaurus spyBrachiosaurus = Mockito.spy(brachiosaurus1);

        Mockito.when(spyBrachiosaurus.getHungerLevel()).thenReturn(8);
        assertEquals(8, spyBrachiosaurus.getHungerLevel());
    }


    @Test
    public void canEat(){
        brachiosaurus.eat();
        assertEquals(1, brachiosaurus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Brachiosaurus brachiosaurus1 = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "John");
        Brachiosaurus spyBrachiosaurus = Mockito.spy(brachiosaurus1);


        Mockito.when(spyBrachiosaurus.rampage()).thenReturn(true);
        assertEquals(true, spyBrachiosaurus.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        Brachiosaurus brachiosaurus1 = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "John");
        Brachiosaurus spyBrachiosaurus = Mockito.spy(brachiosaurus1);


        Mockito.when(spyBrachiosaurus.rampage()).thenReturn(false);
        assertEquals(false, spyBrachiosaurus.rampage());
    }

}
