package com.example.user.jurassicpark;

import com.example.user.jurassicpark.DinosaurBehaviour.IWalk;
import com.example.user.jurassicpark.Dinosaurs.Ankylosaurus;
import com.example.user.jurassicpark.Dinosaurs.FeedType;
import com.example.user.jurassicpark.Dinosaurs.Gallimimus;
import com.example.user.jurassicpark.Paddocks.CloudForest;
import com.example.user.jurassicpark.Paddocks.PaddockType;

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
    public void canCountDinosaurs(){
        assertEquals(2, cloudForest.dinosaurCount());
    }
}
