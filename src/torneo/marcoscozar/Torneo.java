package torneo.diegodi1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


//Poner comentario de la clase, con la descripción de qué es lo que hace  
//De autor poned vuestro email de educaMadrid. 
//La version de la clase es la 1.5, y existe desde la 1.0
public class Torneo {
    /**
     * Esta clase se utiliza para revistar información sobre los torneos y sus partidos. Utiliza métodos de las demás clases para agregar, encontrar partidos
     * o incluso revisar y cambiar sus nombres.
     * @author marcos.cozar@educa.madrid.org
     * @version 1.5
     * @since 1.0
     */

    private String nombre;
    private List<Partido> partidos = new ArrayList<>();

    // Poner descripcion, parametros de entrada, valor de retorno, y en qué condiciones se produce la excepción. Además que pueda
 	// referenciar tanto a las clases Partido y DatosInvalidosException
 	//Existe desde la version 1.0

    /**
     * Se utiliza para agregar partidos. Dentro del método, existe otro llamado ExistePartido para comprobar que un partido exista
     * previo a crearlo.
     * @since 1.0
     * @see torneo.base.Partido
     * @see torneo.base.DatosInvalidosException
     * @param nuevo Crea una variable para agregar un partido nuevo.
     * @return booleano
     * @throws DatosInvalidosException Existe en el caso que uno de los equipos creados sea nulo.
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

    // Poner descripcion, parametros de entrada, valor de retorno.
   	//Existe desde la version 1.0

    /**
     * Se utiliza para encontrar un partido por medio del nombre de los equipos local y visitante.
     * @param local Nombre del equipo local
     * @param visitante Nombre del equipo visitante
     * @return booleano
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
     * @since 1.2
     * @deprecated encontrarPartidos(Date fecha, String equipoLocal, String equipoVisitante)
     * @param fecha Busca partidos por la fecha
     * @return booleano
     *
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
     * Encuentra partidos mediante su fecha y el nombre de los equipos participantes. Muestra el resultado.
     * @since 1.5
     * @param fecha El dia en el que se realizó el partido
     * @param equipoLocal Nombre del equipo local
     * @param equipoVisitante Nombre del equipo visitante
     * @return resultados
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
