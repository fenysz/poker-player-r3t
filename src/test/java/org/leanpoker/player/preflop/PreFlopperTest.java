/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.leanpoker.player.Card;
import org.leanpoker.player.IGameState;

/**
 *
 * @author athalay
 */
public class PreFlopperTest {
    
    public PreFlopperTest() {
    }

    @Test
    public void testOneColor() {
        PreFlopper flopper = new PreFlopper(new TestGameState("diamonds","diamonds","4", "5", 100, 50 ));
        assertEquals(250, flopper.bet());
    }
    @Test
    public void testPair() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS","diamonds","4", "4", 100, 50 ));
        assertEquals(150, flopper.bet());
    }
    @Test
    public void testHigh() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS","diamonds","K", "A", 100, 50 ));
        assertEquals(150, flopper.bet());
    }
}