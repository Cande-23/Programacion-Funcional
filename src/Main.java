import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) {
        // ------------------ CASO 1: Alumnos ------------------
        List<Alumno> alumnos = Arrays.asList(
                new Alumno("Fernando", 8, "1A"),
                new Alumno("Juan", 6, "1A"),
                new Alumno("Candela", 9, "2B"),
                new Alumno("Maria", 7, "2B")
        );

        List<String> aprobados = alumnos.stream()
                .filter(a -> a.getNota() >= 7)
                .map(a -> a.getNombre().toUpperCase())
                .sorted()
                .collect(Collectors.toList());

        double promedioNotas = alumnos.stream()
                .mapToDouble(Alumno::getNota)
                .average()
                .orElse(0);

        Map<String, List<Alumno>> porCurso = alumnos.stream()
                .collect(Collectors.groupingBy(Alumno::getCurso));

        List<Alumno> top3 = alumnos.stream()
                .sorted(Comparator.comparingDouble(Alumno::getNota).reversed())
                .limit(3)
                .collect(Collectors.toList());

        System.out.println("Alumnos aprobados: " + aprobados);
        System.out.println("Promedio notas: " + promedioNotas);
        System.out.println("Alumnos por curso: " + porCurso);
        System.out.println("Top 3 alumnos: " + top3.stream().map(Alumno::getNombre).collect(Collectors.toList()));

        // ------------------ CASO 2: Productos ------------------
        List<Producto> productos = Arrays.asList(
                new Producto("Televisor", "Tecnología", 1200, 5),
                new Producto("Celular", "Tecnología", 50, 15),
                new Producto("Mesa", "Muebles", 300, 3),
                new Producto("Silla", "Muebles", 150, 10)
        );

        List<Producto> caros = productos.stream()
                .filter(p -> p.getPrecio() > 100)
                .sorted(Comparator.comparingDouble(Producto::getPrecio).reversed())
                .collect(Collectors.toList());

        Map<String, Integer> stockPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.summingInt(Producto::getStock)
                ));

        String listado = productos.stream()
                .map(p -> p.getNombre() + " " + p.getPrecio())
                .collect(Collectors.joining("; "));

        double promedioPrecio = productos.stream()
                .mapToDouble(Producto::getPrecio)
                .average()
                .orElse(0);

        Map<String, Double> promedioPorCategoria = productos.stream()
                .collect(Collectors.groupingBy(
                        Producto::getCategoria,
                        Collectors.averagingDouble(Producto::getPrecio)
                ));

        System.out.println("\nProductos caros: " + caros.stream().map(Producto::getNombre).collect(Collectors.toList()));
        System.out.println("Stock por categoría: " + stockPorCategoria);
        System.out.println("Listado de productos: " + listado);
        System.out.println("Precio promedio: " + promedioPrecio);
        System.out.println("Promedio por categoría: " + promedioPorCategoria);

        // ------------------ CASO 3: Libros ------------------
        List<Libro> libros = Arrays.asList(
                new Libro("Java Básico", "Autor A", 250, 40),
                new Libro("Java Avanzado", "Autor B", 400, 60),
                new Libro("Python", "Autor A", 320, 50),
                new Libro("C++", "Autor C", 500, 70)
        );

        List<String> titulosGrandes = libros.stream()
                .filter(l -> l.getPaginas() > 300)
                .map(Libro::getTitulo)
                .sorted()
                .collect(Collectors.toList());

        double promedioPaginas = libros.stream()
                .mapToInt(Libro::getPaginas)
                .average()
                .orElse(0);

        Map<String, Long> librosPorAutor = libros.stream()
                .collect(Collectors.groupingBy(
                        Libro::getAutor,
                        Collectors.counting()
                ));

        Optional<Libro> libroMasCaro = libros.stream()
                .max(Comparator.comparingDouble(Libro::getPrecio));

        System.out.println("\nLibros >300 páginas: " + titulosGrandes);
        System.out.println("Promedio páginas: " + promedioPaginas);
        System.out.println("Libros por autor: " + librosPorAutor);
        libroMasCaro.ifPresent(l -> System.out.println("Libro más caro: " + l.getTitulo() + " $" + l.getPrecio()));

        // ------------------ CASO 4: Empleados ------------------
        List<Empleado> empleados = Arrays.asList(
                new Empleado("Ignacio", "Ventas", 2500, 28),
                new Empleado("Marcela", "IT", 3000, 32),
                new Empleado("Claudio", "IT", 1800, 25),
                new Empleado("Marta", "Ventas", 2200, 30)
        );

        List<Empleado> altosSalarios = empleados.stream()
                .filter(e -> e.getSalario() > 2000)
                .sorted(Comparator.comparingDouble(Empleado::getSalario).reversed())
                .collect(Collectors.toList());

        double salarioPromedio = empleados.stream()
                .mapToDouble(Empleado::getSalario)
                .average()
                .orElse(0);

        Map<String, Double> totalPorDepto = empleados.stream()
                .collect(Collectors.groupingBy(
                        Empleado::getDepartamento,
                        Collectors.summingDouble(Empleado::getSalario)
                ));

        List<String> jovenes = empleados.stream()
                .sorted(Comparator.comparingInt(Empleado::getEdad))
                .limit(2)
                .map(Empleado::getNombre)
                .collect(Collectors.toList());

        System.out.println("\nEmpleados altos salarios: " + altosSalarios.stream().map(Empleado::getNombre).collect(Collectors.toList()));
        System.out.println("Salario promedio: " + salarioPromedio);
        System.out.println("Suma por departamento: " + totalPorDepto);
        System.out.println("2 empleados más jóvenes: " + jovenes);
    }
}
