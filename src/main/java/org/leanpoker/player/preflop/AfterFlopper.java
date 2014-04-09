/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player.preflop;

import org.leanpoker.player.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
        cardList.addAll(gameState.getCardsOnBoard());
    }

    public int bet() {
        Ranking rank = RankingService.getRanking(cardList);
        if (rank != null) {
            if (rank.getRank() >= Rank.FLUSH.getValue()) {
                return gameState.getStack();
            }
            Map<String, Integer> map = new HashMap<>();
            for (Card card : cardList) {
                Integer colorCounter = map.get(card.getSuit());
                if (colorCounter == null) {
                    colorCounter = 1;
                    map.put(card.getSuit(), colorCounter);
                } else {
                    colorCounter++;
                    map.put(card.getSuit(), colorCounter);
                }
            }
            if (gameState.getCardsOnBoard().size() < 5) {
                for (Map.Entry<String, Integer> entry : map.entrySet()) {
                    Integer number = entry.getValue();
                    if (number >= 4) {
                        return gameState.getCurrentByIn() + gameState.getMinimumRaise() * 2;
                    }
                }
            }
            if (rank.getRank() >= Rank.PAIR.getValue()) {
                return gameState.getCurrentByIn() + gameState.getMinimumRaise() * rank.getRank();
            }
        }
        return 0;
    }
}
