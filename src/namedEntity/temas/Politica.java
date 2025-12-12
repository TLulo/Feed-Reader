package namedEntity.temas;
import namedEntity.temas.Tema;

public class Politica extends Tema {
    public String getTopicString() {
        return "Politica";
    }

	public static class Nacional extends Politica {
        public String getTopicString() {
            return "Nacional (" + super.getTopicString() + ")";
        }
	}

	public static class Internacional extends Politica {
        public String getTopicString() {
            return "Internacional (" + super.getTopicString() + ")";
        }
	}

	public static class Otros extends Politica {
        public String getTopicString() {
            return "Otros (" + super.getTopicString() + ")";
        }
	}
}
