# Trabajo Práctico - Streams en Java

## Descripción General
Este proyecto contiene la resolución de ejercicios prácticos sobre **Streams y programación funcional en Java**.  
El objetivo es aplicar operaciones como `filter`, `map`, `sorted`, `collect` y `groupingBy` para procesar colecciones de forma **declarativa y eficiente**.

---

## Instrucciones para ejecutar los ejercicios

1. Abrir el proyecto en **IntelliJ IDEA** o cualquier entorno Java compatible.  
2. Verificar que esté configurado **Java 8 o superior**.  
3. En el panel de archivos, abrir la clase **`Main.java`** (ubicada en la carpeta `src`).  
4. Ejecutar la clase con **Run → Run 'Main'** o presionando **Shift + F10**.  
5. Observar los resultados en la **consola de salida**.  
6. Cada bloque de impresión (`System.out.println`) corresponde a un caso práctico distinto.

---

## Descripción de los ejercicios

### Caso 1: Alumnos
**Clase:** `Alumno(nombre, nota, curso)`  
**Objetivos:**
- Filtrar alumnos aprobados (nota ≥ 7) y mostrar sus nombres en mayúsculas.  
- Calcular el promedio general de notas.  
- Agrupar alumnos por curso (`Collectors.groupingBy`).  
- Obtener los 3 mejores promedios.

**Conceptos aplicados:** `filter`, `map`, `sorted`, `limit`, `collect`.

---

### Caso 2: Productos
**Clase:** `Producto(nombre, categoria, precio, stock)`  
**Objetivos:**
- Mostrar productos con precio mayor a 100 ordenados por precio descendente.  
- Agrupar productos por categoría y calcular el stock total.  
- Generar una cadena con nombre y precio de cada producto (`joining`).  
- Calcular el precio promedio general y por categoría.

**Conceptos aplicados:** `filter`, `sorted`, `Collectors.groupingBy`, `summingInt`, `averagingDouble`, `joining`.

---

### Caso 3: Libros
**Clase:** `Libro(titulo, autor, paginas, precio)`  
**Objetivos:**
- Listar los títulos de libros con más de 300 páginas ordenados alfabéticamente.  
- Calcular el promedio de páginas de todos los libros.  
- Agrupar libros por autor y contar cuántos tiene cada uno.  
- Obtener el libro más caro.

**Conceptos aplicados:** `filter`, `map`, `sorted`, `Collectors.groupingBy`, `counting`, `max`.

---

### Caso 4: Empleados
**Clase:** `Empleado(nombre, departamento, salario, edad)`  
**Objetivos:**
- Listar empleados con salario mayor a 2000, ordenados por salario descendente.  
- Calcular el salario promedio general.  
- Agrupar empleados por departamento y sumar sus salarios.  
- Mostrar los nombres de los 2 empleados más jóvenes.

**Conceptos aplicados:** `filter`, `sorted`, `limit`, `Collectors.groupingBy`, `summingDouble`.

---

## Pruebas y resultados
Cada caso práctico incluye una lista de objetos predefinidos para probar las operaciones.  
Los resultados se imprimen en consola y muestran salidas como:
- Listas filtradas u ordenadas  
- Promedios o sumas  
- Agrupamientos por categorías o departamentos  

---

## Autor
**Candela Gonzalez**  
