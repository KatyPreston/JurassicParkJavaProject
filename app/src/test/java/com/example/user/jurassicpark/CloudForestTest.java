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
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class CloudForestTest {
    CloudForest cloudForest;
    Ankylosaurus ankylosaurus;
    Gallimimus gallimimus;
    ArrayList<IWalk> dinosaurList;

    @Before
    public void before(){
        ankylosaurus = new Ankylosaurus(FeedType.HERBIVORE, "Ankylosaurus", "Wilma");
        gallimimus = new Gallimimus(FeedType.OMNIVORE, "Gallimimus", "Sid");
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
    public void canSetBoundaryHealth(){
        assertEquals(40, cloudForest.setBoundaryHealth(40));
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
    public void canFeedDinosaur(){
        assertEquals("Mmmm", cloudForest.feedDinosaur(gallimimus));
        assertEquals(1, gallimimus.getHungerLevel());
    }

    @Test
    public void dinosaurCanCauseDamage(){
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);

        Mockito.when(spyAnkylosaurus.getHungerLevel()).thenReturn(8);
        cloudForest.dinosaurHitBoundary(spyAnkylosaurus);
        assertEquals(60, cloudForest.getBoundaryHealth());
    }

    @Test
    public void boundaryHealthCannotGoBelowZero(){
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);

        Mockito.when(spyAnkylosaurus.getHungerLevel()).thenReturn(8);
        cloudForest.dinosaurHitBoundary(spyAnkylosaurus);
        cloudForest.dinosaurHitBoundary(spyAnkylosaurus);
        cloudForest.dinosaurHitBoundary(spyAnkylosaurus);

        assertEquals(0, cloudForest.getBoundaryHealth());
    }

    @Test
    public void dinosaurCanEscape(){
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);

        Mockito.when(spyAnkylosaurus.getHungerLevel()).thenReturn(8);
        assertEquals("Run for your lives!!", cloudForest.dinosaurEscapes(spyAnkylosaurus));
        assertEquals(0, cloudForest.getBoundaryHealth());
    }


    @Test
    public void dinosaurCannotEscapeUnlessRampaging(){
        Ankylosaurus spyAnkylosaurus = Mockito.spy(ankylosaurus);

        Mockito.when(spyAnkylosaurus.getHungerLevel()).thenReturn(5);
        assertEquals("Run for your lives!!", cloudForest.dinosaurEscapes(spyAnkylosaurus));
        assertEquals(100, cloudForest.getBoundaryHealth());
    }



}
