package sistema;

import java.util.ArrayList;
import java.time.LocalDateTime;

public class SistemaReservasDeportivas {
	
	GestionarIluminacion data = new GestionarIluminacion();
	private static final int MAX_PISTAS = 10; // Asumimos un máximo de 10 pistas

	    /**
	     * Constructor que inicializa las reservas y las luces de las pistas
	     */

	    public SistemaReservasDeportivas() {

	        data.reservas = new ArrayList<>();

	        data.iluminacion = new boolean[getMaxPistas()];

	    }

	    /**
	     * Reservar una pista en una fecha específica con una duración concreta
	     * @param reserva contiene la pista, la fecha y la duración de la reserva
	     * @return true si la reserva se ha realizado correctamente, false si la pista ya está reservada
	     */

	    public boolean reservarPista(Reserva reserva) {

	        int idPista = reserva.getIdPista();

	        LocalDateTime fecha = reserva.getFecha();

	        if (idPista < 0 || idPista >= getMaxPistas()) {

	            return false;

	        }

	        for (Reserva r : data.reservas) {

	            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {

	                return false;

	            }

	        }

	        data.reservas.add(reserva);

	        return true;

	    }

	    /**
	     * Cancelar una reserva
	     * @param idReserva identificador de la reserva a cancelar
	     * @return true si la reserva ha sido cancelada correctamente, false si no se ha encontrado la reserva
	     */

	    public boolean cancelarReserva(int idReserva) {

	        for (int i = 0; i < data.reservas.size(); i++) {

	            if (data.reservas.get(i).getIdPista() == idReserva) {

	                data.reservas.remove(i);

	                return true;

	            }

	        }

	        return false; // No se encontró la reserva

	    }

	    /**
	     * Verifica la disponibilidad de una pista en una fecha y hora concreta
	     * @param idPista de la pista
	     * @param fecha en la que se desea verificar la disponibilidad
	     * @param hora en la que se desea verificar la disponibilidad
	     * @return true si la pista está disponible, false si ya está reservada en esa fecha
	     */

	    public boolean verificarDisponibilidad(int idPista, LocalDateTime fecha, String hora) {

	    	if (idPista < 0 || idPista >= getMaxPistas()) {
	    		
	            return false;
	            
	        }

	        return esFechaDisponible(idPista, fecha);

	    }
	    
	    /**
	     * Verifica si una fecha y pista están disponibles para una reserva
	     * @param idPista de la pista
	     * @param fecha en la que se desea verificar la disponibilidad
	     * @return true si la pista está disponible, false si ya está reservada en esa fecha
	     */
	    
	    private boolean esFechaDisponible(int idPista, LocalDateTime fecha) {
	        
	    	for (Reserva r : data.reservas) {
	            if (r.getIdPista() == idPista && r.getFecha().equals(fecha)) {
	                return false; // La pista no está disponible en esa fecha
	            }
	        
	        }
	        
	        return true; // La pista está disponible
	        
	    }

		public static int getMaxPistas() {
			return MAX_PISTAS;
		}


}