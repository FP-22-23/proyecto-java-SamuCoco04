# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Samuel Coco Delfa   uvus:TRV5192


## Estructura de las carpetas del proyecto

* **/src**: Contiene los diferentes archivos que forman parte del proyecto. Debe estar estructurado en los siguentes paquetes
  * **fp.futbol**: Paquete que contiene los tipos del proyecto.
  * **fp.test**: Paquete que contiene las clases de test del proyecto.
  * **fp.common**: Paquete que contiene los tipos auxiliares del proyecto
  * **fp.utiles**:  Paquete que contiene las clases de utilidad. 
* **/data**: Contiene el dataset del proyecto
    
## Estructura del *dataset*

Aquí debes describir la estructura del dataset explicando qué representan los datos que contiene y la descripción de cada una de las columnas. Incluye también la URL del dataset original.

El dataset está compuesto por 16 columnas, con la siguiente descripción:

* **Nombre**: de tipo String, representa el nombre del futbolista
* **Posiciones**: de tipo LinkedList, representa las posiciones que puede jugar
* **Valoracion**: de tipo Integer,representa Valoracion sobre 99 del rendimiento del jugador
* **Potencial**: de tipo Integer, representa la valoracion potencial del jugador
* **Valor**: de tipo Double, representa el valor del jugador
* **Sueldo**: de tipo Double, representa el sueldo del jugador
* **Edad**: de tipo Integer, representa la edad del jugador
* **DOB**: de tipo LocalDate, representa la fecha de nacimiento del jugador
* **Altura**: de tipo Integer, representa la altura del jugador
* **Peso**: de tipo Integer, representa el peso del jugador
* **Club**: de tipo Club, representa el club del jugador(contiene String equipo,integer socios e Integer titulos)
* **Nacionalidad**: de tipo String, representa el pais del jugador
* **PieBueno**: de tipo PieBUeno, representa el pie hábil del jugador
* **Cara**:de tipo boolean, representa si la cara del jugador es la real(en el juego)
....

## Tipos implementados

Los tipos que se han implementado en el proyecto son:

### Tipo Jugador
Representa un estudiante concreto

**Propiedades**:

* Nombre: de tipo String, representa el nombre del futbolista
* Posiciones: de tipo LinkedList, representa las posiciones que puede jugar
* Valoracion: de tipo Integer,representa Valoracion sobre 99 del rendimiento del jugador
* Potencial: de tipo Integer, representa la valoracion potencial del jugador
* Valor: de tipo Double, representa el valor del jugador
* Sueldo: de tipo Double, representa el sueldo del jugador
* Edad: de tipo Integer, representa la edad del jugador
* DOB: de tipo LocalDate, representa la fecha de nacimiento del jugador
* Altura: de tipo Integer, representa la altura del jugador
* Peso: de tipo Integer, representa el peso del jugador
* Club: de tipo Club, representa el club del jugador(contiene String equipo,integer socios e Integer titulos)
* Nacionalidad: de tipo String, representa el pais del jugador
* PieBueno: de tipo PieBUeno, representa el pie hábil del jugador
* Cara:de tipo boolean, representa si la cara del jugador es la real(en el juego)

**Constructores**: 

- C1: Recibe un parámetro por cada propiedad básica
- C2: Recibe nombre,la valoracion y el sueldo. El resto de propiedades toman el valor null

**Restricciones**:
 
- R1: No puede tener más valoración que potencial
- R2: La fecha de nacimiento no puede ser posterior a la actual
- R3: La posicion no puede estar 2 veces en la lista


**Criterio de igualdad**: Dos jugadores son iguales si tienen la misma edad

**Criterio de ordenación**: Los jugadores se ordenan en base a la edad

#### Tipos auxiliares-CLub
Representa el club del jugador.

Compara los equipos.

**Restricciones**:
- R1:

### Factoría
Descripción breve de la factoría.

-leeJugadores: através de lafunción parsea jugador, lee un csv y crea una lista con los jugadores ya con sus atributos del tipo correcto y le da el metodo EquipoBucles o EquipoStreams.
-parseaJugador: parsea los atributos del jugador a los tipos correctos..

### Tipo Contenedor

El tipo contenedor es un club que constará con una serie de jugadores(integrantes), la liga en la que juegan, si juegan o no la champions y su posicion en liga..

**Propiedades**:

List<Jugador> jugadores, lista con los jugadores
Liga liga, enum con la liga en que juegan
Boolean ucl, True si juegan ucl y false en caso contrario
 Integer posicionLiga, la posicion del equipo en Liga.
**Constructores**: 

- C1: Todos los elementos menos la lista, la cual se inicializará vacía..
- C2: Todos los elementos, incluidos la lista ya con unos jugadores..
- C3: Todos los elementos(streams)
- C4: Solo el Stream.
- ...

**Restricciones**:
.
- ...
- 
**Criterio de igualdad**: Compara todos los elementos.d

**Criterio de ordenación**:.

**Otras operaciones**:
 
-existeJugadorConEdad: Comprueba si existe un jugador con una edad dada.

-mediaEdad: Calcula la media de la edad de los futbolistas.

-filtraPieBueno: Hace una selección con los jugadores que sean hábiles con un pie.

-agrupaPieBueno: Agrupa en un mapa a los jugadores diestros en una clave y a los zurdos en la otra.

-cuentaPieBueno: Cuenta los jugadores diestros y los zurdos y los mete en un map..

-maxalturadeEquipo: Jugador mas alto de un equipo dado.

-ordenaEquipoPorAltura: Ordena un equipo dado por la altura.

-mapJuagdoresClubes: Hace un mapa con los clubes y sus jugadores.

-edadMasAltaPorClub:  Muestra la edad del jugador más mayor de cada equipo.

-masAltosSegunPierna: Da un número a elegir de los jugadores más altos según su pierna hábil.

-getEquipoConMenorSueldo: Da al equipo que tenga el jugador con menor sueldo.
