/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.folder;

import org.leanpoker.player.IGameState;

/**
 *
 * @author athalay
 */
public class Folder {
    
    private IGameState gameState;

    public Folder(IGameState gameState) {
        this.gameState = gameState;
    }
    
    public boolean isHaveToFold(){
        String cards = gameState.getCard1().getRank() + gameState.getCard2().getRank();
        
        if(cards.contains("A") && cards.contains("K")){
            return false;
        } else {
            return true;
        }
        
    }
    
}
