/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.List;

/**
 * @author athalay
 */
public class GameState implements IGameState {

    Card card1;
    Card card2;

    int currentByIn;
    int playerIndex;

    int minimumRaise;
    int stack;

    boolean isBlind;

    List<Card> communityCards;
    private int orbits;

    int currentRank;

    GameState(JsonElement element) {
        playerIndex = getState(element).get("in_action").getAsInt();
        orbits = getState(element).get("orbits").getAsInt();
        System.out.println("orbit: " + orbits);
        JsonObject player = getState(element).getAsJsonArray("players").get(playerIndex).getAsJsonObject();
        JsonObject jsonCard1 = player.getAsJsonArray("hole_cards").get(0).getAsJsonObject();
        JsonObject jsonCard2 = player.getAsJsonArray("hole_cards").get(1).getAsJsonObject();

        stack = player.get("stack").getAsInt();
        minimumRaise = getState(element).get("minimum_raise").getAsInt();

        currentByIn = element.getAsJsonObject().get("current_buy_in").getAsInt();
        String rank1 = jsonCard1.get("rank").getAsString();
        String rank2 = jsonCard2.get("rank").getAsString();

        String suit1 = jsonCard1.get("suit").getAsString();
        String suit2 = jsonCard2.get("suit").getAsString();

        card1 = new Card(rank1, suit1);
        card2 = new Card(rank2, suit2);
        if (card1.getIntRank() == card2.getIntRank()) {
            currentRank = Rank.PAIR.getValue();
        } else {
            currentRank = 0;
        }
        JsonArray communityCardsJson = getState(element).get("community_cards").getAsJsonArray();

        communityCards = Card.parse(communityCardsJson);

        isBlind = false;
        int dealer = getState(element).get("dealer").getAsInt();
        if (playerIndex == dealer + 1 || playerIndex == dealer + 2) {
            isBlind = true;
        }
    }

    @Override
    public int getMinimumRaise() {
        return minimumRaise;
    }

    public CardRound getCardRound() {
        return CardRound.FLOP;
    }

    private static JsonObject getState(JsonElement request) {
        return (JsonObject) request;
    }

    @Override
    public Card getCard1() {
        return card1;
    }

    @Override
    public Card getCard2() {
        return card2;
    }

    @Override
    public int getCurrentByIn() {
        return currentByIn;
    }

    @Override
    public int getPlayerIndex() {
        return playerIndex;
    }

    @Override

    public List<Card> getCardsOnBoard() {
        return communityCards;
    }

    @Override
    public int getStack() {
        return stack;
    }

    public boolean isBlind() {
        return isBlind;
    }

    @Override
    public int getOrbits() {
        return orbits;
    }

    @Override
    public int getCurrentRank() {
        return currentRank;
    }

    @Override
    public void setCurrentRank(int rank) {
        currentRank = rank;
    }

}
