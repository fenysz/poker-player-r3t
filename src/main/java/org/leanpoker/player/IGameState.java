/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import java.util.List;

/**
 *
 * @author athalay
 */
public interface IGameState {

    Card getCard1();

    Card getCard2();

    int getCurrentByIn();

    int getPlayerIndex();

    List<Card> getCardsOnBoard();

    int getMinimumRaise();

    int getStack();

    boolean isBlind();

    int getOrbits();

    int getCurrentRank();

    void setCurrentRank(int rank);
}
