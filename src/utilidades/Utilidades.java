package utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Utilidades {
	
	// Metodos

	public static String obtenerFechaActualFormateadoMDA() {
        // Obtener la fecha actual
        LocalDate fechaActual = LocalDate.now();

        // Crear un formateador de fecha para el formato mm/dd/yy
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yy");

        // Formatear la fecha actual utilizando el formateador
        String fechaFormateada = fechaActual.format(formatter);

        // Devolver la fecha actual en el formato especificado
        return fechaFormateada;
    }
}
