package sistema;

import java.util.List;

public class GestionarIluminacion {
	public List<Reserva> reservas;
	public boolean[] iluminacion;

	public GestionarIluminacion() {
	}

	/**
	 * Enciende las luces de una pista
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista identificador de la pista de la que se desea encender las luces
	 * @return true si las luces se ha encendido correctamente, false si es inválido
	 */
	
	public boolean encenderLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.getMaxPistas()) {
	
	        return false;
	
	    }
	
	    iluminacion[idPista] = true;
	
	    return true;
	
	}

	/**
	 * Apaga las luces de una pista
	 * @param sistemaReservasDeportivas TODO
	 * @param idPista identificador de la pista de la que se desea apagar las luces
	 * @return true si las luces se han apagado correctamente, false si es inválido
	 */
	
	public boolean apagarLuces(SistemaReservasDeportivas sistemaReservasDeportivas, int idPista) {
	
	    if (idPista < 0 || idPista >= SistemaReservasDeportivas.getMaxPistas()) {
	
	        return false;
	
	    }
	
	    iluminacion[idPista] = false;
	
	    return true;
	
	}
}