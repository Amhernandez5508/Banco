package hernandez.alejandro.productosbancarios.util;

import java.util.Comparator;

import hernandez.alejandro.productosbancarios.entity.Producto;

public class OrdenProductos implements Comparator<Producto> {

	public int compare(Producto o1, Producto o2) {
		if ( o1.getBanco() == o2.getBanco() ) {
			
			if ( o1.getSucursal() == o2.getBanco() ) {
				return o1.getNumeroProducto() - o2.getNumeroProducto();	
			} else {
				return o1.getSucursal() - o2.getSucursal();
			}
			
		} else {
			return o1.getBanco() - o2.getBanco();
		}
	}
}