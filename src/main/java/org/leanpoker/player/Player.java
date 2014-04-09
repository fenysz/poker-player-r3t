package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.leanpoker.player.preflop.AfterFlopper;
import org.leanpoker.player.preflop.PreFlopper;

public class Player {
    static final String VERSION = "v0.50";
    public static int lastOrbit = 0;
    public static int lastRaisedRank = 0;

    public static int betRequest(JsonElement request) {
        GameState state = new GameState(request);
        int bet;
        if (state.getCardsOnBoard().isEmpty()) {
            bet = new PreFlopper(state).bet();
        } else {
            bet = new AfterFlopper(state).bet();
        }
        if (bet > state.getCurrentByIn()) {
            if (lastRaisedRank >= state.getCurrentRank()) {
                bet = state.getCurrentByIn();
            }
        }

        if (bet > 0 && (state.getStack() - bet) < (state.getMinimumRaise() * 4) && (state.getCurrentRank() < Rank.TREE_OF_A_KIND.getValue())) {
            System.out.println("stack protection, bet: " + bet + " stack: " + state.getStack() + " minRaise: " + state.getMinimumRaise() + " rank: " + state.getCurrentRank()+" buyin: "+state.getCurrentByIn());
            bet = 0;
        }

        if (Player.lastOrbit == state.getOrbits()) {
            lastRaisedRank = state.getCurrentRank();
        } else {
            lastRaisedRank = 0;
            Player.lastOrbit = state.getOrbits();
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
