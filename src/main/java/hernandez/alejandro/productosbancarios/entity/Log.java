package hernandez.alejandro.productosbancarios.entity;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class Log {
	private int id;
	private LocalDateTime fecha;
	private String clase;
	private String producto;
	private String descripcion;
	
	public Log(String clase, String producto, String descripcion) {
		this.fecha = LocalDateTime.now();
		this.clase = clase;
		this.producto = producto;
		this.descripcion = descripcion;
	}

	public LocalDateTime getFecha() {
		return fecha;
	}

	public String getClase() {
		return clase;
	}

	public String getProducto() {
		return producto;
	}

	public String getDescripcion() {
		return descripcion;
	}
}
