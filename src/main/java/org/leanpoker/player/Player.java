package org.leanpoker.player;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Player {

    public static int betRequest(JsonElement request) {
        int playerIndex = getState(request).get("in_action").getAsInt();
        JsonObject player =  getState(request).getAsJsonArray("players").get(playerIndex).getAsJsonObject();
        JsonObject card1 = player.getAsJsonArray("hole_cards").get(0).getAsJsonObject();
        JsonObject card2 = player.getAsJsonArray("hole_cards").get(1).getAsJsonObject();
        
        int currentByIn = request.getAsJsonObject().get("current_buy_in").getAsInt();
        
        String rank1 = card1.get("rank").getAsString();
        String rank2 = card2.get("rank").getAsString();
        
        if(rank1.equals(rank2)){
            return currentByIn + 40;
        }
        
        for (Map.Entry<String, JsonElement> entry : request.getAsJsonObject().entrySet()) {

            System.out.println(entry.getKey() + " : " + entry.getValue());

        }

        return 0;

    }
    
    private static JsonObject getState(JsonElement request){
        System.err.println("request class  : " + request.getClass().getCanonicalName());
        return (JsonObject) request;
    }

    public static void showdown(JsonElement game) {
    }
}
