package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AnkylosaurusTest {
    Ankylosaurus ankylosaurus;

    @Before
    public void before(){
        ankylosaurus = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Stompy", 1);
    }

    @Test
    public void canGetFeedType(){
        assertEquals(FeedType.HERBIVORE, ankylosaurus.getFeedType());
    }

    @Test
    public void canGeType(){
        assertEquals("Ankylosaurus", ankylosaurus.getType());
    }

    @Test
    public void canGetName(){
        assertEquals("Stompy", ankylosaurus.getName());
    }

    @Test
    public void canGetHungerLevel(){
        assertEquals(1, ankylosaurus.getHungerLevel());
    }

    @Test
    public void hungerLevelCannotBeLessThanZero(){
        Ankylosaurus ankylosaurus2 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Debby", -2);
        assertEquals(0, ankylosaurus2.getHungerLevel());
    }

    @Test
    public void canGetRampagePower(){
        assertEquals(40, ankylosaurus.getRampagePower());
    }

    @Test
    public void canEat(){
        ankylosaurus.eat();
        assertEquals(1, ankylosaurus.getHungerLevel());
    }

    @Test
    public void canRampage(){
        Ankylosaurus ankylosaurus2 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Russel", 7);
        ArrayList<IWalk> dinosaurs = new ArrayList<>();
        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurs);

        assertEquals(true, ankylosaurus2.rampage(cloudForest));

    }

    @Test
    public void willNotRampageUnlessHungry(){
        ArrayList<IWalk> dinosaurs = new ArrayList<>();
        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurs);

        assertEquals(false, ankylosaurus.rampage(cloudForest));
    }

//    @Test
//    public void dinosaurCanEscapeAfterRampage(){
//        ArrayList<IWalk> dinosaurs = new ArrayList<>();
//        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurs);
//        Ankylosaurus ankylosaurus2 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Lucy", 8);
//
//        assertEquals("Run for your lives!!", ankylosaurus2.escape(cloudForest));
//        assertEquals(0, cloudForest.getBoundaryHealth());
//    }

//    @Test
//    public void dinosaurWillNotAttemptEscapeIfNotHungry(){
//        ArrayList<IWalk> dinosaurs = new ArrayList<>();
//        CloudForest cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurs);
//
//        ankylosaurus.escape(cloudForest);
//        assertEquals(100, cloudForest.getBoundaryHealth());
//    }
}
