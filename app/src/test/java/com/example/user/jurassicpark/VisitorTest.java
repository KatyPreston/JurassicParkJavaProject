package com.example.user.jurassicpark;

import com.example.user.jurassicpark.Visitors.Visitor;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VisitorTest {
    Visitor visitor;

    @Before
    public void before(){
        visitor = new Visitor("Janet", 100);
    }

    @Test
    public void canGetName(){
        assertEquals("Janet", visitor.getName());
    }

    @Test
    public void canGetWallet(){
        assertEquals(100, visitor.getWallet(), 0.1);
    }

    @Test
    public void canPayEntry(){
        visitor.payEntry(50);
        assertEquals(50, visitor.getWallet(), 0.1);
    }
}
