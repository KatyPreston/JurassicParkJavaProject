package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Dinosaurs.Velociraptor;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.VelociraptorPaddock;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {
    Velociraptor velociraptor;

    @Before
    public void before(){
        velociraptor = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Blue");
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.CARNIVORE, velociraptor.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Velociraptor", velociraptor.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Blue", velociraptor.getName());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(30, velociraptor.getRampagePower());
    }

    @Test
    public void canGetHungerLevel(){
        Velociraptor velociraptor1 = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Purple");
        Velociraptor spyVelociraptor = Mockito.spy(velociraptor1);

        Mockito.when(spyVelociraptor.getHungerLevel()).thenReturn(8);
        assertEquals(8, spyVelociraptor.getHungerLevel());
    }

    @Test
    public void canEat(){
        velociraptor.eat();
        assertEquals(1, velociraptor.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Velociraptor velociraptor1 = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Purple");
        Velociraptor spyVelociraptor = Mockito.spy(velociraptor1);

        Mockito.when(spyVelociraptor.rampage()).thenReturn(true);
        assertEquals(true, spyVelociraptor.rampage());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        Velociraptor velociraptor1 = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Purple");
        Velociraptor spyVelociraptor = Mockito.spy(velociraptor1);

        Mockito.when(spyVelociraptor.rampage()).thenReturn(false);
        assertEquals(false, spyVelociraptor.rampage());
    }

}
