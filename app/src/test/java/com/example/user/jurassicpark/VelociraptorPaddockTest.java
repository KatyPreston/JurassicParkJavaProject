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
        velociraptor = new Velociraptor(FeedType.CARNIVORE, "Velociraptor", "Pinky");
        dinosaurList = new ArrayList<>();
        dinosaurList.add(velociraptor);

        velociraptorPaddock = new VelociraptorPaddock(PaddockType.VELOCIRAPTOR_PADDOCK, dinosaurList);
    }

    @Test
    public void canGetType(){
        assertEquals(PaddockType.VELOCIRAPTOR_PADDOCK, velociraptorPaddock.getType());
    }

    @Test
    public void canCountDinosaurs(){
        assertEquals(1, velociraptorPaddock.dinosaurCount());
    }
}