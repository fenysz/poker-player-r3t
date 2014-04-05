/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

import org.leanpoker.player.Card;
import org.leanpoker.player.GameState;
import org.leanpoker.player.IGameState;
import org.leanpoker.player.folder.Folder;

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
        
        int raiseValue = 0;
        boolean fineHand = false;
        
        if(card1.getRank().equals(card2.getRank())) {
            fineHand = true ;
            if(isLetter(card1.getRank())){
                raiseValue += 2;
            } else {
                raiseValue +=1;
            }
        } 
        if(card1.getSuit().equals(card2.getSuit())
                &&
           (isLetter(card1.getRank()) || isLetter(card2.getRank()))
                ){
            fineHand = true ;
            raiseValue += 2;
        } 
        if(isLetter(card1.getRank()) && isLetter(card2.getRank())){
            fineHand = true ;
            raiseValue += 1;
        }
        if (Math.abs(card1.getIntRank() - card2.getIntRank()) == 1 || Math.abs(card1.getIntRank() - card2.getIntRank()) == 12) {
            fineHand = true;
            raiseValue = 0;
        }

        if(fineHand){
            return getRaiseValue(raiseValue);
        } else {
            Folder folder = new Folder(gameState);
            if(folder.isHaveToFold()){
                return 0;
            } else {
                return gameState.getCurrentByIn();
            }
        }
    }
    
    private int getRaiseValue(int multiplier){
        int raiseMoney = gameState.getMinimumRaise();
        return gameState.getCurrentByIn() + raiseMoney * multiplier;
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
