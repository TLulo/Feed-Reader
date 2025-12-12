package namedEntity.temas;

import namedEntity.temas.Tema;

public class Cultura extends Tema {
    public String getTopicString() {
        return "Cultura";
    }

	public static class Cine extends Cultura {
        public String getTopicString() {
            return "Cine (" + super.getTopicString() + ")";
        }
	}

	public static class Musica extends Cultura {
        public String getTopicString() {
            return "Musica (" + super.getTopicString() + ")";
        }
	}

	public static class Otros extends Cultura {
        public String getTopicString() {
            return "Otros (" + super.getTopicString() + ")";
        }
	}
}
