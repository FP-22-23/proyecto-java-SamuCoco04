# Proyecto del Segundo Cuatrimestre Fundamentos de Programación (Curso  22/23)
Autor/a: Alberto José Paleteiro López   uvus:STX3837


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

- _método 1_: Descripción del método 1.
-	_método 2_: Descripción del método 2.

### Tipo Contenedor

Descripción breve del tipo contenedor.

**Propiedades**:

- _propiedad1_, de tipo \<Tipo1\>, consultable. 
- _propiedad2_, de tipo \<Tipo2\>, consultable y modificable. 
- ...
- 
**Constructores**: 

- C1: Descripción del constructor 1.
- C2: Descripción del constructor 2.
- ...

**Restricciones**:
 
- R1: Descripción de la restricción 1.
- R2: Descripción de la restricción 2.
- ...
- 
**Criterio de igualdad**: Describir el criterio de igualdad

**Criterio de ordenación**: Describir el criterio de ordenación (si lo hay).

**Otras operaciones**:
 
-	_método 1_: Descripción del método 1.
- ...
