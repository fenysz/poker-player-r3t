/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

import org.junit.Test;
import org.leanpoker.player.Player;

import static org.junit.Assert.assertEquals;

/**
 * @author athalay
 */
public class PreFlopperTest {

    public PreFlopperTest() {
    }

    @Test
    public void testOneHigh() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS", "diamonds", "8", "K", 10, 0));
        assertEquals(0, flopper.bet());
    }

    @Test
    public void testOneColor() {
        PreFlopper flopper = new PreFlopper(new TestGameState("diamonds", "diamonds", "2", "5", 100, 50));
        assertEquals(0, flopper.bet());
    }

    @Test
    public void testPair() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS", "diamonds", "4", "4", 100, 50));
        assertEquals(150, flopper.bet());
    }

    @Test
    public void testHigh() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS", "diamonds", "Q", "A", 100, 50));
        assertEquals(150, flopper.bet());
    }

    @Test
    public void testHighAndStraightSuspicion() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS", "diamonds", "K", "A", 100, 50));
        assertEquals(250, flopper.bet());
    }
}