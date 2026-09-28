//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
void main() {
    String consulta = "";

    System.out.println("---Primera consulta---");
    consulta = "SELECT nombre, especie FROM personajes";
    System.out.println(consulta);

    System.out.println("---Segunda conslta---");
    consulta="SELECT nombre FROM persojanes WHERE nivel_inteligencia > 80";
    System.out.println(consulta);

    System.out.println("---Tercera Consulta---");
    consulta = "Select descripcion FROM aventuras WHERE personaje_id = 3";
    System.out.println(consulta);

    System.out.println("---Cuarta Consulta---");
    consulta = "SELECT personajes.nombre, COUNT(descripcion) FROM aventuras INNER JOIN personajes ON aventuras.personaje_id = personajes.id GROUP BY personajes.nombre";
    System.out.println(consulta);

    System.out.println("---Quinta Consulta---");
    consulta = "SELECT nombre FROM personajes WHERE habilidad_especial LIKE 'Portal Gun'";
    System.out.println(consulta);

    System.out.println("---Sexta Consulta---");
    consulta = "SELECT personajes.nombre, COUNT(aventuras.planeta_id) AS planetas_visitados FROM aventuras INNER JOIN personajes ON aventuras.personaje_id = personajes.id INNER JOIN planetas ON aventuras.planeta_id = planetas.id GROUP BY personajes.nombre HAVING COUNT(aventuras.planeta_id) > 3";
    System.out.println(consulta);

    System.out.println("---Septima Consulta---");
    consulta = "SELECT personajes.nombre FROM aventuras INNER JOIN personajes ON aventuras.personaje_id = personajes.id INNER JOIN planetas ON aventuras.planeta_id = planetas.id WHERE planetas.afiliacion_gobierno = 'Federación Galáctica'";
    System.out.println(consulta);

    System.out.println("---Octava Contulta---");
    consulta = "SELECT AVG(nivel_inteligencia) FROM personajes INNER JOIN aventuras ON personajes.id = aventuras.personaje_id INNER JOIN planetas ON aventuras.planeta_id = planetas.id WHERE planetas.id = 7";
    System.out.println(consulta);
}
