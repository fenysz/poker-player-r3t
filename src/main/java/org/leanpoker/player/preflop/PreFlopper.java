/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

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
        if(gameState.getCard1().getRank().equals(gameState.getCard2().getRank())) {
               return gameState.getCurrentByIn() + 600;
        }
        return 0;
    }
}
