package org.leanpoker.player;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

/**
 * Created by roland on 2014.04.05..
 */
public class RankingService {

    public static String url="http://localhost:2048";

    public static Ranking getRanking(List<Card> cardList) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();

            con.setRequestMethod("POST");
            Cards cards = new Cards(cardList);
            String urlParameters = cards.toString();

            // Send post request
            con.setDoOutput(true);
            DataOutputStream wr = new DataOutputStream(con.getOutputStream());
            wr.writeBytes(urlParameters);
            wr.flush();
            wr.close();

            int responseCode = con.getResponseCode();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer response = new StringBuffer();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            JsonElement element = new JsonParser().parse(response.toString());
            Ranking rank = new Ranking(element);
            return rank;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
