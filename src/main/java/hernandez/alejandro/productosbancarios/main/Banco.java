package hernandez.alejandro.productosbancarios.main;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import hernandez.alejandro.productosbancarios.entity.*;
import hernandez.alejandro.productosbancarios.exceptions.ExcepcionProducto;
import hernandez.alejandro.productosbancarios.util.EnumProductos;
import hernandez.alejandro.productosbancarios.util.OrdenProductos;
import hernandez.alejandro.productosbancarios.dao.impl.*;

public class Banco {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		byte seleccion;
		boolean isFinish = false;
		List<Producto> productosCreados = new ArrayList<Producto>();
		OrdenProductos ordenador = new OrdenProductos();
		Map<Documento, Cliente> clientesActivos = new HashMap<Documento, Cliente>();
		
		
		// Harcoding de listas de productos, clientes y lista de clientes.
		Producto[] listaProductos1 = { new CajaAhorro(001, 002), new CajaAhorro(026, 034), new CuentaCorriente(003, 124), new CuentaCorriente(026, 056) };
		Producto[] listaProductos2 = { new TarjetaCredito(027, 112), new CajaAhorro(034, 111), new TarjetaCredito(012, 002), new CuentaCorriente(017, 542) };
		Producto[] listaProductos3 = { new CuentaCorriente(043, 123), new CuentaCorriente(062, 304), new CuentaCorriente(300, 421), new TarjetaCredito(620, 650) };
		Producto[] listaProductos4 = { new CajaAhorro(100, 002), new TarjetaCredito(620, 430), new CuentaCorriente(300, 241), new CuentaCorriente(206, 560) };
		
		Cliente cliente1 = new Cliente("DNI", "36402915", "Alejandro Hernandez", "30-09-1991", listaProductos1);
		Cliente cliente2 = new Cliente("DU", "41235663", "Cosme Fulanito", "25-03-1976", listaProductos2);
		Cliente cliente3 = new Cliente("PA", "456581", "Giusepe Mausen", "02-12-1987", listaProductos3);
		Cliente cliente4 = new Cliente("DNI", "42011548", "Pepe Peposo", "15-07-2002", listaProductos4);
		
		clientesActivos.put(cliente1.getDocumento(), cliente1);
		clientesActivos.put(cliente2.getDocumento(), cliente2);
		clientesActivos.put(cliente3.getDocumento(), cliente3);
		clientesActivos.put(cliente4.getDocumento(), cliente4);
		// Fin Harcoding.
		
		System.out.print(   "Accediendo a sistema bancario...\n"
							+ "\n1)_ Portal de administrador."
							+ "\n2)_ Portal de usuario."
							+ "\n\nIngrese la opcion correspondiente: ");
		seleccion = input.nextByte();
		
