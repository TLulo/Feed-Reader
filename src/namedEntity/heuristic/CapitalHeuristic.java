package namedEntity.heuristic;

import namedEntity.*;
import namedEntity.heuristic.*;
import namedEntity.Classes.*;
import namedEntity.Classes.Persona.*;
import namedEntity.Classes.Lugar.*;
import feed.*;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CapitalHeuristic extends Heuristic {

    List<NamedEntity> entities = new ArrayList<>();

    private static final Set<String> STOPWORDS = Set.of(
            "I", "The", "A", "An", "And", "Or", "But", "If", "Then", "So", "Because",
            "Is", "Are", "Was", "Were", "Has", "Have", "Had", "Do", "Does", "Did",
            "Not", "This", "That", "These", "Those", "You", "We", "They", "It",
            "In", "On", "At", "To", "From", "Of", "With", "For", "As", "By", "About",
            "What", "Which", "Who", "Whom", "How", "When", "Where", "Why", "Will",
            "Would", "Should", "Could", "May", "Might", "Must", "Shall", "Im", "Now",
            "Just", "Hi", "Thanks", "Lot", "Very", "Much", "Many", "Most", "Your", "Cons");

    private static final Set<String> PERSONS = Set.of("Trump", "John", "Paula", "Kerger", "Robyn", "Denholm");
    private static final Set<String> LOCATIONS = Set.of("Canada", "Japan", "Miami", "Newark", "Minnesota", "Asia",
            "Africa");
    private static final Set<String> ORGANIZATIONS = Set.of("Facebook", "Tesla", "Coinbase", "YouTube", "OpenAI",
            "TikTok", "Google", "Meta", "Starbucks", "DocuSign", "Paychex");
    private static final Set<String> PRODUCTS = Set.of("Grok", "Codex", "Instagram");

    private String clean(String word) {
        // Elimina puntuación alrededor (.,!? etc.)
        return word.replaceAll("^[^\\p{L}\\p{N}]+|[^\\p{L}\\p{N}]+$", "");
    }

    @Override
    public boolean isEntity(String word) {
        boolean isLongEnough = word.length() > 3;
        boolean hasCapitalization = word.length() > 1 && Character.isUpperCase(word.charAt(0))
                && Character.isLowerCase(word.charAt(1));
        boolean isNotStopword = !STOPWORDS.contains(word);
        boolean doesNotContainApostrophe = !word.contains("’") && !word.contains("'");

        boolean isEntity = isLongEnough && hasCapitalization && isNotStopword && doesNotContainApostrophe;

        // Aquí puedes agregar más verificaciones y combinarlas con isEntity si lo
        // deseas

        return isEntity;
    }

    @Override
    public List<NamedEntity> extract(Article article) {
        List<NamedEntity> result = new ArrayList<>();
        Map<String, Integer> frequency = new HashMap<>();

        String text = article.getTitle() + " " + article.getText();
        String[] words = text.split("\\s+");

        for (String word : words) {
            String cleanWord = clean(word);
            if (isEntity(cleanWord)) {
                frequency.put(cleanWord, frequency.getOrDefault(cleanWord, 0) + 1);
            }
        }
        Heuristic heuristic = new CapitalHeuristic();

        for (Map.Entry<String, Integer> entry : frequency.entrySet()) {
            if (entry.getValue() >= 2) {
                String name = entry.getKey();
                String category = heuristic.getCategory(name);
                result.add(new NamedEntity(name, category, entry.getValue()));
            }
        }

        return result;
    }
}
