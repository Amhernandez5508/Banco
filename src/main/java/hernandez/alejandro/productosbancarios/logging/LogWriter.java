package hernandez.alejandro.productosbancarios.logging;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import hernandez.alejandro.productosbancarios.entity.Log;

public class LogWriter {
	
	public static void write(Log log) {
		File archive = new File("log.txt");
		try ( BufferedWriter bw = new BufferedWriter( new FileWriter(archive, true) )) {
			bw.write(log.getFecha().toString() + " " + log.getClase() + ": " + log.getDescripcion() + " - Registrado en la tabla \"log\" con ID [" + log.getID() + "]");
			bw.newLine();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
