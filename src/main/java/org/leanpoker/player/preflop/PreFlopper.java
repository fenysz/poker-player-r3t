/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

import org.leanpoker.player.Card;
import org.leanpoker.player.GameState;
import org.leanpoker.player.IGameState;

/**
 *
 * @author athalay
 */
public class PreFlopper {
    private IGameState gameState;

    public PreFlopper(IGameState state) {
        this.gameState = state;
    }

    public int bet() {
        Card card1 = gameState.getCard1();
        Card card2 = gameState.getCard2();
        
        if(card1.getRank().equals(card2.getRank())) {
            return gameState.getMinimumRaise() * 6;
        } else if(card1.getSuit().equals(card2.getSuit())){
            return gameState.getMinimumRaise() * 3;
        } else if(isLetter(card1.getRank()) && isLetter(card2.getRank())){
            return gameState.getMinimumRaise() * 2;
        }
        return gameState.getCurrentByIn();
    }

    private boolean isLetter(String rank) {
        try {
            Integer.parseInt(rank);
        } catch(Exception e){
            return true;
        }
        return false;
    }
    
    
}
