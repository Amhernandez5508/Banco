package hernandez.alejandro.productosbancarios.exceptions;

public class ExcepcionProducto extends Exception {
	private static final long serialVersionUID = 1L;
	int codigo;
	
	public ExcepcionProducto(int codigo) {
		this.codigo = codigo;
	}
	
	public int getCodigo() {
		return codigo;
	}

	public String getMessage(int codigo) {
		switch (codigo) {
			case 1:
				return "Producto no disponible";
				
			case 2:
				return "Producto inexistente";
				
			default:
				return "Error";
		}
	}
	
	
}
