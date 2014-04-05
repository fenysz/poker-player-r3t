/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;
import java.io.InputStreamReader;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author athalay
 */
public class GameStateTest {
    
    String TEST_STRING = "{\n" +
"    \"small_blind\": 10,\n" +
"    \"current_buy_in\": 320,\n" +
"    \"pot\": 400,\n" +
"    \"minimum_raise\": 240,\n" +
"    \"dealer\": 1,\n" +
"    \"orbits\": 7,\n" +
"    \"in_action\": 1,\n" +
"    \"players\": [\n" +
"        {\n" +
"            \"id\": 0,\n" +
"            \"name\": \"Albert\",\n" +
"            \"status\": \"active\",\n" +
"            \"version\": \"Default random player\",\n" +
"            \"stack\": 1010,\n" +
"            \"bet\": 320\n" +
"        },\n" +
"        {\n" +
"            \"id\": 1,\n" +
"            \"name\": \"Bob\",\n" +
"            \"status\": \"active\",\n" +
"            \"version\": \"Default random player\",\n" +
"            \"stack\": 1590,\n" +
"            \"bet\": 80,\n" +
"            \"hole_cards\": [\n" +
"                {\n" +
"                    \"rank\": \"6\",\n" +
"                    \"suit\": \"hearts\"\n" +
"                },\n" +
"                {\n" +
"                    \"rank\": \"K\",\n" +
"                    \"suit\": \"spades\"\n" +
"                }\n" +
"            ]\n" +
"        },\n" +
"        {\n" +
"            \"id\": 2,\n" +
"            \"name\": \"Chuck\",\n" +
"            \"status\": \"out\",\n" +
"            \"version\": \"Default random player\",\n" +
"            \"stack\": 0,\n" +
"            \"bet\": 0\n" +
"        }\n" +
"    ],\n" +
"    \"community_cards\": [\n" +
"        {\n" +
"            \"rank\": \"4\",\n" +
"            \"suit\": \"spades\"\n" +
"        },\n" +
"        {\n" +
"            \"rank\": \"A\",\n" +
"            \"suit\": \"hearts\"\n" +
"        },\n" +
"        {\n" +
"            \"rank\": \"6\",\n" +
"            \"suit\": \"clubs\"\n" +
"        }\n" +
"    ]\n" +
"}";
    
    private String preflopteststring = "{\n" +
"    \"small_blind\": 10,\n" +
"    \"current_buy_in\": 320,\n" +
"    \"pot\": 400,\n" +
"    \"minimum_raise\": 240,\n" +
"    \"dealer\": 1,\n" +
"    \"orbits\": 7,\n" +
"    \"in_action\": 1,\n" +
"    \"players\": [\n" +
"        {\n" +
"            \"id\": 0,\n" +
"            \"name\": \"Albert\",\n" +
"            \"status\": \"active\",\n" +
"            \"version\": \"Default random player\",\n" +
"            \"stack\": 1010,\n" +
"            \"bet\": 320\n" +
"        },\n" +
"        {\n" +
"            \"id\": 1,\n" +
"            \"name\": \"Bob\",\n" +
"            \"status\": \"active\",\n" +
"            \"version\": \"Default random player\",\n" +
"            \"stack\": 1590,\n" +
"            \"bet\": 80,\n" +
"            \"hole_cards\": [\n" +
"                {\n" +
"                    \"rank\": \"6\",\n" +
"                    \"suit\": \"hearts\"\n" +
"                },\n" +
"                {\n" +
"                    \"rank\": \"K\",\n" +
"                    \"suit\": \"spades\"\n" +
"                }\n" +
"            ]\n" +
"        },\n" +
"        {\n" +
"            \"id\": 2,\n" +
"            \"name\": \"Chuck\",\n" +
"            \"status\": \"out\",\n" +
"            \"version\": \"Default random player\",\n" +
"            \"stack\": 0,\n" +
"            \"bet\": 0\n" +
"        }\n" +
"    ],\n" +
"    \"community_cards\": [\n" +
"    ]\n" +
"}";

    @Test
    public void testSomeMethod() {
        JsonElement element = parseTestString();
        GameState gameState = new GameState(element);
        
        assertEquals("6", gameState.getCard1().rank);
        assertEquals("K", gameState.getCard2().rank);
    }
    
    private JsonElement parseTestString(){
         return new JsonParser().parse(preflopteststring);
    }
}