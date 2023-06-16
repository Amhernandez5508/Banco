package hernandez.alejandro.productosbancarios.entity;

public class CuentaCorriente extends Producto{

	public CuentaCorriente(int banco, int sucursal) {
		super(banco, sucursal);
	}
	
	@Override
	public void imprimirNumeroProducto() {
		System.out.println(String.format("CC-%d-%d/%d", super.banco, super.sucursal, super.numeroProducto));		
	}

	@Override
	public String toString() {
		return "CuentaCorriente [numeroProducto=" + numeroProducto + ", banco=" + banco + ", sucursal=" + sucursal
				+ "]";
	}
	
	
}
