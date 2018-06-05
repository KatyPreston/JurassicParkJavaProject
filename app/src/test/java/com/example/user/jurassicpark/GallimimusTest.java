package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class GallimimusTest {
    Gallimimus gallimimus;

    @Before
    public void before(){
        gallimimus = new Gallimimus(FeedType.OMNIVORE, "Gallimimus", "Fergus", 5);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.OMNIVORE, gallimimus.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Gallimimus", gallimimus.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Fergus", gallimimus.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(5, gallimimus.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(20, gallimimus.getRampagePower());
    }

    @Test
    public void canEat(){
        gallimimus.eat();
        assertEquals(1, gallimimus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Gallimimus gallimimus2 = new Gallimimus(FeedType.OMNIVORE, "Gallimimus", "Eugene", 8);
        ArrayList<IWalk> dinosaurs = new ArrayList<>();
        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurs);

        assertEquals("Zip Smash", gallimimus2.rampage(cloudForest));
        assertEquals(80, cloudForest.getBoundaryHealth());
    }

    @Test
    public void willNotRampageUnlessHungry() {
        ArrayList<IWalk> dinosaurs = new ArrayList<>();
        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurs);

        assertEquals("Zoop", gallimimus.rampage(cloudForest));
        assertEquals(100, cloudForest.getBoundaryHealth());
    }
}
