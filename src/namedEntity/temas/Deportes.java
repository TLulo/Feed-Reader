package namedEntity.temas;
import namedEntity.temas.Tema;

public class Deportes extends Tema {
    public String getTopicString() {
        return "Deportes";
    }
	public static class Futbol extends Deportes {
        public String getTopicString() {
            return "Futbol (" + super.getTopicString() + ")";
        }
	}

	public static class Basquet extends Deportes {
        public String getTopicString() {
            return "Basquet (" + super.getTopicString() + ")";
        }
	}

	public static class Tenis extends Deportes{
        public String getTopicString() {
            return "Tenis (" + super.getTopicString() + ")";
        }
	}

	public static class Formula_1 extends Deportes{ 
        public String getTopicString() {
            return "Formula 1 (" + super.getTopicString() + ")";
        }
	}

	public static class Otros extends Deportes{
        public String getTopicString() {
            return "Otros (" + super.getTopicString() + ")";
        }
	}
}
