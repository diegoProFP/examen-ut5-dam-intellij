package torneo.marcoramos2;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Clase que sirve para encapsular la informacion de los torneos y los partidos
 * @author marco.ramos2@educa.madrid.org
 * @version 1.5
 * @since 1.0
 */
public class Torneo {
	
    private String nombre;
    private List<Partido> partidos = new ArrayList<>();


    /**
     * Metodo para agregar un partido nuevo al torneo
     * @param nuevo Nuevo partido
     * @return true si se ha agregado el partido, false si ya esta agregado
     * @throws DatosInvalidosException
     * @see Partido
     * @see DatosInvalidosException
     * @since 1.0
     */
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

    /**
     * Metodo que itera por todos los partido hasta que encuentra el equipo indicado
     * @param local Equipo local
     * @param visitante Equipo visitante
     * @return true si existe el partido, false si no se encuentra el partido
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

    /**
     * Metodo para encontrar un partido en base a la fecha indicada
     * @param fecha Fecha del partido
     * @return true si encuentra el partido, false si no lo encuentra
     * @deprecated
     * @since 1.2
     */
    public boolean encontrarPartidoPorFecha(Date fecha) {
        for (Partido partido : partidos) {
            if (partido.getFechaPartido().equals(fecha)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Metodo para buscar partidos en base a los parametros dados
     * @param fecha fecha del partido
     * @param equipoLocal Nombre del equipo local
     * @param equipoVisitante Nombre del equipo visitante
     * @return List<Partidos>
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
