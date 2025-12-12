package parser;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

import java.util.Date;

/*
 * Esta clase implementa el parser del feed RSS (xml)
 * Leer https://www.tutorialspoint.com/java_xml/java_dom_parse_document.htm
 */

public class RssParser extends GeneralParser {

    public RssParser() {
        super();
    }

    @Override
    public List<HashMap<String, Object>> parse(String file) {
        List<HashMap<String, Object>> articles = new ArrayList<>();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            StringBuilder xmlBuilder = new StringBuilder();
            xmlBuilder.append(file);
            ByteArrayInputStream input = new ByteArrayInputStream(xmlBuilder.toString().getBytes("UTF-8"));
            Document doc = builder.parse(input);
            doc.getDocumentElement().normalize();

            // Obtener lista de <item>
            NodeList items = doc.getElementsByTagName("item");

            for (int i = 0; i < items.getLength(); i++) {
                Node node = items.item(i);

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    // Extraer los campos deseados
                    String title = getTagValue("title", element);
                    String description = getTagValue("description", element);
                    String date = getTagValue("pubDate", element);
                    SimpleDateFormat formatter = new SimpleDateFormat("EEE, dd MMM yyy HH:mm:ss Z",
                            java.util.Locale.ENGLISH);
                    Date pubDate = formatter.parse(date);
                    String link = getTagValue("link", element);

                    HashMap<String, Object> article = new HashMap<>();
                    article.put("title", title);
                    article.put("description", description);
                    article.put("pubDate", pubDate);
                    article.put("link", link);

                    articles.add(article);
                }
            }
        } catch (Exception e) {
            System.out.println("Error al parsear RSS: " + e.getMessage());
        }

        return articles;
    }

    // Método auxiliar para obtener el contenido de un tag
    private String getTagValue(String tag, Element element) {
        NodeList nodeList = element.getElementsByTagName(tag);
        if (nodeList != null && nodeList.getLength() > 0) {
            Node node = nodeList.item(0);
            return node.getTextContent();
        }
        return "";
    }

    public static void main(String[] args) {
        System.out.println("Starting RSS feed parsing test...");
        httpRequest.httpRequester requester = new httpRequest.httpRequester();
        String url = "https://rss.nytimes.com/services/xml/rss/nyt/Technology.xml";

        String file = requester.getFeedRss(url);

        if (file == null || file.isEmpty()) {
            System.out.println("Failed to fetch RSS feed or the feed is empty.");
            return;
        }

        RssParser rss = new RssParser();
        List<HashMap<String, Object>> articles = rss.parse(file);

        if (articles.isEmpty()) {
            System.out.println("No articles found in the RSS feed.");
        } else {
            System.out.println("Parsed Articles:");
            for (HashMap<String, Object> article : articles) {
                System.out.println("Title: " + article.get("title"));
                System.out.println("Description: " + article.get("description"));
                System.out.println("Link: " + article.get("link"));
                System.out.println("Publication Date: " + article.get("pubDate"));
                System.out.println("--------------------------------------------------");
            }
        }

        System.out.println("RSS feed parsing test completed.");
    }
}
