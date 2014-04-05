/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

import java.util.List;
import org.leanpoker.player.Card;
import org.leanpoker.player.IGameState;

/**
 *
 * @author athalay
 */
public class TestGameState implements IGameState {
    String card1Suite;
    String card2Suite;
    String card1Rank;
    String card2Rank;
    int minBet;
    int byIn;
    int love;

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

    @Override
    public int getStack() {
        return 1000;
    }

    @Override
    public boolean isBlind() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
