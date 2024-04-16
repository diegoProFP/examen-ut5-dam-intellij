package torneo.base;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Clase compuesta por un nombre y una lista que permite llevar el control del torneo
 * @author libertobaltasar1
 * @version 1.5
 * @since 1.0
 */
public class Torneo {
	
    private String nombre;
    private List<Partido> partidos = new ArrayList<>();

    /**
     * Sirve para añadir partidos.
     * @param nuevo es un objeto de tippo partido que se desea añadir al torneo
     * @return Si se introducen datos inválidos arroja una excepción, si el partido no existe lo añade y devuelve un true, si sí existe devuelve false
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
     * Busca en los partidos disputados si ya se han enfrentado los dos jugadores.
     * @param local nombre del jugador local
     * @param visitante nombre del jugador visitante
     * @return  Si ya han jugado devulve true, si no devuelve false
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
     * Sirve para encontrar partidos.
     * @param fecha
     * @return devuelve true si lo encuentra y false si no.
     * @deprecated
     * @link Torneo.encontrarPartidos()
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
     * Busca los partidos a partir de los parámetros de entrada
     * @param fecha
     * @param equipoLocal nombre del equipo local
     * @param equipoVisitante nombre del equipo visitante
     * @return Una lista con los partidos que coincidan con los datos introducidos
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
