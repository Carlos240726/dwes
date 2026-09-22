package src.main.java.org.colecciones.entidades;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;

public class BookCollection{
    // ¿Qué tipo de colección es la más adecuada para almacenar los libros?



    // Crea los métodos solicitados en el enunciado del ejercicio

    public static void mas_500_paginas(ArrayList<Book> libros){
        //int contador=0;
        long contador =  libros.stream().filter(libro -> libro.pages() > 500).count();
        /*libros.forEach(libro -> {
            if (libro.pages()>500){
                contador++;
            }
        });*/
        /* No funcionaba de la otra manera, pedia que la estructura fuera asi AtomicInteger contador = new AtomicInteger(0);
           libros.forEach(libro -> {
                if (libro.pages() > 500) {
                   contador.incrementAndGet();
               }
            });*/
        System.out.println("Hay " + contador + " libros con mas de 500 paginas");
    }

    public static void mas_300_paginas(ArrayList<Book> libros){
        long contador =  libros.stream().filter(libro -> libro.pages() > 300).count();
        System.out.println("Hay " + contador + " libros con mas de 300 paginas");
    }

    public static void mas_500_paginas_listado(ArrayList<Book> libros){
        AtomicInteger contador = new AtomicInteger(0);
        AtomicReference<String> titulo = new AtomicReference<>("");
        libros.forEach(libro -> {
            if (libro.pages()>500){
                titulo.set(libro.title());
                System.out.println(" El libro " + titulo + " tiene mas de 500 paginas");
            }
        });
    }
    public static void mayor_cantidad_paginas(ArrayList<Book> libros){
        libros.stream().filter(libro -> libro.pages() > 500).sorted(Comparator.comparing(Book::pages).reversed()).limit(3).map(libro -> libro.title() + " es uno de los tres libros con mas paginas").forEach(System.out::println);
    }

    public static void suma_paginas_total (ArrayList<Book> libros){
        int paginas =libros.stream().mapToInt(Book::pages).sum();
        System.out.println("El numero total de paginas es " + paginas);
    }

    public static void superior_paginas_promedio (ArrayList<Book> libros){
        int paginas =libros.stream().mapToInt(Book::pages).sum();
        int promedio = Math.toIntExact(paginas / libros.stream().count());
        libros.stream().filter(libro -> libro.pages() > promedio).map(libro -> libro.title() + " es uno de los libros cuya cantidad de paginas supera el promedio").forEach(System.out::println);
    }

    public static void autores (ArrayList<Book> libros){
        libros.stream().map(libro -> libro.author()).distinct().forEach(System.out::println);
    }
    public static void autores_libros (ArrayList<Book> libros){
        System.out.println("Autores con mas de un libro");
        String[] autor = libros.stream().map(libro -> libro.author()).toArray(String[]::new);
        libros.stream().map(libro -> libro.author()).filter(autores -> Collections.frequency(Arrays.asList(autor),autores)>1).distinct().forEach(System.out::println);
    }
    public static void libro_mas_paginas(ArrayList<Book> libros){
        libros.stream().filter(libro -> libro.pages() > 500).sorted(Comparator.comparing(Book::pages).reversed()).limit(1).map(libro -> libro.title() + " es el libros con mas paginas").forEach(System.out::println);
    }
    public static void todos_libros_titulos (ArrayList<Book> libros){
        ArrayList<String> titulos = libros.stream().map(libro -> libro.title()).collect(Collectors.toCollection(ArrayList::new));
        System.out.println(titulos);
    }
    public static void ordenar_libros (ArrayList<Book> libros){
        libros.sort(null);
        for (Book libro : libros){
            System.out.println(libro.title());
        }
    }
}
