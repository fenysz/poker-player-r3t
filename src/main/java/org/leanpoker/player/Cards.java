package org.leanpoker.player;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by roland on 2014.04.05..
 */
public class Cards {
    public List<String> cards;

    public Cards(List<Card> cardList) {
        cards = new ArrayList<String>();
        for (Card card : cardList) {
            cards.add("{\"rank\":\"" + card.rank + "\",\"suit\":\"" + card.suit + "\"}");
        }
    }

    @Override
    public String toString() {
        String ret = "cards=[";
        for (String card : cards) {
            ret += card + ",";
        }
        ret = ret.substring(0, ret.length() - 1);
        ret += "]";
        return ret;
    }
}
