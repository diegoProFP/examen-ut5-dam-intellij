package torneo.sergioponce2;

import torneo.base.DatosInvalidosException;
import torneo.base.Partido;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5, y existe desde la 1.0
/**
*
 * La Clase torneo almacena metodos para la gestion de un torneo
 * @author SergioPonce
 * @version 1.5
 * @since 1.0
* */
public class Torneo {
	
    private String nombre;
    private List<torneo.base.Partido> partidos = new ArrayList<>();

    // Poner descripcion, parametros de entrada, valor de retorno, y en qué condiciones se produce la excepción. Además que pueda
 	// referenciar tanto a las clases Partido y DatosInvalidosException
 	//Existe desde la version 1.0

    /**
     * Clase para crear nuevos partidos
     * @param nuevo
     * @return boolean
     * @throws torneo.base.DatosInvalidosException
     * @exception
     * @see torneo.sergioponce2.Partido
     * @see  torneo.sergioponce2.DatosInvalidosException
     * @since 1.0
     */
    public boolean agregarPartido(torneo.base.Partido nuevo) throws torneo.base.DatosInvalidosException {
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
     * busca y comprueba si existe el equipo visitante y local que se pasan
     * @param local String nombre de equipo
     * @param visitante String nombre de equipo
     * @return boolean
     * @since 1.0
     * */
    public boolean encontrarPartidoPorEquipos(String local, String visitante) {
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

    /***
     *
     * @deprecated  {@see encontrarPartidos}
     * @since 1.2
     */
    public boolean encontrarPartidoPorFecha(Date fecha) {
        for (torneo.base.Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    // Poner descripcion, parametros de entrada, valor de retorno.
 	//Existe desde la version 1.5

    /***
     * clase que segun los parametros introducidos encuentra el partido
     * @param fecha Date fecha del partido
     * @param equipoLocal String nombre de equipo
     * @param equipoVisitante String  nombre de equipo
     * @return List<Partido> resultados
     * @since 1.5
     */
    public List<torneo.base.Partido> encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante) {
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
