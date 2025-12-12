# paradigamas25-g25-lab2
Proyecto Feed Reader Paradigmas de la Programacion Famaf 2025

**Integrantes**
* Luciano Tula
* Mauro Robledo Godoy
* Sebastian Sierra
* Andy Galvan

**Que necesitamos para correr el proyecto?**  
Este Proyecto esta programado en java y utiliza la libreria org.json la cual debera encuentrarse en el directorio lib.
En particular el grupo utilizo la libreria: json-20210307.jar

**Ejecutar Reader**  
El Proyecto cuenta con un Makefile el cual dispone de varias opciones.

*Make*  
Ejecuta el Reader y despliega una ventana con los articules leidos.

*Make Heuristic*  
Ejecuta el Reader con el argumento -ne, y despliega una ventana con las opciones de "Categoria" o "Temas" a mostrar.

# En que se basa el proyecto?  

El proyecto es un lector de Feed de fuentes web, las web en las que se solicita se encuentran en el archivo "src/config/subscriptions.json" el cual hace referencia a las subscripciones del Feed.


# Clases y SubClases en Heuristic?  
Nuestro grupo decidio utilizar la jerarquia de clases como principal separador, donde cada entidad pertenece a la jerarquia.
Por otro lado los Topicos (implementados como un objeto) fueron utilizados como un atributo de cada entidad.

Se penso en implementar ambos como objetos para que nuestro proyecto pueda escalar tanto con los topicos como las clases.


