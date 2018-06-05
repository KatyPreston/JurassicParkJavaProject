package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.ThunderValley;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CloudForestTest {
    CloudForest cloudForest;
    Ankylosaurus ankylosaurus;
    Gallimimus gallimimus;
    ArrayList<IWalk> dinosaurList;

    @Before
    public void before(){
        ankylosaurus = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Wilma", 4);
        gallimimus = new Gallimimus(FeedType.OMNIVORE, "Gallimimus", "Sid", 6);
        dinosaurList = new ArrayList<>();
        dinosaurList.add(ankylosaurus);
        dinosaurList.add(gallimimus);

        cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.CLOUDFOREST, cloudForest.getType());
    }

    @Test
    public void canGetBoundaryHealth(){
        assertEquals(100, cloudForest.getBoundaryHealth());
    }

    @Test
    public void boundaryHealthCannotGoBelowZero(){
        Ankylosaurus ankylosaurus2 = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Monty", 8);
        ankylosaurus2.rampage(cloudForest);
        ankylosaurus2.rampage(cloudForest);
        ankylosaurus2.rampage(cloudForest);
        assertEquals(0, cloudForest.getBoundaryHealth());
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(2, cloudForest.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        cloudForest.addDinosaur(ankylosaurus);
        assertEquals(3, cloudForest.dinosaurCount());
    }

    @Test
    public void canRemoveDinosaur(){
        cloudForest.removeDinosaur(gallimimus);
        assertEquals(1, cloudForest.dinosaurCount());
    }

    @Test
    public void canTransferHerbivore(){
        ArrayList<IWalk> dinosaurlist2 = new ArrayList<>();
        ThunderValley thunderValley = new ThunderValley(PaddockType.THUNDERVALLEY, dinosaurlist2);
        cloudForest.transferHerbivore(ankylosaurus, thunderValley);

        assertEquals(1, thunderValley.dinosaurCount());
        assertEquals(1, cloudForest.dinosaurCount());
    }

    @Test
    public void cannotTransferCarnivore(){
        ArrayList<IWalk> dinosaurlist2 = new ArrayList<>();
        ThunderValley  thunderValley = new ThunderValley(PaddockType.THUNDERVALLEY, dinosaurlist2);
        TRex tRex = new TRex(FeedType.CARNIVORE, "Trex", "Mr Claws", 5);

        cloudForest.transferHerbivore(tRex, thunderValley);
        assertEquals(2, cloudForest.dinosaurCount());
        assertEquals(0, thunderValley.dinosaurCount());
    }

    @Test
    public void canFeedDinosaur(){
        assertEquals("Mmmm", cloudForest.feedDinosaur(gallimimus));
        assertEquals(1, gallimimus.getHungerLevel());
    }

    @Test
    public void dinosaurCanRampage(){
        cloudForest.dinosaurRampage(ankylosaurus);
        assertEquals(60, cloudForest.getBoundaryHealth());
    }

}
