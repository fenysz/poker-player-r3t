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
        assertEquals(300, flopper.bet());
    }
    @Test
    public void testPair() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS","diamonds","4", "4", 100, 50 ));
        assertEquals(600, flopper.bet());
    }
    @Test
    public void testHigh() {
        PreFlopper flopper = new PreFlopper(new TestGameState("HEARTS","diamonds","K", "A", 100, 50 ));
        assertEquals(200, flopper.bet());
    }
    
    public static class TestGameState implements IGameState {
        
        String card1Suite;
        String card2Suite;
        String card1Rank;
        String card2Rank;
        int minBet;
        int byIn;

        public TestGameState(String card1Suite, String card2Suite, String card1Rank, String card2Rank, int minBet, int byIn) {
            this.card1Suite = card1Suite;
            this.card2Suite = card2Suite;
            this.card1Rank = card1Rank;
            this.card2Rank = card2Rank;
            this.minBet = minBet;
            this.byIn = byIn;
        }
        
        
        @Override
        public Card getCard1() {
            return new Card(card1Rank, card1Suite);
        }

        @Override
        public Card getCard2() {
            return new Card(card2Rank, card2Suite);
        }

        @Override
        public int getCurrentByIn() {
            return byIn;
        }

        @Override
        public int getPlayerIndex() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public List<Card> getCardsOnBoard() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int getMinimumRaise() {
            return minBet;
        }
    
    }
}