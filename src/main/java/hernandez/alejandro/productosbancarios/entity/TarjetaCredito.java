package hernandez.alejandro.productosbancarios.entity;

import java.util.Random;

public class TarjetaCredito extends Producto{
	private short claveSeguridad;
	short[] numeros = new short[3];
	Random random = new Random();
	
	public TarjetaCredito(int banco, int sucursal) {
		super(banco, sucursal);
		
		claveSeguridad = (short)random.nextInt(100, 999);
	}
	
	@Override
	public void imprimirNumeroProducto() {
		if (numeros[0] == 0 ) {
			for( byte i = 0; i < numeros.length; i++ ) {
				numeros[i] = randomGen();
			}
		}
		
		System.out.println(String.format("TC-%d-%d-%d-%d", numeros[0], numeros[1], numeros[2], super.numeroProducto));		
	}

	@Override
	public String toString() {
		return "TarjetaCredito [claveSeguridad=" + claveSeguridad + ", numeroProducto=" + numeroProducto + ", banco="
				+ banco + ", sucursal=" + sucursal + "]";
	}
	
	private short randomGen() {
			return (short)random.nextInt(1000, 9999);
	}
	
}
