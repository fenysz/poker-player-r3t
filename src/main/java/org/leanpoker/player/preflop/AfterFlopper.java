/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

import org.leanpoker.player.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author athalay
 */
public class AfterFlopper {
    private IGameState gameState;
    List<Card> cardList;

    public AfterFlopper(IGameState state) {
        this.gameState = state;
        Card card1 = gameState.getCard1();
        Card card2 = gameState.getCard2();
        cardList = new ArrayList<Card>();
        cardList.add(card1);
        cardList.add(card2);
        for (Card card : gameState.getCardsOnBoard()) {
            cardList.add(card);
        }
    }

    public int bet() {
        Ranking rank = RankingService.getRanking(cardList);
        if (rank != null) {
            if (rank.getRank() >= Rank.FLUSH.getValue()) {
                return gameState.getStack();
            }
            if (rank.getRank() >= Rank.PAIR.getValue()) {
                return gameState.getMinimumRaise() * rank.getRank();
            }
        }
        return 0;
    }
}
