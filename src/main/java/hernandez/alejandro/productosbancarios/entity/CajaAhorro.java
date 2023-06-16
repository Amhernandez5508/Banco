package hernandez.alejandro.productosbancarios.entity;

import hernandez.alejandro.productosbancarios.exceptions.ExcepcionProducto;

public class CajaAhorro extends Producto{

	public CajaAhorro(int banco, int sucursal){
		super(banco, sucursal);
	}
	
	@Override
	public void imprimirNumeroProducto() {
		System.out.println(String.format("CA-%d-%d/%d", super.banco, super.sucursal, super.numeroProducto));
	}

	
	@Override
	public String toString() {
		return "CuentaCorriente [numeroProducto=" + numeroProducto + ", banco=" + banco + ", sucursal=" + sucursal
				+ "]";
	}
}
