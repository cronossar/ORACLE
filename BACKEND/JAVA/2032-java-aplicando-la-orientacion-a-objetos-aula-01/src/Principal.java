import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

public class Principal {
    public static void main(String[] args) {
        System.out.println("ANALISIS DE PELICULAS");
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");
        Pelicula miPelicula = new Pelicula();
        miPelicula.setNombre("Encanto");
        miPelicula.setFechaDeLanzamiento(2021);
        miPelicula.setDuracionEnMinutos(180);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evalua(10);
        miPelicula.evalua(10);
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");


        System.out.println("Se han contabilizado: " + miPelicula.getTotalDelasEvaluaciones() + " evaluaciones de usuarios. ");
        System.out.println("La media obtenida en base a los puntajes es: " + miPelicula.calculaMedia());
        System.out.println("XXXXXXXXXXXXXXXXXXXXXXX");

        Serie casaDragon = new Serie();
        casaDragon.setNombre("La Casa del Dragón");
        casaDragon.setFechaDeLanzamiento(2023);
        casaDragon.setTemporadas(2);
        casaDragon.setMinutosPorEpisodio(45);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println("Duración total en minutos de todas las temporadas y capitulos: " + casaDragon.getDuracionEnMinutos() + " minutos ");

        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        System.out.println("Tiempo total de mi peli: " + miPelicula.getNombre() + " / " + calculadora.getTiempoTotal() + " minutos ");
        calculadora.incluye(casaDragon);
        System.out.println("Tiempo total de mi pelicula más la serie: " + calculadora.getTiempoTotal() + " minutos ");

    }
}
