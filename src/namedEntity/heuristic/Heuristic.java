package namedEntity.heuristic;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import namedEntity.temas.*;

import namedEntity.NamedEntity;
import namedEntity.Classes.Persona.Persona;
import feed.*;

public abstract class Heuristic {

	// se cambia Map.of por Map.ofEntries para tener mas de 10 opciones de
	// categorias posibles ya que Map.of solo soporta 10
	private static Map<String, String> categoryMap = Map.ofEntries(
			// PERSONS
			Map.entry("Federer", "Apellido"),
			Map.entry("Messi", "Apellido"),
			Map.entry("Biden", "Apellido"),
			Map.entry("Musk", "Apellido"),
			Map.entry("Trump", "Apellido"),
			Map.entry("John", "Nombre"),
			Map.entry("Paula", "Nombre"),
			Map.entry("Kerger", "Persona"),
			Map.entry("Robyn", "Nombre"),
			Map.entry("Denholm", "Nombre"),
			// LOCATIONS
			Map.entry("USA", "Pais"),
			Map.entry("Russia", "Pais"),
			Map.entry("Canada", "Pais"),
			Map.entry("Japan", "Pais"),
			Map.entry("Miami", "Ciudad"),
			Map.entry("Newark", "Ciudad"),
			Map.entry("Minnesota", "Ciudad"),
			Map.entry("Asia", "Pais"),
			Map.entry("Africa", "Pais"),
			// ORGANIZATIONS
			Map.entry("Microsoft", "Organizacion"),
			Map.entry("Apple", "Organizacion"),
			Map.entry("Google", "Organizacion"),
			Map.entry("Facebook", "Organizacion"),
			Map.entry("Tesla", "Organizacion"),
			Map.entry("Coinbase", "Organizacion"),
			Map.entry("YouTube", "Organizacion"),
			Map.entry("OpenAI", "Organizacion"),
			Map.entry("TikTok", "Organizacion"),
			Map.entry("Meta", "Organizacion"),
			Map.entry("Starbucks", "Organizacion"),
			Map.entry("DocuSign", "Organizacion"),
			Map.entry("Paychex", "Organizacion"),
			// PRODUCTS
			Map.entry("Grok", "Producto"),
			Map.entry("Codex", "Producto"),
			Map.entry("Instagram", "Producto"),
			// DAYS
			Map.entry("Monday", "Fecha"),
			Map.entry("Tuesday", "Fecha"),
			Map.entry("Wednesday", "Fecha"),
			Map.entry("Thursday", "Fecha"),
			Map.entry("Friday", "Fecha"),
			Map.entry("Saturday", "Fecha"),
			Map.entry("Sunday", "Fecha"),
			Map.entry("Weekly", "Fecha"));

	private static Map<String, Tema> topicMap = Map.ofEntries(
			// PERSONS
			Map.entry("Federer", new Deportes.Tenis()),
			Map.entry("Messi", new Deportes.Futbol()),
			Map.entry("Biden", new Politica.Internacional()),
			Map.entry("Musk", new Otros()),
			Map.entry("Trump", new Politica.Internacional()),
			// LOCATIONS
			Map.entry("USA", new Politica.Internacional()),
			Map.entry("Russia", new Politica.Internacional()),
			Map.entry("Canada", new Politica.Internacional()),
			Map.entry("Japan", new Politica.Internacional()),
			Map.entry("Miami", new Politica.Internacional()),
			Map.entry("Newark", new Politica.Internacional()),
			Map.entry("Minnesota", new Politica.Internacional()),
			Map.entry("Asia", new Politica.Internacional()),
			Map.entry("Africa", new Politica.Internacional()),
			// ORGANIZATIONS
			Map.entry("YouTube", new Cultura.Otros()),
			Map.entry("TikTok", new Cultura.Otros()),
			Map.entry("Spotify", new Cultura.Musica()));


	public String getCategory(String entity) {
		if (entity == null || entity.isEmpty())
			return "Otro"; // protección

		String category = categoryMap.get(entity);
		if (category != null)
			return category;

		// Heurísticas adicionales
		if (entity.matches(".*(Inc|Corp|LLC|Ltd|Group|Company|Foundation)$")) {
			return "Organizacion";
		}
		if (entity.matches("\\d{1,2}/\\d{1,2}/\\d{2,4}")) { // matches date format like 12/05/2024
			return "Fecha";
		}

		return "Otro";
	}


	public Tema getTopic(String entity) {
		Tema topic = topicMap.get(entity);
		if (topic == null) {
			topic = new Otros();
		}
		return topic;
	}

	public abstract List<NamedEntity> extract(Article article);

	public abstract boolean isEntity(String word);

}
