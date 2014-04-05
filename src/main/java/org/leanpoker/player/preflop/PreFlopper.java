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
            return gameState.getCurrentByIn() + 600;
        } else if(card1.getSuit().equals(card2.getSuit())){
            return gameState.getCurrentByIn() + 300;
        }
        return gameState.getCurrentByIn();
    }
}
