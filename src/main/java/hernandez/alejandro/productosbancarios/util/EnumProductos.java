package hernandez.alejandro.productosbancarios.util;

public enum EnumProductos {
	CA("Caja de Ahorro"), CC("Cuenta Corriente"), TC("Tarjeta de Credito"), FCI("Fondo Comun de Inversion"), PF("Plazo Fijo");
	
	String descripcion;
	
	private EnumProductos(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
	// ---------- Getters & Setters ----------
	
	public String getDescripcion() {
		return descripcion;
	}
}
