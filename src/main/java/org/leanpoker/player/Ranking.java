package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;

import java.util.List;

/**
 * Created by roland on 2014.04.05..
 */
public class Ranking {
    private Integer rank;
    private Integer value;
    private Integer secondValue;
    private List<Card> usedCards;

    public Ranking(JsonElement element) {
        JsonObject jsonObject = element.getAsJsonObject();
        try {
            JsonPrimitive errorObject = jsonObject.getAsJsonPrimitive("error");
            String error = errorObject.toString();
            if (error.length() > 0) {
                System.out.println(error);
                return;
            }
        } catch (Exception e) {
            rank = Integer.parseInt(jsonObject.getAsJsonPrimitive("rank").toString());
            value = Integer.parseInt(jsonObject.getAsJsonPrimitive("value").toString());
            secondValue = Integer.parseInt(jsonObject.getAsJsonPrimitive("second_value").toString());
            usedCards = Card.parse(jsonObject.getAsJsonArray("cards_used"));
        }
    }

    public Integer getRank() {
        return rank;
    }

    public Integer getValue() {
        return value;
    }

    public Integer getSecondValue() {
        return secondValue;
    }
}
