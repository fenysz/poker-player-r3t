package org.leanpoker.player;

import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Player {

    public static int betRequest(JsonElement request) {
        RankingService rs = new RankingService();

        for (Map.Entry<String, JsonElement> entry : request.getAsJsonObject().entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }
        List<Card> cardList = new ArrayList<Card>();
        cardList.add(new Card(2, "diamonds"));
        cardList.add(new Card(2, "spades"));
        cardList.add(new Card(2, "spades"));
        cardList.add(new Card(2, "spades"));
        cardList.add(new Card(2, "spades"));
        Ranking rank = rs.getRanking(cardList);

        return 0;

    }

    public static void showdown(JsonElement game) {
    }
}
