package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Player {
    static final String VERSION = "v0.1";

    public static int betRequest(JsonElement request) {
        RankingService rs = new RankingService();
        
        GameState state = new GameState(request);
        int playerIndex = getState(request).get("in_action").getAsInt();
        JsonObject player = getState(request).getAsJsonArray("players").get(playerIndex).getAsJsonObject();
        JsonObject card1 = player.getAsJsonArray("hole_cards").get(0).getAsJsonObject();
        JsonObject card2 = player.getAsJsonArray("hole_cards").get(1).getAsJsonObject();

        int currentByIn = request.getAsJsonObject().get("current_buy_in").getAsInt();
        String rank1 = card1.get("rank").getAsString();
        String rank2 = card2.get("rank").getAsString();

        if (rank1.equals(rank2)) {
            return currentByIn + 40;
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
