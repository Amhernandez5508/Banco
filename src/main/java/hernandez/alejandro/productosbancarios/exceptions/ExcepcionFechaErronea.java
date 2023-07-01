package hernandez.alejandro.productosbancarios.exceptions;

public class ExcepcionFechaErronea extends Exception {
	private static final long serialVersionUID = 1L;
	private int codigo;
	
	public ExcepcionFechaErronea(int codigo) {
		this.codigo = codigo;
	}
	
	public String getMessage(int codigo) {
		switch (codigo) {
			case 1:
				return "Solo se permiten numeros y guiones.\n";
			
			case 2:
				return "No se permiten espacios.\n";
			
			case 3:
				return "Para el dia debe ingresar un valor entre 1 y 31. Asegurese que esta ingresando la fecha con el formato DD-MM-AAAA\"\n";
			
			case 4:
				return "Para el mes debe ingresar un valor entre 1 y 12. Asegurese que esta ingresando la fecha con el formato DD-MM-AAAA\"\n";
				
			case 5:
				return "Formato invalido. Favor de ingresar la fecha con el siguiente formato: DD-MM-AAAA\"\n";
			
			default:
				return "";				
		}
	}

	public int getCodigo() {
		return codigo;
	}
	
	

}
