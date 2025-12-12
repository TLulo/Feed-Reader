package parser;

import java.util.List;
import java.util.HashMap;

/*Esta clase modela los atributos y metodos comunes a todos los distintos tipos de parser existentes en la aplicacion*/
public abstract class GeneralParser {

    public abstract List<HashMap<String,Object>> parse(String file);
}
