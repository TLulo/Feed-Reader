package parser;

import java.util.List;
import java.util.HashMap;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;

import subscription.Subscription;
import subscription.SingleSubscription;
/*
 * Esta clase implementa el parser del  archivo de suscripcion (json)
 * Leer https://www.w3docs.com/snippets/java/how-to-parse-json-in-java.html
 * */

public class SubscriptionParser extends GeneralParser {
    private Subscription json;
    private String content;
    private JSONArray jsonArray;

    // codigo para que compile
    public List<HashMap<String, Object>> parse(String file) {
        List<HashMap<String, Object>> lista = new ArrayList<>();
        jsonArray = getDataJson(file);

        for (int i = 0; i < jsonArray.length(); i++) {
            JSONObject obj = jsonArray.getJSONObject(i);
            HashMap<String, Object> hash = new HashMap<>();

            for (String key : obj.keySet()) {
                Object value = obj.get(key);
                if (value instanceof JSONArray) {
                    JSONArray txt = (JSONArray) value;
                    List<String> urlParams = new ArrayList<>();
                    for (int j = 0; j < txt.length(); j++) {
                        urlParams.add(txt.getString(j));
                    }
                    List<String> params = urlParams;
                    value = (List<String>) params;
                }
                hash.put(key, value);
            }
            lista.add(hash);
        }
        return lista;
    }

    private JSONArray getDataJson(String file) {
        JSONArray jsonArray;
        try {
            FileReader reader = new FileReader(file);
            jsonArray = new JSONArray(new JSONTokener(reader));
        } catch (Exception e) {
            e.printStackTrace();
            jsonArray = new JSONArray(); // Return an empty array in case of error
        }
        return jsonArray;
    }

    public static void main(String[] args) {
        SubscriptionParser subsParser = new SubscriptionParser();

        List<HashMap<String, Object>> subscriptions = subsParser.parse("config/subscriptions.json");
        for (HashMap<String, Object> subscription : subscriptions) {
            System.out.println(subscription);
        }
    }
}
