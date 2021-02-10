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
//            System.out.println("3.- Recurso");
            System.out.println("0.- Salir");
            
            int identificacion = Integer.parseInt(entrada.nextLine());
            
            switch(identificacion) 
            {

                    
                case 0:// "case" Salir del programa
                    salir = true;
                    System.out.println("Saliendo del programa");
                    break;
                case 1: //Cliente
                    cli.ClienteOpciones(listaCliente, listaVentas, listArticulo);
                    break;     
                case 2: //Vendedor
                    vend.VendedorOpciones(listaVendedores, listaCliente, listaVentas, listArticulo, listaProveedor);                
    
                
                default: // En caso de que el numero ingresado no corresponda a ningún "case"
                    System.out.println("Opción inválida");
                 break;
            }
            
           
        }
        
    }
}