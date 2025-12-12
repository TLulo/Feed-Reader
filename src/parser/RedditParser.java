package parser;

import java.util.ArrayList;
import java.util.List;
import java.util.Date;
import org.json.JSONObject;
import org.json.JSONArray;
import java.util.HashMap;

import httpRequest.httpRequester;
/*
 * Esta clase implementa el parser de feed de tipo reddit (json)
 * pero no es necesario su implemntacion 
 * */

public class RedditParser extends GeneralParser {

    public List<HashMap<String, Object>> parse(String file) {
        JSONObject redditJson = new JSONObject(file);
        JSONArray posts = redditJson.getJSONObject("data").getJSONArray("children");
        List<HashMap<String, Object>> articles = new ArrayList<>();
        for (int i = 0; i < posts.length(); i++) {
            JSONObject postData = posts.getJSONObject(i).getJSONObject("data");
            String title = postData.optString("title");
            String description = postData.optString("selftext");
            String link = "https://www.reddit.com" + postData.optString("permalink");
            long createdUtc = postData.optLong("created_utc") * 1000;
            Date pubDate = new Date(createdUtc);
            HashMap<String, Object> article = new HashMap<>();
            article.put("title", title);
            article.put("description", description);
            article.put("link", link);
            article.put("pubDate", pubDate);
            articles.add(article);
        }
        return articles;
    }

    public static void main(String[] args) {
        System.out.println("Starting RedditParser test...");
        httpRequester requester = new httpRequester();
        String url = "https://www.reddit.com/r/Marketing/hot/.json?count=100";

        String file = requester.getFeedReddit(url);

        List<HashMap<String, Object>> articles;
        RedditParser reddit = new RedditParser();
        articles = reddit.parse(file);

        System.out.println("Parsed Articles:");
        for (HashMap<String, Object> article : articles) {
            System.out.println("Title: " + article.get("title"));
            System.out.println("Description: " + article.get("description"));
            System.out.println("Link: " + article.get("link"));
            System.out.println("Publication Date: " + article.get("pubDate"));
            System.out.println("--------------------------------------------------");
        }
        System.out.println("RedditParser test completed.");
    }
}
