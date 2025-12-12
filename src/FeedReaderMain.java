import java.util.Date;
import java.util.HashMap;
import java.util.List;

import feed.*;
import httpRequest.httpRequester;
import parser.*;
import subscription.*;

import namedEntity.*;
import namedEntity.temas.*;

import namedEntity.heuristic.*;

public class FeedReaderMain {
    private static String filename = "config/subscriptions.json";

    private static void printHelp() {
        System.out.println("Please, call this program in correct way: FeedReader [-ne]");
    }

    public static void main(String[] args) {
        System.out.println("************* FeedReader version 1.0 *************");
        /*
         * Leer el archivo de suscription por defecto;
         * Llamar al httpRequester para obtener el feed del servidor
         * Llamar al Parser especifico para extrar los datos necesarios por la
         * aplicacion
         * Llamar al constructor de Feed
         */

        Subscription subscriptions = new Subscription(null);
        subscriptions = parseSubscriptions(filename);

        Feed subscriptions_feed = new Feed(null);
        subscriptions_feed = parseFeed(subscriptions);

        System.out.println();

        if (args.length == 0) {

            /*
             * LLamar al prettyPrint del Feed para ver los articulos del feed en forma
             * legible y amigable para el usuario
             */
            // subscriptions_feed.prettyPrint();
            feed.ArticleViewer.showArticles(subscriptions_feed.getArticleList());

        } else if (args.length == 1) {

            /*
             * Llamar a la heuristica para que compute las entidades nombradas de cada
             * articulos del feed
             * LLamar al prettyPrint de la tabla de entidades nombradas del feed.
             */
            HashMap<String, List<NamedEntity>> articlesByCategory = new HashMap<>();
            HashMap<String, List<NamedEntity>> articlesByTopic = new HashMap<>();

            // RandomHeuristic h = new RandomHeuristic();
            CapitalHeuristic h = new CapitalHeuristic();
            //NamedUtils nutils = new NamedUtils();
            List<NamedEntity> namedEntityList = FeedUtils.computeFeed(subscriptions_feed, h);

            namedEntity.NamedEntity.showEntitiesInJFrame(namedEntityList, "category");

            // Setear por lista de categorias.
            // articlesByCategory = NamedUtils.makeEntityListMap("category", namedEntityList);

            // Setear por lista de temas.
            // articlesByTopic = NamedUtils.makeEntityListMap("topic", namedEntityList);

            // System.out.println("=============================================");
            // System.out.println("CATEGORÍAS");

            // print otros
            // NamedUtils.printByGroup("Category", "Otro", articlesByCategory);

            // print all categories
            // for (String category : articlesByCategory.keySet()) {
            // if (!category.equals("Otro")) {
            // NamedUtils.printByGroup("category", category, articlesByCategory);
            // }
            // }

            // System.out.println("=============================================");
            // System.out.println("TEMAS:");

            // print all topics
            // for (String topic : articlesByTopic.keySet()) {
            // NamedUtils.printByGroup("topic", topic, articlesByTopic);
            // }

        } else {
            printHelp();
        }
    }

    // Modules

    private static Subscription parseSubscriptions(String filename) {
        /*
         * Parsea el json de subscriptions y lo convierte en una lista de
         * HashMap<String,Object> donde cada HashMap representa una
         * suscripcion.
         */
        System.out.println("Parsing Subscriptions.");
        List<HashMap<String, Object>> list_of_subscriptions;
        SubscriptionParser sparser = new SubscriptionParser();
        list_of_subscriptions = sparser.parse(filename);
        Subscription subscriptions = new Subscription(filename);
        list_of_subscriptions.forEach(map -> {
            SingleSubscription sub = new SingleSubscription((String) map.get("url"),
                    (List<String>) map.get("urlParams"),
                    (String) map.get("urlType"));
            subscriptions.addSingleSubscription(sub);
        });
        System.out.println("Subscriptions parsed.\n");
        return subscriptions;
    }

    /*
     * Llama al httpRequester para obtener el feed del servidor
     * Llama al Parser especifico para extrar los datos necesarios por la aplicacion
     * Llama al constructor de Feed
     */
    private static Feed parseFeed(Subscription subscriptions) {
        Feed subscriptions_feed = new Feed("My Feed");
        SingleSubscription sub;
        String data;
        List<HashMap<String, Object>> result;
        httpRequester req = new httpRequester();

        for (int i = 0; i < subscriptions.sizeList(); ++i) {
            GeneralParser parser;
            Article article;
            sub = subscriptions.getSingleSubscription(i);
            List<String> params = sub.getUrlParams();
            String url = sub.getUrl();
            String urlType = sub.getUrlType();

            for (int j = 0; j < params.size(); j++) {
                /*
                 * Reemplazar %s por el contenido de p en la URL y hacer el
                 * pedido al servidor.
                 */
                String p = params.get(j);
                String fullUrl = String.format(url, p);

                System.out.print("Connecting to ");
                System.out.println(fullUrl);

                if (urlType.equals("rss")) {
                    parser = new RssParser();
                    data = req.getFeedRss(fullUrl);
                } else {
                    parser = new RedditParser();
                    data = req.getFeedReddit(fullUrl);
                }

                /* Parse the data. */
                result = parser.parse(data);

                /* Construct the Articles and add it to the Feed */
                for (int k = 0; k < result.size(); k++) {
                    HashMap<String, Object> map = result.get(k);
                    article = new Article((String) map.get("title"),
                            (String) map.get("description"),
                            (Date) map.get("pubDate"),
                            (String) map.get("link"));
                    subscriptions_feed.addArticle(article);
                }
            }
        }
        return subscriptions_feed;

    }

}
