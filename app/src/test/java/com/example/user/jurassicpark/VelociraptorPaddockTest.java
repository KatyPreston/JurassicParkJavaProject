package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Velociraptor;
import com.example.user.jurassicpark.Paddocks.PaddockType;
import com.example.user.jurassicpark.Paddocks.VelociraptorPaddock;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class VelociraptorPaddockTest {
    VelociraptorPaddock velociraptorPaddock;
    Velociraptor velociraptor;
    ArrayList<Velociraptor> dinosaurList;

    @Before
    public void before(){
        velociraptor = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Pinky", 4);
        dinosaurList = new ArrayList<>();
        dinosaurList.add(velociraptor);

        velociraptorPaddock = new VelociraptorPaddock(PaddockType.VELOCIRAPTOR_PADDOCK, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.VELOCIRAPTOR_PADDOCK, velociraptorPaddock.getType());
    }

    @Test
    public void canGetBoundaryHealth(){
        assertEquals(100, velociraptorPaddock.getBoundaryHealth());
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, velociraptorPaddock.dinosaurCount());
    }

    @Test
    public void canAddDinosaur(){
        velociraptorPaddock.addDinosaur(velociraptor);
        assertEquals(2, velociraptorPaddock.dinosaurCount());
    }

    @Test
    public void canRemoveDinosaur(){
        velociraptorPaddock.removeDinosaur(velociraptor);
        assertEquals(0, velociraptorPaddock.dinosaurCount());
    }

    @Test
    public void canFeedDinosaur(){
        assertEquals("Mmmm", velociraptorPaddock.feedDinosaur(velociraptor));
        assertEquals(1, velociraptor.getHungerLevel());
    }

    @Test
    public void dinosaurCanRampage(){
        velociraptorPaddock.dinosaurRampage(velociraptor);
        assertEquals(70, velociraptorPaddock.getBoundaryHealth());
    }
}
