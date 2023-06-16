package hernandez.alejandro.productosbancarios.entity;

public abstract class Producto {
	private static int contador = 0; 
	protected int numeroProducto;
	protected int banco, sucursal;
	
	public Producto(){
	}
	
	public Producto(int banco, int sucursal) {
		this.banco = banco;
		this.sucursal = sucursal;
		numeroProducto = ++contador;
	}
	
	
	
	// ---------- Abstractas ----------
	
	public abstract void imprimirNumeroProducto();
	
	
	
	// ---------- Override ----------
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + banco;
		result = prime * result + numeroProducto;
		result = prime * result + sucursal;
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
		Producto other = (Producto) obj;
		if (banco != other.banco)
			return false;
		if (numeroProducto != other.numeroProducto)
			return false;
		if (sucursal != other.sucursal)
			return false;
		return true;
	}
	
	
		
	// ---------- Getters & Setters ----------
	
	public int getNumeroProducto() {
		return numeroProducto;
	}
	

	public int getBanco() {
		return banco;
	}
	
	public int getSucursal() {
		return sucursal;
	}	
}
