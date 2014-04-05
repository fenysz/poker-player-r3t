package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.leanpoker.player.preflop.PreFlopper;


public class Player {
    static final String VERSION = "v0.1";

    public static int betRequest(JsonElement request) {
        RankingService rs = new RankingService();
        
        GameState state = new GameState(request);
        if(state.getCardsOnBoard().isEmpty()){
            return new PreFlopper(state).bet();
        }

        for (Map.Entry<String, JsonElement> entry : request.getAsJsonObject().entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
        List<Card> cardList = new ArrayList<Card>();
        cardList.add(new Card("2", "diamonds"));
        cardList.add(new Card("2", "spades"));
        cardList.add(new Card("2", "spades"));
        cardList.add(new Card("2", "spades"));
        cardList.add(new Card("2", "spades"));
        Ranking rank = rs.getRanking(cardList);

        return 0;

    }

    private static JsonObject getState(JsonElement request) {
        System.err.println("request class  : " + request.getClass().getCanonicalName());
        return (JsonObject) request;
    }

    public static void showdown(JsonElement game) {
    }
}
