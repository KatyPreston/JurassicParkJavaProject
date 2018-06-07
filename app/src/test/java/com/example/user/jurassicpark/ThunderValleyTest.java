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
import org.mockito.Mockito;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class ThunderValleyTest {
    ThunderValley thunderValley;
    Brachiosaurus brachiosaurus;
    ArrayList<IWalk> dinosaurList;

    @Before
    public void before(){
        brachiosaurus = new Brachiosaurus(FeedType.HERBIVORE, "Brachiosaurus", "Cecilia");
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
    public void canSetBoundaryHealth(){
        assertEquals(40, thunderValley.setBoundaryHealth(40));
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
    public void canFeedDinosaur(){
        assertEquals("Mmmm", thunderValley.feedDinosaur(brachiosaurus));
        assertEquals(1, brachiosaurus.getHungerLevel());
    }

    @Test
    public void dinosaurCanCauseDamage(){
        Brachiosaurus spyBrachiosaurus = Mockito.spy(brachiosaurus);

        Mockito.when(spyBrachiosaurus.getHungerLevel()).thenReturn(8);
        thunderValley.dinosaurHitBoundary(spyBrachiosaurus);
        assertEquals(30, thunderValley.getBoundaryHealth());
    }

    @Test
    public void boundaryHealthCannotGoBelowZero(){
        Brachiosaurus spyBrachiosaurus = Mockito.spy(brachiosaurus);

        Mockito.when(spyBrachiosaurus.getHungerLevel()).thenReturn(8);
        thunderValley.dinosaurHitBoundary(spyBrachiosaurus);
        thunderValley.dinosaurHitBoundary(spyBrachiosaurus);
        assertEquals(0, thunderValley.getBoundaryHealth());
    }

    @Test
    public void dinosaurCanEscape(){
        Brachiosaurus spyBrachiosaurus = Mockito.spy(brachiosaurus);

        Mockito.when(spyBrachiosaurus.getHungerLevel()).thenReturn(8);
        assertEquals("Run for your lives!!", thunderValley.dinosaurEscapes(spyBrachiosaurus));
        assertEquals(0, thunderValley.getBoundaryHealth());
    }

    @Test
    public void dinosaurCannotEscapeUnlessRampaging(){
        Brachiosaurus spyBrachiosaurus = Mockito.spy(brachiosaurus);

        Mockito.when(spyBrachiosaurus.getHungerLevel()).thenReturn(4);
        assertEquals("Run for your lives!!", thunderValley.dinosaurEscapes(spyBrachiosaurus));
        assertEquals(100, thunderValley.getBoundaryHealth());
    }


}
