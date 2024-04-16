package torneo.ivanperez35;

import torneo.base.DatosInvalidosException;
import torneo.base.Partido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5, y existe desde la 1.0

/**
 * Esta clase gestiona el torneo, gestionando los partidos, agregandolos, encontrandolos, etc.
 * @author ivan.perez35@educa.madrid.org
 * @version 1.5
 * @since 1.0
 */
public class Torneo {
	
    private String nombre;
    private List<torneo.base.Partido> partidos = new ArrayList<>();

    // Poner descripcion, parametros de entrada, valor de retorno, y en qué condiciones se produce la excepción. Además que pueda
 	// referenciar tanto a las clases Partido y DatosInvalidosException
 	//Existe desde la version 1.0
    public boolean agregarPartido(torneo.base.Partido nuevo) throws torneo.base.DatosInvalidosException {

        /**
         * Este método se encarga de agregar los partidos al torneo
         * @param nuevo el parámetro es un objeto de partido
         * @return el método devuelve un boolean, un false por defecto
         * @throw Lanza un excepción perteneciente de la clase DatosInvalidos
         * @see En el parámetro aparece la clase pártido
         * @see En la excepción aparece la clase DatosInvalidos
         * @since 1.0
         */
        if (nuevo == null || nuevo.getEquipoLocal() == null || nuevo.getEquipoVisitante() == null) {
            throw new DatosInvalidosException("El partido o alguno de los equipos es nulo");
        }

        boolean existePartido = this.encontrarPartidoPorEquipos(nuevo.getEquipoLocal(), nuevo.getEquipoVisitante());
        if (!existePartido) {
            return partidos.add(nuevo);
        }

        return false;
    }

    // Poner descripcion, parametros de entrada, valor de retorno.
   	//Existe desde la version 1.0
    public boolean encontrarPartidoPorEquipos(String local, String visitante) {

        /**
         * Esta clase se encarga de encontrar partidos, con un equipo local y un equipo visitante
         * @param local le pasamos un string con el nombre del equipo local
         * @param visitante le pasamos un string con el nombre del equipo visitante
         * @return devuelve un boolean, un false por defecto
         * @since 1.0
         */
        for (torneo.base.Partido partido : partidos) {
            if (partido.getEquipoLocal().equalsIgnoreCase(local) && partido.getEquipoVisitante().equalsIgnoreCase(visitante)) {
                return true;
            }
        }
        return false;
    }

    // Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
   	// encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante)
   	//Existe desde la version 1.2
    public boolean encontrarPartidoPorFecha(Date fecha) {

        /**
         * Este método se encarga de encontrar un partido a través de una fecha por entrada
         * @deprecated metodo cambiado por una nueva version "encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante)"
         * @param fecha recibe una fecha por entrada para buscar un partido
         * @return devuelve un boolean, un false por defecto
         * @since 1.2
         */
        for (torneo.base.Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    // Poner descripcion, parametros de entrada, valor de retorno.
 	//Existe desde la version 1.5
    public List<torneo.base.Partido> encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante) {

        /**
         * Este método se encarga de devolver los resultados de los partidos
         * @param fecha le llega por entrada una fecha del partio que le pasemos
         * @param equipoLocalle pasamos además el nombre del equipo local
         * @param equipoVisitante le pasamos además el nombre del equipo visitante
         * @return devuelve un partido dentro del ArrayList resultados
         * @since 1.5
         */
        List<torneo.base.Partido> resultados = new ArrayList<>();
        for (torneo.base.Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha) &&
                partido.getEquipoLocal().equalsIgnoreCase(equipoLocal) &&
                partido.getEquipoVisitante().equalsIgnoreCase(equipoVisitante)) {
                resultados.add(partido);
            }
        }
        return resultados;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<torneo.base.Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
}
