                                                                                                                                                                                                                              /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_EDA;


import java.util.ArrayList;
import java.util.Scanner;
              /**
 *
 * @author VVT
 */
public class Main {
    static antiguaArticulos arti = new antiguaArticulos();
   
    public static void main(String[] args) {
        ArrayList<Articulo> listArticulo = new ArrayList<>();
        ArrayList<Proveedor> listaProveedor = new ArrayList<>();
        ArrayList<Ventas> listaVentas = new ArrayList<>(); 
        ArrayList<Cliente> listaCliente = new ArrayList<>(); 
        ArrayList<Vendedores> listaVendedores = new ArrayList<>(); 
        Cliente cli = new Cliente(); 
        Vendedores vend = new Vendedores(); 
        Proveedor pr = new Proveedor();
        Ventas vent = new Ventas(); 
        Articulo ar = new Articulo();
        ar.getDatosTxt(listArticulo);
        pr.getDatosTxt(listaProveedor);
  
     
//        String []articulos = new String[10]; 
//        articulos[0] = "Pack de sarten con diseño"; 
//        articulos[1] = "Rayador multifuncional"; 
//        articulos[2] = "Pelador de frutas"; 
//        articulos[3] = "Picador de vegetales";
//        articulos[4] = "Mini Licuadora"; 
//        articulos[5] = "Tacho de basura pegable"; 
//        articulos[6] = "Tabla de picar pegable"; 
//        articulos[7] = "Pequeña balanza"; 
//        articulos[8] = "Hervidora de huevos"; 
//        articulos[9] = "Dispensador de menestras";  
         
        // utilizando el objeto entrada obtendremos lo que el usuario ingrese por consola.
        Scanner entrada = new Scanner(System.in);
        
        // El while será ejecutado hasta que salir sea TRUE.
        boolean salir = false;
        while (!salir) {   
            
            System.out.println("Bienvenido a la bodega"); 
            System.out.println("IDENTIFIQUESE:");
            System.out.println("1.- Cliente");
            System.out.println("2.- Vendedor");
            System.out.println("3.- Recurso");
            System.out.println("0.- Salir");
            
            int identificacion = Integer.parseInt(entrada.nextLine());
            
            switch(identificacion) 
            {
                case 3:
                    boolean valor = false;
                    while(!valor){
                        System.out.println(" INGRESE LA OPCION ");
                        System.out.println(" 1 - Opciones de Articulo ");
                        System.out.println(" 2 - Opciones de Proveedor");
                        System.out.println(" 0 - Salir");
                        int re = Integer.parseInt(entrada.nextLine());
                        switch(re){
                            case 0:
                                System.out.println("Saliendo");
                                valor = true;
                                break;
                            case 1:
                                ar.articuloOpciones(listArticulo);
                                break;
                            case 2:
                                pr.proveedorOpciones(listaProveedor);
                                break;
                        }
                    }
                    break;
                    
                case 0:// "case" Salir del programa
                    salir = true;
                    System.out.println("Saliendo del programa");
                    break;
                case 1: //Cliente
                    cli.ClienteOpciones(listaCliente, listaVentas, listArticulo);
                    break;     
                case 2: //Vendedor
                    vend.VendedorOpciones(listaVendedores, listaCliente, listaVentas, listArticulo);
                 
//                 int opcion = Integer.parseInt(entrada.nextLine());
//           
//           
//            switch(opcion) 
//            {
//                case 1: 
//                   for(int i = 0; i < listaVentas.size(); i++){
//                       Ventas v =  listaVentas.get(i);
//                       System.out.println("N° Venta: " + v.getNroV());
//                       System.out.println("Articulo: " + v.getArticulo());
//                       System.out.println("Cantidad: " + v.getCant());
//                       System.out.println("Cliente: " + v.getCliente());
//                   }
//                   if(listaVentas.isEmpty())
//                   {
//                       System.out.println("No hay ventas"); 
//                   }
//                    break;
//                case 2: // ELiminar venta de la lista
//                    if(listaVentas.isEmpty())
//                   {
//                       System.out.println("No hay ventas"); 
//                   }
//                    else
//                    {
//                       System.out.println("Ingresa nro de Venta a eliminar: ");
//                        int nro = Integer.parseInt(entrada.nextLine());
//                    
//                    for (int i = 0; i < listaVentas.size(); i++) {
//                        
//                        Ventas auto = listaVentas.get(i);
//                        if (nro == auto.getNroV()) 
//                        {
//                            listaVentas.remove(i);
//                            System.out.println("Articulo eliminado");
//                        }
//                    }  
//                    }                 
//                                         
//                    break;
//                case 3: // Modificar vehiculo:
//                     if(listaVentas.isEmpty())
//                   {
//                       System.out.println("No hay ventas"); 
//                   }
//                     else
//                     {
//                          System.out.println(" Ingrese el nro de Venta a mdificar");
//                          int nro = Integer.parseInt(entrada.nextLine());
//                    // de nuevo, en síntesis lo que sucede acá es que vamos a buscar cual de
//                    // todos los articulos coinciden con la que el usuario ingresó,
//                    // Luego de esto procederemos a cambiar el proveedor, tienda, cliente y vendedor
//                    // según lo que el usuario escriba.
//                    for (int i = 0; i < listaVentas.size(); i++) {
//                        Ventas prod = listaVentas.get(i);
//                        if (nro == prod.getNroV()) 
//                        {
//                            
//                            System.out.println("Cliente: " + prod.getCliente());
//                                                    
//                            System.out.println("Ingrese nuevo cliente: ");
//                            String Cliente = entrada.nextLine();
//                            prod.setCliente(Cliente);
//                            System.out.println("Articulo a modificar: ");                           
//                           arti.MostrarArticulosRecursivo(articulos, 0);
//                           System.out.println("¿Por cual producto deseas modificar?"); 
//                           int modArti = Integer.parseInt(entrada.nextLine());
//                    
//                    switch(modArti)
//                    {
//                         case 0: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));                         
//                             break; 
//                            case 1: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));                               
//                             break; 
//                            case 2:
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                            
//                             break; 
//                            case 3: 
//                            prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                            
//                             break;
//                            case 4: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                              
//                             break; 
//                            case 5: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                             
//                            case 6: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                              
//                             break; 
//                            case 7: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                              
//                             break; 
//                            case 8: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                              
//                             break; 
//                            case 9: 
//                             prod.setArticulo(arti.GuardarArticulo(articulos, modArti, 0));  
//                             
//                             break; 
//                            default: // En caso de que el numero ingresado no corresponda a ningún "case"
//                    System.out.println("Opcion invalida!");
//                 break;
//                    }
//                    System.out.println("¿Cuantos desea?"); 
//                    int CantidaD = Integer.parseInt(entrada.nextLine()); 
//                    prod.setCant(CantidaD);
//                    System.out.println("Producto Actualizado.");
//                    
//                    }
//                        
//                    }
//                     }                  
//                    
//                    break;
//               
//                    
//                    
//                default: // En caso de que el numero ingresado no corresponda a ningún "case"
//                    System.out.println("Opcion invalida!");
//                 break;                       
//            }                        
            
            
//                 break;                 
                
                default: // En caso de que el numero ingresado no corresponda a ningún "case"
                    System.out.println("Opcion invalida!");
                 break;
            }
            
           
        }
        
    }
}