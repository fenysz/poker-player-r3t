/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.leanpoker.player;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author athalay
 */
public class CardTest {
    
    public CardTest() {
    }

    @Test
    public void getIntRankTest() {
        Card card1 = new Card("A", "hearts");
        assertEquals(14, card1.getIntRank());
    }
}