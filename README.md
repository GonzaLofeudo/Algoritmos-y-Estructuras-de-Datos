# Algoritmos y Estructuras de Datos en Java

Repositorio académico desarrollado durante la materia **Algoritmos y Estructuras de Datos** de la Licenciatura en Sistemas de la Universidad Nacional de La Plata (UNLP).

Incluye resoluciones en Java y consignas de las prácticas 1, 2, 3 y 5. Los materiales de clase y la Práctica 4 se conservan localmente, pero están excluidos del repositorio mediante `.gitignore`.

## Organización

Cada práctica es un proyecto Java independiente que puede importarse en Eclipse. Dentro de cada `src/`, los paquetes tienen nombres homogéneos: `ejercicio1`, `ejercicio2`, etc.

```text
.
├── practica-1/
│   ├── consigna/
│   ├── material/
│   └── src/ejercicio1 ... ejercicio9
├── practica-2/
│   ├── consigna/
│   ├── material/
│   └── src/ejercicio1, ejercicio3 ... ejercicio7
├── practica-3/
│   ├── consigna/
│   ├── material/
│   └── src/ejercicio1, ejercicio2, ejercicio4, ejercicio6, ejercicio7, ejercicio9
├── practica-4/                  # Sólo local, ignorada por Git
└── practica-5/
    ├── consigna/
    ├── material/
    └── src/ejercicio1 ... ejercicio8
```

Algunas clases concentran varios ejercicios porque las consignas piden extender progresivamente la misma estructura:

- `practica-2/src/ejercicio1/BinaryTree.java` contiene la estructura del ejercicio 1 y los métodos agregados en el ejercicio 2.
- `practica-2/src/ejercicio7/ParcialArboles.java` reúne los ejercicios 7, 8 y 9.
- `practica-3/src/ejercicio1/GeneralTree.java` parte del ejercicio 1 e incorpora los métodos pedidos en los ejercicios 3 y 5.
- `practica-3/src/ejercicio9/ParcialArboles.java` reúne ejercicios de parciales posteriores al ejercicio 9.
- No hay implementación para `Navidad`, correspondiente al ejercicio 8 de la Práctica 3.

## Contenidos

### Práctica 1: fundamentos de Java

Estructuras de control, recursión, arreglos, listas, orientación a objetos, herencia, pasaje de parámetros, colas genéricas y balanceo mediante pilas.

### Práctica 2: árboles binarios

Árbol binario genérico, recorridos, conteo de hojas, espejo, procesamiento por niveles, números pares, profundidad, caminos máximos y transformaciones.

### Práctica 3: árboles generales

Árbol general genérico, recorridos en profundidad y por niveles, altura, nivel, ancho, ancestros, análisis de jerarquías, caudal mínimo y caminos a hojas.

### Práctica 5: grafos

TDA de grafo, representaciones con listas y matrices de adyacencia, DFS, BFS, caminos con restricciones, Dijkstra, Floyd y aplicaciones sobre redes. Incluye dos suites JUnit para las implementaciones de grafos.

## Eclipse

Requisitos:

- JDK 21.
- Eclipse IDE con soporte Java.
- JUnit 5 para `AyED-Practica-5`.

Para importar los proyectos:

1. Si todavía aparece el antiguo proyecto único `AyED`, quitarlo del workspace sin seleccionar la opción de borrar su contenido del disco.
2. Abrir **File > Import > General > Existing Projects into Workspace**.
3. Seleccionar la carpeta raíz del repositorio.
4. Activar **Search for nested projects**.
5. Importar `AyED-Practica-1`, `AyED-Practica-2`, `AyED-Practica-3` y `AyED-Practica-5`.

`AyED-Practica-3` declara una dependencia con `AyED-Practica-1` porque reutiliza la cola genérica del ejercicio 8.

## Compilación desde terminal

Cada práctica puede compilarse por separado. La Práctica 3 necesita primero la salida compilada de la Práctica 1:

```bash
mkdir -p out/practica-1 out/practica-2 out/practica-3 out/practica-5

find practica-1/src -name '*.java' -print0 \
  | xargs -0 javac -encoding UTF-8 -d out/practica-1

find practica-2/src -name '*.java' -print0 \
  | xargs -0 javac -encoding UTF-8 -d out/practica-2

find practica-3/src -name '*.java' -print0 \
  | xargs -0 javac -encoding UTF-8 -cp out/practica-1 -d out/practica-3

find practica-5/src -name '*.java' ! -name '*GraphTest.java' -print0 \
  | xargs -0 javac -encoding UTF-8 -d out/practica-5
```

Por ejemplo:

```bash
java -cp out/practica-1 ejercicio1.Main
```

Las pruebas de la Práctica 5 se ejecutan directamente desde Eclipse con **Run As > JUnit Test**.

## Estado

- Las cuatro prácticas compilan sin errores ni advertencias.
- Las 20 pruebas JUnit de grafos pasan correctamente.
- La Práctica 1 contiene nueve paquetes de ejercicios.
- La Práctica 2 contiene implementaciones de los nueve ejercicios, con algunos agrupados en clases compartidas.
- La Práctica 3 no contiene una implementación del ejercicio 8.
- La Práctica 5 contiene los ocho ejercicios y una resolución adicional de parcial en el paquete `parcial`.

## Autoría y material académico

El repositorio combina resoluciones del estudiante con clases base, interfaces, pruebas, consignas y diapositivas proporcionadas por la cátedra. Los archivos originales no siempre contienen información suficiente para separar de forma concluyente cada autoría. Se reconoce expresamente el aporte de la cátedra de Algoritmos y Estructuras de Datos de la UNLP y el material se conserva como contexto académico de las implementaciones.

En Git se conservan los PDFs de `consigna/`. Los PDFs ubicados en `material/` permanecen disponibles en la copia local, pero no se publican.

El proyecto externo `Practica1`, que contiene ejemplos separados de la cátedra, no fue incorporado.
