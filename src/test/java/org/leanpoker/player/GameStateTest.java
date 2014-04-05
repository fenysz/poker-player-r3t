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

    @Test
    public void testSomeMethod() {
        JsonElement element = parseTestString();
        GameState gameState = new GameState(element);
        
        assertEquals(CardRound.FLOP, gameState.getCardRound());
    }
    
    private JsonElement parseTestString(){
         JsonReader jsonreader = new JsonReader(new InputStreamReader(getClass().getResourceAsStream("core/build/resources/test_json1.json")));
         return new JsonParser().parse(jsonreader);
    }
}