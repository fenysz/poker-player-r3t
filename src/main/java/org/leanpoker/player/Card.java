package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roland on 2014.04.05..
 */
public class Card {
    String rank;
    String suit;

    public Card(String rank, String suit) {
        this.rank = rank.toUpperCase();
        this.suit = suit.toUpperCase();
    }

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getIntRank(){
        try {
            return Integer.parseInt(rank);
        } catch(Exception e) {
            switch (rank){
                case "J": return 11;
                case "Q": return 12;
                case "K": return 13;
                default:
                case "A": return 14;
            } 
        }
    }

    public static List<Card> parse(JsonArray communityCardsJson) {
        List<Card> cardList = new ArrayList<Card>();
        for (int i = 0; i < communityCardsJson.size(); i++) {
            JsonObject cardObject = communityCardsJson.get(i).getAsJsonObject();
            cardList.add(new Card(cardObject.get("rank").getAsString(), cardObject.get("suit").getAsString()));
        }
        return cardList;
    }
}
