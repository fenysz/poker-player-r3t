package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.leanpoker.player.preflop.AfterFlopper;
import org.leanpoker.player.preflop.PreFlopper;

public class Player {
    static final String VERSION = "v0.31";

    public static int betRequest(JsonElement request) {
        GameState state = new GameState(request);
        if (state.getCardsOnBoard().isEmpty()) {
            return new PreFlopper(state).bet();
        } else {
            return new AfterFlopper(state).bet();
        }
    }

    private static JsonObject getState(JsonElement request) {
        System.err.println("request class  : " + request.getClass().getCanonicalName());
        return (JsonObject) request;
    }

    public static void showdown(JsonElement game) {
    }


}
