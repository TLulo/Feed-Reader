package namedEntity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import namedEntity.temas.*;

public class NamedUtils {

	public static HashMap<String, List<NamedEntity>> makeEntityListMap(String groupBy, List<NamedEntity> namedEntityList) {
		HashMap<String, List<NamedEntity>> entityListMap = new HashMap<>();
		String key;

		for (namedEntity.NamedEntity ne : namedEntityList) {
			if (groupBy.toLowerCase().equals("category")) {
				key = ne.getCategory();
			} else if (groupBy.toLowerCase().equals("topic")) {
				key = ne.getTopic().getTopicString();
			} else {
				return null;
			}

			entityListMap.putIfAbsent(key, new ArrayList<>());
			entityListMap.get(key).add(ne);
		}
		return entityListMap;
	}

	public static void printByGroup(String groupType, String groupName, HashMap<String, List<NamedEntity>> entityListMap) {
		String headerString;
		if (groupType.toLowerCase().equals("category")) {
			headerString = "Categoría: " + groupName;
		} else if (groupType.toLowerCase().equals("topic")) {
			headerString = "Tema: " + groupName;
		} else {
			return;
		}

		System.out.println("=============================================");
		System.out.println(headerString);
		System.out.println("=============================================");

		List<NamedEntity> entitiesToPrint = entityListMap.get(groupName);
		for (NamedEntity entity : entitiesToPrint) {
			System.out.println("");
			entity.prettyPrint();
			System.out.println("Frecuencia: " + entity.getFrequency());
			System.out.println("");
		}
	}
}
