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

    public AfterFlopper(IGameState state) {
        this.gameState = state;
    }

    public int bet() {
        Card card1 = gameState.getCard1();
        Card card2 = gameState.getCard2();
        List<Card> cardList = new ArrayList<Card>();
        cardList.add(card1);
        cardList.add(card2);
        for (Card card : gameState.getCardsOnBoard()) {
            cardList.add(card);
        }
        RankingService rs = new RankingService();
        Ranking rank = rs.getRanking(cardList);
        if (rank != null) {
            if (rank.getRank()> Rank.PAIR.getValue()) {
                return gameState.getCurrentByIn() * rank.getRank();
            }
            return gameState.getCurrentByIn() + 30;
        }
        return gameState.getCurrentByIn();
    }
}
