package torneo.base;

/**
 * Clase que controla la excepcion cuando se introducen datos no válidos.
 */
public class DatosInvalidosException extends Exception {
	/**
	 * Este método es una excepción propia (creada por el desarrollador del proyecto)
	 * @param mensaje
	 */
	public DatosInvalidosException(String mensaje) {
		super(mensaje);
	}
	

}
