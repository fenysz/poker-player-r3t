package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlayerTest {

    String testString = "{\n" +
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
            "            \"rank\": \"K\",\n" +
            "            \"suit\": \"spades\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rank\": \"A\",\n" +
            "            \"suit\": \"hearts\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rank\": \"7\",\n" +
            "            \"suit\": \"clubs\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rank\": \"8\",\n" +
            "            \"suit\": \"clubs\"\n" +
            "        },\n" +
            "        {\n" +
            "            \"rank\": \"3\",\n" +
            "            \"suit\": \"clubs\"\n" +
            "        }\n" +
            "    ]\n" +
            "}";

    @Before
    public void before() {
        RankingService.url = "http://192.168.57.104:2048";
    }

    @Test
    public void testBetRequest() throws Exception {
        JsonElement jsonElement = new JsonParser().parse(testString);
        assertEquals(560, Player.betRequest(jsonElement));
    }


    @Test
    public void testNotRaised() {
        JsonElement jsonElement = new JsonParser().parse(testString);
        int bet = Player.betRequest(jsonElement);
        assertEquals(560, bet);
        assertEquals(7, Player.raisedInOrbit);
    }
}
