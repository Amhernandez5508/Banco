package hernandez.alejandro.productosbancarios.entity;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class Cliente {
	Documento doc;
	String descripcion;
	LocalDate fechaNac;
	Producto[] listadoProductos;
	DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	public Cliente() {
		
	}
	
	public Cliente( String tipoDoc, String numDoc, String descripcion, String fechaNac, Producto[] listadoProductos ) {
		this.doc = new Documento( tipoDoc, numDoc );
		this.descripcion = descripcion;
		this.fechaNac = LocalDate.parse(fechaNac, dateFormatter);
		
		this.listadoProductos = new Producto[listadoProductos.length];
		for ( int i = 0 ; i < listadoProductos.length ; i++ ) {
			this.listadoProductos[i] = listadoProductos[i];
		}
	}
	
	
	
	// ----------- Override ----------
	
	@Override
	public String toString() {
		return "Descripcion: " + descripcion + ", Documento: " + doc.toString() + ", Fecha de nacimiento: " + fechaNac;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((doc == null) ? 0 : doc.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (doc == null) {
			if (other.doc != null)
				return false;
		} else if (!doc.equals(other.doc))
			return false;
		return true;
	}
	
	
	
	// ----------- Getters & Setters ----------

	public Documento getDocumento() {
		return this.doc;
	}

	public Producto[] getListadoProductos() {
		return listadoProductos;
	}
	
	
}