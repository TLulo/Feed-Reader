package namedEntity.Classes;

import namedEntity.Classes.Persona.*;
import namedEntity.Classes.Lugar.*;
import namedEntity.NamedEntity;

public class ClassesUtils {

    public NamedEntity instanceEntity(String type, String name) {
        switch (type) {
            case "Apellido":
                return new Apellido(name);
            case "Nombre":
                return new Nombre(name);
            case "Titulo":
                return new Titulo(name);
            case "Ciudad":
                return new Ciudad(name);
            case "Direccion":
                return new Direccion(name);
            case "Pais":
                return new Pais(name);
            case "Evento":
                return new Evento(name);
            case "Fecha":
                return new Fecha(name);
            case "Organizacion":
                return new Organizacion(name);
            case "Producto":
                return new Producto(name);
            default:
                return new Otro(name);
        }
    }
}
