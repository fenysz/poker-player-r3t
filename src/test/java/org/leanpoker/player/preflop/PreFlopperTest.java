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
    public void testSomeMethod() {
        PreFlopper flopper = new PreFlopper(new TestGameState());
        assertEquals(300, flopper.bet());
    }
    
    public static class TestGameState implements IGameState {

        @Override
        public Card getCard1() {
            return new Card("3", "diamonds");
        }

        @Override
        public Card getCard2() {
            return new Card("4", "diamonds");
        }

        @Override
        public int getCurrentByIn() {
            return 0;
        }

        @Override
        public int getPlayerIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Card> getCardsOnBoard() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    }
}