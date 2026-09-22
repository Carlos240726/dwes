package src.main.java.org.colecciones;

import src.main.java.org.colecciones.entidades.Book;
import src.main.java.org.colecciones.entidades.BookCollection;

import java.util.ArrayList;

public class App
{
    public static void main( String[] args )
    {
        ArrayList<Book> libros =new ArrayList<>();
        libros.add(new Book("9788422616337", "El Señor de los Anillos", "J.R.R. Tolkien", 800));
        libros.add(new Book("9788445077528", "El Hobbit", "J.R.R. Tolkien", 350));
        libros.add(new Book("9788466316781", "Cabo Trafalgar", "Arturo Pérez Reverte", 320));
        libros.add(new Book("9788493975074", "El corazón de la piedra", "José María García López", 560));
        libros.add(new Book("9788493291488", "Salmos de vísperas", "Esteban Hernández Castelló", 95));
        libros.add(new Book("9788420685625", "La música en las catedrales españolas del Siglo de Oro", "Robert Stevenson", 600));
        libros.add(new Book("9788423913077", "Luces de bohemia", "Ramón del Valle-Inclán", 296));
        libros.add(new Book("9788448031121", "Contando atardeceres", "La vecina rubia", 528));
        libros.add(new Book("9781529342079", "The Master: The Brilliant Career of Roger Federer", "Christopher Clarey", 456));
        libros.add(new Book("9788408264385", "La teoría de los archipiélagos", "Alice Kellen", 300));
        libros.add(new Book("9788423362479", "Esperando al diluvio", "Dolores Redondo", 576));
        libros.add(new Book("9788466367349", "El italiano", "Arturo Pérez Reverte", 400));
        libros.add(new Book("9788466359290", "Línea de fuego", "Arturo Pérez Reverte", 688));

        BookCollection.mas_500_paginas(libros);
        BookCollection.mas_300_paginas(libros);
        BookCollection.mas_500_paginas_listado(libros);
        BookCollection.mayor_cantidad_paginas(libros);
        BookCollection.suma_paginas_total(libros);
        BookCollection.superior_paginas_promedio(libros);
        BookCollection.autores(libros);
        BookCollection.autores_libros(libros);
        BookCollection.libro_mas_paginas(libros);
        BookCollection.todos_libros_titulos(libros);
        BookCollection.ordenar_libros(libros);
    }
}