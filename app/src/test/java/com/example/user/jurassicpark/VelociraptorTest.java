package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Dinosaurs.Velociraptor;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.TRexPaddock;
import com.example.user.jurassicpark.Paddocks.VelociraptorPaddock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VelociraptorTest {
    Velociraptor velociraptor;

    @Before
    public void before(){
        velociraptor = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Blue", 2);
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
    public void canGetHungerLevel(){
        assertEquals(2, velociraptor.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(30, velociraptor.getRampagePower());
    }

    @Test
    public void canEat(){
        velociraptor.eat();
        assertEquals(1, velociraptor.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Velociraptor velociraptor2 = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Red", 10);
        ArrayList<Velociraptor> dinosaurs = new ArrayList<>();
        VelociraptorPaddock velociraptorPaddock= new VelociraptorPaddock(PaddockType.VELOCIRAPTOR_PADDOCK, dinosaurs);

        assertEquals("Squawk Grrr", velociraptor2.rampage(velociraptorPaddock));
        assertEquals(70, velociraptorPaddock.getBoundaryHealth());
    }

    @Test
    public void willNotRampageUnlessHungry(){
        ArrayList<IWalk> dinosaurs = new ArrayList<>();
        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurs);

        assertEquals("Snort", velociraptor.rampage(cloudForest));
        assertEquals(100, cloudForest.getBoundaryHealth());
    }

}
