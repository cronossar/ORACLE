public class Principal {
    public static void main(String[] args) {
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        System.out.println("SCREENMATCH - Todas tus peliculas en un solo lugar");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
        Pelicula miPelicula = new Pelicula();
        miPelicula.nombre = "Encanto";
        miPelicula.fechaDeLanzamiento = 2019;
        miPelicula.duracionEnMinutos = 120;
        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(7.8);
        miPelicula.evalua(10);
        System.out.println("La sumatoria de puntos de las evaluaciones para " + miPelicula.nombre + " es: " + miPelicula.sumaDeLasEvaluaciones);
        System.out.println("Evaluaciones realizadas: " + miPelicula.totalDeLasEvaluaciones);
        System.out.println("La media calculada de las evaluaciones es: " + miPelicula.calculaMedia());


        System.out.println("===================");

        Pelicula miPelicula2 = new Pelicula();
        miPelicula2.nombre = "Matrix";
        miPelicula2.fechaDeLanzamiento = 1998;
        miPelicula2.duracionEnMinutos = 130;
        miPelicula2.muestraFichaTecnica();
        miPelicula2.evalua(7.9);
        miPelicula2.evalua(8.6);
        miPelicula2.evalua(10);
        miPelicula2.evalua(9.5);
        System.out.println("La sumatoria de puntos de las evaluaciones para " + miPelicula2.nombre + " es: " + miPelicula2.sumaDeLasEvaluaciones);
        System.out.println("Evaluaciones realizadas: " + miPelicula2.totalDeLasEvaluaciones);
        System.out.println("La media calculada de las evaluaciones es: " + miPelicula2.calculaMedia());



    }
}
