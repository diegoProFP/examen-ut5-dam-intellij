package torneo.marcobrihuega;

import torneo.base.DatosInvalidosException;
import torneo.base.Partido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5, y existe desde la 1.0

/**
 * Esta es una clase en la cual se gestionan varias cosas de un toreno con sus equipos, partidos, etc
 * @author marco.brihuega@educa.madrid.org
 * @version 1.5
 * @since 1.0
 */
public class Torneo {
	
    private String nombre;
    private List<Partido> partidos = new ArrayList<>();

    // Poner descripcion, parametros de entrada, valor de retorno, y en qué condiciones se produce la excepción. Además que pueda
 	// referenciar tanto a las clases Partido y DatosInvalidosException
 	//Existe desde la version 1.0

    /**
     * Este metodo agrega un nuevo partido
     * @param nuevo es un partido nuevo para añadir un parito
     * @return devuelve un boleano dependiendo si puede añadirlo o no
     * @throws DatosInvalidosException si encuentra algun partido o equipo nulo lanza la excepcion
     * @since 1.0
     * @see torneo.marcobrihuega.Partido
     * @see torneo.marcobrihuega.DatosInvalidosException
     * */
    public boolean agregarPartido(Partido nuevo) throws DatosInvalidosException {
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

    /**
     *Este metodo encuentra partidos por el nombre de locales y visitantes
     * @param local es el nombre del equipo local
     * @param visitante es el nombre del equipo visitanto
     * @return devuleve un boleano si encuentra el partido
     * @since 1.0
     */
    public boolean encontrarPartidoPorEquipos(String local, String visitante) {
        for (Partido partido : partidos) {
            if (partido.getEquipoLocal().equalsIgnoreCase(local) && partido.getEquipoVisitante().equalsIgnoreCase(visitante)) {
                return true;
            }
        }
        return false;
    }

    // Este metodo está deprecado porque se ha hecho uno mejor, y el que lo sustituye es el
   	// encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante)
   	//Existe desde la version 1.2

    /**
     * Este metodo encuentra partidos por fecha
     * @deprecated  {@link  #encontrarPartidos(Date, String, String)}
     * @since 1.2
     * @param fecha es un dato tipo fecha con el cual podremos buscar partido por la fecha
     * @return devuleve un boleano si lo encuentra por esa fecha o no
     */
    public boolean encontrarPartidoPorFecha(Date fecha) {
        for (Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    // Poner descripcion, parametros de entrada, valor de retorno.
 	//Existe desde la version 1.5

    /**
     * Este metodo encuentra partido por fechas y nombres de equipos
     * @param fecha la fecha en la cual queremos buscar el partdio
     * @param equipoLocal el nombre del equipo local para buscar
     * @param equipoVisitante el nombre del equipo visitante para buscar
     * @return devuelve una lista de tipo Partido
     * @since 1.5
     */
    public List<Partido> encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante) {
        List<Partido> resultados = new ArrayList<>();
        for (Partido partido : partidos) {
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

    public List<Partido> getPartidos() {
        return partidos;
    }

    public void setPartidos(List<Partido> partidos) {
        this.partidos = partidos;
    }
}
