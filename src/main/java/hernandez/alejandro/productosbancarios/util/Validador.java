package hernandez.alejandro.productosbancarios.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import hernandez.alejandro.productosbancarios.exceptions.ExcepcionFechaErronea;

public class Validador {
	public static boolean verificarFecha(String fecha) {
		try {
			if ( fecha.contains("!") || fecha.contains("/") || fecha.contains(".") || fecha.contains(",") || fecha.contains("@") ) {
				throw new ExcepcionFechaErronea(1);
				
			} else if ( fecha.contains(" ") ) {
				throw new ExcepcionFechaErronea(2);
				
			} else if ( fecha.length() != 10 ) {
				throw new ExcepcionFechaErronea(5);
				
			} else if ( Integer.parseInt( fecha.substring(0, 2) ) < 1 || Integer.parseInt( fecha.substring(0, 2) ) > 31 ) {
				throw new ExcepcionFechaErronea(3);//30-09-1991
				
			} else if ( Integer.parseInt( fecha.substring(3, 5) ) < 1 || Integer.parseInt( fecha.substring(3, 5) ) > 12 ) {
				throw new ExcepcionFechaErronea(4);
				
			} else {
				try {
					DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
					LocalDate.parse(fecha, dateFormatter);
					return true;
					
				} catch (DateTimeParseException e) {
					System.err.println("Formato invalido. Favor de ingresar la fecha con el siguiente formato: DD-MM-AAAA\n");
					return false;
					
				}
			}
			
		} catch (ExcepcionFechaErronea e) {
			System.err.println(e.getMessage(e.getCodigo()));
			return false;
		}
	}
}