		switch (seleccion) {
			case 1:
				System.out.println("\n\n-------------------");
				System.out.println("** ADMINISTRADOR **");
				System.out.println("-------------------\n\n");
				
				do {
					System.out.println("\n\n\n\n\n\n\n_____________________________");
					System.out.print("--Menu de operacion--"
							+ "\n1)_ Imprimir log de errores."
							+ "\n2)_ Salir."
							+ "\n\nIngrese la opcion deseada: ");
					seleccion = input.nextByte();
					
					switch (seleccion) {
						case 1:
							LogDTO lDTO = new LogDTO();
							lDTO.select();
							break;
							
						case 2:
							seleccion = -1;
							break;
					}
				} while (seleccion >= 1 && seleccion <= 2);
				break;
			
			case 2:
				System.out.println("-----------------------------");
				System.out.println("** BIENVENIDO A HOMEBANKIG **");
				System.out.println("-----------------------------");
				
				do {
					System.out.println("\n\n\n\n\n\n\n_____________________________");
					System.out.println("--Menu de operacion--"
							+ "\n1)_ Solicitar productos."
							+ "\n2)_ Mostrar productos solicitados."
							+ "\n3)_ Buscador de clientes."
							+ "\n4)_ Salir");
					
					System.out.print("\nIngrese la opcion deseada: ");
					do {
						try {
							seleccion = input.nextByte();
								if ( seleccion == 1 || seleccion == 2 || seleccion == 3 || seleccion == 4) {
								break;
							} else {
								System.err.print("La opcion ingresada no existe. ");
								System.out.print("Ingrese la opcion deseada: ");
							}
						} catch (InputMismatchException e) {
							input.nextLine(); //Limpieza de buffer de Scanner.
							System.err.print("Solo se permiten valores numericos. ");
							System.out.print("Ingrese la opcion deseada: ");
						}
					} while (true);
					
					switch (seleccion) {
					
						// Se pregunta y se crea el producto deseado.
						case 1:
							do {
								System.out.println(""
										+ "\n\n\n\n\n\n\n_____________________________"
										+ "\nNuestros productos:"
										+ "\n1)_ ** " + EnumProductos.CA.getDescripcion() + " **"
										+ "\n2)_ ** " + EnumProductos.CC.getDescripcion() + " **"
										+ "\n3)_ ** " + EnumProductos.TC.getDescripcion() + " **"
										+ "\n4)_ ** " + EnumProductos.FCI.getDescripcion() + " ** (PRODUCTO MOMENTANEMANTE NO DISPONIBLE)"
										+ "\n5)_ ** " + EnumProductos.PF.getDescripcion() + " ** (PRODUCTO MOMENTANEMANTE NO DISPONIBLE)\n");
							
								System.out.print("Ingrese el numero del producto a solicitar: ");
								
								// Loop do-while para controlar ingreso de opciones. Controla que se ingresen numeros y estos esten dentro de las opciones.
								do {
									boolean auxValidOption;
									//Controla ingreso de opciones numericas.
									do {
										auxValidOption = false;
										try {
											seleccion = input.nextByte();
										} catch(InputMismatchException e) {
											System.err.print("\nFavor de ingresar solo valores numericos.");
											System.out.print("\nIngrese el numero del producto a solicitar: ");
											auxValidOption = true;
											input.nextLine(); //Limpiar buffer de Scanner.
										}
									}while(auxValidOption);
									
									try {
										switch (seleccion) {
										case 1:
											Producto ca1 = new CajaAhorro(001, 123);
											System.out.println( "\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
											System.out.print( "Se genero la Caja de Ahorro: ");
											ca1.imprimirNumeroProducto();
											System.out.println( "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" );
											productosCreados.add(ca1);
											break;
											
										case 2:
											Producto cc1 = new CuentaCorriente(002, 023);
											System.out.println( "\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
											System.out.print("Se genero la Cuenta Corriente: ");
											cc1.imprimirNumeroProducto();
											System.out.println( "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" );
											productosCreados.add(cc1);
											break;
											
										case 3:
											Producto tc1 = new TarjetaCredito(003, 342);
											System.out.println( "\n-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-");
											System.out.print("Se genero la Tarjeta de Credito: ");
											tc1.imprimirNumeroProducto();
											System.out.println( "-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-\n" );
											productosCreados.add(tc1);
											break;
											
										case 4:									
										case 5:
											throw new ExcepcionProducto(1);
											
										default:
											throw new ExcepcionProducto(2);			
										}
										
									} catch (ExcepcionProducto e) {
										if (e.getCodigo() == 1) {
											Log log = null;
											LogDTO lDTO = new LogDTO();
										
											if (seleccion == 4) {
												log = new Log(Class.class.getName(), EnumProductos.FCI.getDescripcion(), e.getMessage(e.getCodigo()));
												
											} else if (seleccion == 5) {
												log = new Log(Class.class.getName(), EnumProductos.PF.getDescripcion(), e.getMessage(e.getCodigo()));
											}
											
											lDTO.insert(log);
										}
										
										System.out.print(String.format("\n%s."
												+ "\nIngrese el numero del producto a solicitar: ", e.getMessage(e.getCodigo())));
										
									}
								}while( seleccion < 1 || seleccion > 5 || seleccion == 4 || seleccion == 5);
								
								input.nextLine(); //Limpieza de buffer Scanner.
								
								// Bucle para verificar si el usuario desea seguir agregando productos.
								boolean aux = true;
								do {
									System.out.print("Desea agregar otro producto? (y/n): ");
									if ( input.nextLine().toLowerCase().equals("n") ) {
										aux = false;
									}
									break;
								} while (true);
								
								if( aux == false ) {
									break;
								}
								
							} while(true);
							
							System.out.println("\nOperacion finalizada.");
							break;
						
						// Se muestran los productos creados.
						case 2:
							System.out.println("\n\n\n_____________________________"
									+ "\nUsted solicito los siguientes productos:");
							productosCreados.sort(ordenador);
							for (Producto producto : productosCreados) {
								producto.imprimirNumeroProducto();
							}
							input.nextLine(); //Limpiza de buffer Scanner
							System.out.print("\nPresione enter para volver al menu...");
							input.nextLine();
							break;
						 
						case 3:
							System.out.println("\n\n\n\n\n\n\n\n_____________________________");
							System.out.println("** Buscador de clientes **");
							System.out.print("\nIngrese el tipo de documento de la persona a buscar: ");
							input.nextLine(); //Limpieza de buffer Scanner.
							String auxTipo = input.nextLine().toUpperCase().trim();
							
							System.out.print(String.format("Ingrese el %s de la persona a buscar: ", auxTipo) );
							String auxNum = input.nextLine();
							
							Documento auxDoc = new Documento(auxTipo, auxNum);
							
							// Busca en la lista de clientes si existe la clave auxDoc (Documento ingresado). Si lo encuentra 2.5 segundos y muestra los datos del cliente junto con los productos registrados para ese cliente.
							if ( clientesActivos.containsKey(auxDoc) ) {
								try {
									Thread.sleep(2500);
									System.err.println("\n\nExiste un cliente cargado con ese documento.\n");
									System.out.println(clientesActivos.get(auxDoc).toString());
									System.out.println("Productos registrados:");
									for (Producto producto : clientesActivos.get(auxDoc).getListadoProductos() ) {
										producto.imprimirNumeroProducto();
									}
								} catch (Exception e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} else {
								System.err.println(String.format("\nNo se encontro ningun cliente registrado con el %s ingresado.", auxTipo));
							}
							System.out.println("\nPresione ENTER para continuar...");
							input.nextLine();
							break;
							
						case 4:
							isFinish = true;
							break;
						
						default:
							break;
					
					}
					
					if ( isFinish == true ) {
						break;
					}
				} while(true);	
				
				System.out.println(   "\n\n\n\n\n\n---------------------------"
									+ "Gracias por utlizar Home Banking. Lo esperamos pronto!"
									+ "---------------------------");
				break; //Finaliza el Portal de Usuario.
		}
		
		System.out.println("\n\nFinalizando programa...");
		System.out.println("Programa finalizado.");
	}
}