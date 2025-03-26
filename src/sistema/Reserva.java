package sistema;

public class Reserva {
	
	private int idPista;
    private String fecha;
    private int duracion;

    /**
     * Constructor que inicializa la reserva con la pista, fecha y duración
     * @param idPista identificador de la pista reservada
     * @param fecha en la que se realiza la reserva
     * @param duracion de la reserva en minutos
     */

    public Reserva(int idPista, String fecha, int duracion) {

    	this.idPista = idPista;

        this.fecha = fecha;

        this.duracion = duracion;

    }

    public int getIdPista() {

        return idPista;

    }

    public String getFecha() {

        return fecha;

    }

    public int getDuracion() {

        return duracion;

    }

}