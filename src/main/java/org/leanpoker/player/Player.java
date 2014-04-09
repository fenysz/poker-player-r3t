package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.leanpoker.player.preflop.AfterFlopper;
import org.leanpoker.player.preflop.PreFlopper;

public class Player {
    static final String VERSION = "v0.48";
    public static int raisedInOrbit = 0;
    public static int lastRaisedRank = -1;

    public static int betRequest(JsonElement request) {
        GameState state = new GameState(request);
        int bet;
        if (state.getCardsOnBoard().isEmpty()) {
            bet = new PreFlopper(state).bet();
        } else {
            bet = new AfterFlopper(state).bet();
        }
        if (bet > state.getCurrentByIn()) {
            if (Player.raisedInOrbit == 0 && lastRaisedRank <= state.getCurrentRank()) {
                Player.raisedInOrbit = state.getOrbits();
                lastRaisedRank = state.getCurrentRank();
            } else {
                lastRaisedRank = 0;
                bet = state.getCurrentByIn();
            }
        } else {
            Player.raisedInOrbit = 0;
        }
        if ((state.getStack() - bet) < (state.getMinimumRaise() * 4) && (state.getCurrentRank() < Rank.TREE_OF_A_KIND.getValue())) {
            return 0;
        }
        return bet;
    }

    private static JsonObject getState(JsonElement request) {
        System.err.println("request class  : " + request.getClass().getCanonicalName());
        return (JsonObject) request;
    }

    public static void showdown(JsonElement game) {
    }


}
