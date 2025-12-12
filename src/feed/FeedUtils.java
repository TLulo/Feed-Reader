package feed;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import feed.Article;
import feed.Feed;
import namedEntity.heuristic.Heuristic;
import namedEntity.temas.*;

public class FeedUtils {

	public static List<namedEntity.NamedEntity> computeFeed(Feed subscriptions_feed, Heuristic h) {
		List<namedEntity.NamedEntity> namedEntityList = new ArrayList<namedEntity.NamedEntity>();
		for (int i = 0; i < subscriptions_feed.getNumberOfArticles(); i++) {
			Article a = subscriptions_feed.getArticle(i);
			a.computeNamedEntities(h);
			List<namedEntity.NamedEntity> newList = a.getNamedEntityList();

			/* Check if the elements are already in the list. If they are,
			 * increment their frequency. If not, add them to the list.
			 */
			for (namedEntity.NamedEntity e : newList) {
				boolean found = false;
				for (namedEntity.NamedEntity e2 : namedEntityList) {
					if (e2.getName().equals(e.getName())) {
						e2.setFrequency(e2.getFrequency() + e.getFrequency());
						found = true;
						break;
					}
				}
				if (!found) {
					namedEntityList.add(e);
				}
			}
			//namedEntityList = a.getNamedEntityList();
		}
		return namedEntityList;
	}
}
