/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.google.gson.JsonElement;

/**
 *
 * @author athalay
 */
public class GameState {

    GameState(JsonElement element) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public CardRound getCardRound(){
        return CardRound.FLOP;
    }
}
