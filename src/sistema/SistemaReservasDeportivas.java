package sistema;

import java.util.ArrayList;
import java.util.List;

public class SistemaReservasDeportivas {
	
	private List<Reserva> reservas;
	private boolean[] iluminacion;
	private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

	    /**
	     * Constructor que inicializa las reservas y las luces de las pistas
	     */

	    public SistemaReservasDeportivas() {

	        reservas = new ArrayList<>();

	        iluminacion = new boolean[MAX_PISTAS];

	    }

	    /**
	     * Reservar una pista en una fecha específica con una duración concreta
	     * @param reserva contiene la pista, la fecha y la duración de la reserva
	     * @return true si la reserva se ha realizado correctamente, false si la pista ya está reservada
	     */

	    public boolean reservarPista(Reserva reserva) {

	        int idPista = reserva.getIdPista();

	        String fecha = reserva.getFecha();

	        if (idPista < 0 || idPista >= MAX_PISTAS) {

	            return false; // ID de pista inválido

	        }

	        for (Reserva r : reservas) {

	            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {

	                return false; // La pista ya está reservada en esa fecha

	            }

	        }

	        reservas.add(reserva);

	        return true;

	    }

	    /**
	     * Cancelar una reserva
	     * @param idReserva identificador de la reserva a cancelar
	     * @return true si la reserva ha sido cancelada correctamente, false si no se ha encontrado la reserva
	     */

	    public boolean cancelarReserva(int idReserva) {

	        for (int i = 0; i < reservas.size(); i++) {

	            if (reservas.get(i).getIdPista() == idReserva) {

	                reservas.remove(i);

	                return true;

	            }

	        }

	        return false; // No se encontró la reserva

	    }

	    /**
	     * Enciende las luces de una pista
	     * @param idPista identificador de la pista de la que se desea encender las luces
	     * @return true si las luces se ha encendido correctamente, false si es inválido
	     */

	    public boolean encenderLuces(int idPista) {

	        if (idPista < 0 || idPista >= MAX_PISTAS) {

	            return false; // ID de pista inválido

	        }

	        iluminacion[idPista] = true;

	        return true;

	    }

	    /**
	     * Apaga las luces de una pista
	     * @param idPista identificador de la pista de la que se desea apagar las luces
	     * @return true si las luces se han apagado correctamente, false si es inválido
	     */

	    public boolean apagarLuces(int idPista) {

	        if (idPista < 0 || idPista >= MAX_PISTAS) {

	            return false; // ID de pista inválido

	        }

	        iluminacion[idPista] = false;

	        return true;

	    }

	    /**
	     * Verifica la disponibilidad de una pista en una fecha y hora concreta
	     * @param idPista de la pista
	     * @param fecha en la que se desea verificar la disponibilidad
	     * @param hora en la que se desea verificar la disponibilidad
	     * @return true si la pista está disponible, false si ya está reservada en esa fecha
	     */

	    public boolean verificarDisponibilidad(int idPista, String fecha, String hora) {

	        if (idPista < 0 || idPista >= MAX_PISTAS) {

	            return false; // ID de pista inválido

	        }

	        for (Reserva r : reservas) {

	            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {

	                return false; // La pista no está disponible en esa fecha

	            }

	        }

	        return true; // La pista está disponible

	    }

}