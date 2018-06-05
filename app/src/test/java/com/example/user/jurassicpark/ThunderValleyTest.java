package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Brachiosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.TRex;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.ThunderValley;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThunderValleyTest {
    ThunderValley thunderValley;
    Brachiosaurus brachiosaurus;
    ArrayList<IWalk> dinosaurList;

    @Before
    public void before(){
        brachiosaurus = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "Cecilia", 7);
        dinosaurList = new ArrayList<>();
        dinosaurList.add(brachiosaurus);

        thunderValley = new ThunderValley(PaddockType.THUNDERVALLEY, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.THUNDERVALLEY, thunderValley.getType());
    }

    @Test
    public void canGetBoundaryHealth(){
        assertEquals(100, thunderValley.getBoundaryHealth());
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, thunderValley.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        thunderValley.addDinosaur(brachiosaurus);
        assertEquals(2, thunderValley.dinosaurCount());
    }

    @Test
    public void canRemoveDinosaur(){
        thunderValley.removeDinosaur(brachiosaurus);
        assertEquals(0, thunderValley.dinosaurCount());
    }

    @Test
    public void canTransferHerbivore(){
        ArrayList<IWalk> dinosaurlist2 = new ArrayList<>();
        CloudForest  cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurlist2);
        thunderValley.transferHerbivore(brachiosaurus, cloudForest);

        assertEquals(1, cloudForest.dinosaurCount());
        assertEquals(0, thunderValley.dinosaurCount());
    }

    @Test
    public void cannotTransferCarnivore(){
        ArrayList<IWalk> dinosaurlist2 = new ArrayList<>();
        CloudForest  cloudForest = new CloudForest(PaddockType.CLOUDFOREST, dinosaurlist2);
        TRex tRex = new TRex(FeedType.CARNIVORE, "Trex", "Mr Claws", 7);

        thunderValley.transferHerbivore(tRex, cloudForest);
        assertEquals(1, thunderValley.dinosaurCount());
        assertEquals(0, cloudForest.dinosaurCount());
    }

    @Test
    public void canFeedDinosaur(){
        assertEquals("Mmmm", thunderValley.feedDinosaur(brachiosaurus));
        assertEquals(1, brachiosaurus.getHungerLevel());
    }

    @Test
    public void dinosaurCanRampage(){
        thunderValley.dinosaurHitBoundary(brachiosaurus);
        assertEquals(30, thunderValley.getBoundaryHealth());
    }

    @Test
    public void dinosaurCanEscape(){
        assertEquals("Run for your lives!!", thunderValley.dinosaurEscapes(brachiosaurus));
        assertEquals(0, thunderValley.getBoundaryHealth());
    }

    @Test
    public void dinosaurCannotEscapeUnlessRampaging(){
        Brachiosaurus brachiosaurus2 = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "Stella", 1);
        thunderValley.dinosaurEscapes(brachiosaurus2);
        assertEquals(100, thunderValley.getBoundaryHealth());
    }



}
