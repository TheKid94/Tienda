/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_EDA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author VVT
 */
public class Vendedores 
{
    private static final String FILENAME = "F:\\JAREKYALE\\clases 2020 2\\EDA\\Java\\TienditaRecursivo2\\src\\datos\\vendedores.txt";
    public int DNI;
    public String nombre;
    public String ApellidoPa;
    public String ApellidoMa; 
    
  public Vendedores() 
  {
  }

    public Vendedores(int DNI, String nombre, String ApellidoPa, String ApellidoMa) 
    {
        this.DNI = DNI; 
        this.nombre = nombre;
        this.ApellidoPa = ApellidoPa;
        this.ApellidoMa = ApellidoMa; 
    }
    
    public int getDNI() 
    {
        return DNI;
    }

    public void setDNI(int DNI) 
    {
        this.DNI = DNI;
    }
    
    public String getNombre()
    {
        return nombre; 
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getApellidoPa()
    {
        return ApellidoPa; 
    }
    
     public void setApellidoPa(String ApellidoPa)
    {
        this.ApellidoPa = ApellidoPa; 
    }
    
    public String getApellidoMa()
    {
        return ApellidoMa; 
    }
    
    public void setApellidoMa(String ApellidoMa)
    {
        this.ApellidoMa = ApellidoMa; 
    }
    
    public boolean BuscarVendedor(Scanner entry, ArrayList<Vendedores> listaVendedores)
    {
        int dni = entry.nextInt();
        boolean ingreso = false;
        for(Vendedores vend : listaVendedores)
            {
               if(dni == vend.getDNI())
               {
                   ingreso = true; 
               }
               else
               {
                  
                   ingreso = false; 
               }
            }
        return ingreso; 
    }
    
    public void incluirVendedor(Vendedores vend, Scanner entry)
    {
        System.out.println("Ingrese Nombre:");
        vend.setNombre(entry.nextLine());

        System.out.println("Ingrese Apellido Paterno: ");
        vend.setApellidoPa(entry.nextLine());

        System.out.println("Ingrese Apellido Materno: ");
        vend.setApellidoMa(entry.nextLine());

        System.out.println("Ingrese Documento de identidad: ");
        vend.setDNI(Integer.parseInt(entry.nextLine()));

        System.out.println("=========================");
        System.out.println("Ya está registrado, ya puede comprar.\n");    
        
        
    }
    
     public void eliminarVendedor(ArrayList<Vendedores> listaVendedores, int eli)
     {
        //Se podría convertir a recursivo 
         for(int i=0; i<listaVendedores.size(); i++)
        {
            Vendedores venEli = listaVendedores.get(i);            
            if(eli == venEli.getDNI())
            {
                listaVendedores.remove(i);
                System.out.println("=========================");
                System.out.println("Cliente ELIMINADO\n");
            }
        }
        GuardarDatosVendedoresTxt(listaVendedores);
    }
     
       public void modificarVendedor(ArrayList<Vendedores> listaVendedores, int dni, Scanner entry)
      {
        for (int i = 0; i < listaVendedores.size(); i++) 
        {
            Vendedores vend = listaVendedores.get(i); 
            
            if(dni == vend.getDNI())
            {
                System.out.println("DNI: " + vend.getDNI());
                System.out.println("Nombre: " + vend.getNombre());
                System.out.println("Apellido Paterno: " + vend.getApellidoPa());
                System.out.println("Apellido Materno: " + vend.getApellidoMa());
                System.out.println("Ingrese nuevo Nombre: ");
                String Nombre = entry.nextLine();
                System.out.println("Ingrese nuevo Apellido Paterno : ");
                String Paterno = entry.nextLine(); 
                System.out.println("Ingrese nuevo Apellido Materno : ");     
                String Materno = entry.nextLine();                 
                
                vend.setNombre(Nombre);
                vend.setApellidoPa(Paterno);
                vend.setApellidoMa(Materno);
                System.out.println("=========================");
                System.out.println("DATOS MODIFICADOS.\n");
            }
        }
        GuardarDatosVendedoresTxt(listaVendedores);
    }
       
       public void listarVendedores(ArrayList<Vendedores> listaVendedores, int i)
     {
        if(0 < i)
        {
            listarVendedores(listaVendedores, i-1);
        }
       
        System.out.println("DNI: " + listaVendedores.get(i).getDNI()+ "\n ");
        System.out.println("Nombre: " + listaVendedores.get(i).getNombre() + "\n ");
        System.out.println("Apellido paterno : " + listaVendedores.get(i).getApellidoPa() +"\n");
        System.out.println("Apellido materno : " + listaVendedores.get(i).getApellidoMa() +"\n");
    }
       
     public static void GuardarDatosVendedoresTxt(ArrayList<Vendedores> listaVendedores)
       {
        try 
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
            for(Vendedores vend : listaVendedores)
            {
                bw.write("DNI: " + vend.getDNI() + "\n" + "Nombre: "+ vend.getNombre() + "\n "
                         + "Apellido paterno: " + vend.getApellidoPa() + 
                        "Apellido materno: " + vend.getApellidoMa() + "\n");
            }
            bw.close();
        } 
        catch (Exception e) 
        {
            System.out.println( e.getMessage());
        }
    }
    public static void getDatosVendedoresTxt(ArrayList<Vendedores> listaVendedores)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
        {   
            String strCurrentLine;   
            while ((strCurrentLine = br.readLine()) != null) 
            {
                String[] dato = strCurrentLine.split(", ");
                Vendedores vende = new Vendedores(); 
                vende.setDNI(Integer.parseInt(dato[0].trim()));
                vende.setNombre(dato[1].trim());
                vende.setApellidoPa(dato[2].trim());
                vende.setApellidoMa(dato[3].trim());
                listaVendedores.add(vende);
                
            }  
        } 
        catch (IOException e) 
        {  
            e.getMessage();
        }
    }
    
    public void VendedorOpciones(ArrayList<Vendedores>listaVendedores, ArrayList<Cliente> listaClientes, ArrayList<Ventas> listaVenta, ArrayList<Articulo> listArticulo, ArrayList<Proveedor> listaProve)
    {
        Scanner entry = new Scanner(System.in);

//        System.out.println("Bienvenido"); 
//        System.out.println("Inicia sesión.");
//        System.out.println("Digite su DNI"); 
//        if(!BuscarVendedor(entry, listaVendedores))
//        {
//            System.out.println("DNI no existente, por favor de ingresar nuevamente.");
//        }
//        else
//        {
            boolean cerrar = false;
            while(!cerrar)
            {
                System.out.println("Bienvenido"); 
                System.out.println("1.- Ventas.");
                System.out.println("2.- Clientes.");
                System.out.println("3.- Proveedores."); 
                System.out.println("4.- Artículos.");
                System.out.println("5.- Vendedores.");
                System.out.println("6.- Tienda(EN MANTENIMIENTO).");
                System.out.println("0.- Cerrar sesión.");
                
                int opcion = Integer.parseInt(entry.nextLine()); 
                switch(opcion)
                {
                    case 1: //ventas
                       System.out.println("====SELECCIONE ALGUNA OPCION ===");
                       System.out.println(" 1 - Listar ventas. ");
                       System.out.println(" 2 - Eliminar ventas. ");
                       System.out.println(" 3 - Modificar ventas. ");                       
                       System.out.println(" 0 - Regresar. ");
                       
                       int eleccion = Integer.parseInt(entry.nextLine());
                       Ventas ven = new Ventas(); 
                       boolean regresar = false; 
                       while(!regresar)
                       {
                           switch(eleccion)
                           {                              
                               case 1: //listar                                   
                                   ven.listarVentas(listaVenta, DNI);
                                   break; 
                               case 2: //eliminar
                                   System.out.println("Introduzca el nroVenta que desea eliminar.");
                                   int nroV = Integer.parseInt(entry.nextLine()); 
                                   ven.eliminarVenta(listaVenta, nroV);
                                   break;
                               case 3: //modificar
                                   System.out.println("Introduzca el nroVenta que desea modificar.");
                                   nroV = Integer.parseInt(entry.nextLine());
                                   ven.modificarVentas(listaVenta, nroV, entry, listArticulo);
                                   break; 
                               case 0:
                                   regresar = true; 
                                   break; 
                               default: 
                                   System.out.println("Opción inválida");
                                   break; 
                           }
                       }
                        break; 
                    case 2: //clientes
                       System.out.println("====SELECCIONE ALGUNA OPCION ===");
                       System.out.println(" 1 - Crear cliente. ");
                       System.out.println(" 2 - Listar clientes. ");
                       System.out.println(" 3 - Eliminar cliente. ");
                       System.out.println(" 4 - Modificar cliente. ");
                       System.out.println(" 0 - Regresar. ");
                       
                       eleccion = Integer.parseInt(entry.nextLine()); 
                       Cliente cli = new Cliente(); 
                       regresar = false;
                        while(!regresar)
                       {
                           switch(eleccion)
                           {
                               case 1: //crear cliente
                                    cli.incluirCliente(cli, entry);
                                   break;
                               case 2: //listar
                                  cli.listarClientes(listaClientes, DNI);
                                   break; 
                               case 3: //eliminar
                                   System.out.println("Ingrese el DNI del cliente que desea eliminar: \n");
                                   int dni = Integer.parseInt(entry.nextLine());
                                   cli.eliminarCliente(listaClientes, dni);
                                   break;
                               case 4: //modificar
                                   System.out.println("Ingrese el DNI del cliente que desea modificar: \n");
                                   dni = Integer.parseInt(entry.nextLine());
                                   cli.modificarCliente(listaClientes, dni, entry);
                                   break; 
                               case 0:
                                   regresar = true; 
                                   break; 
                               default: 
                                   System.out.println("Opción inválida");
                                   break; 
                           }
                       }
                        break; 
                    case 3: //proveedores
                       System.out.println("====SELECCIONE ALGUNA OPCION ===");
                       System.out.println(" 1 - Crear proveedor. ");
                       System.out.println(" 2 - Listar proveedores. ");
                       System.out.println(" 3 - Eliminar proveedores. ");
                       System.out.println(" 4 - Modificar proveedores. ");
                       System.out.println(" 0 - Regresar. ");
                       
                       Proveedor prove = new Proveedor(); 
                       eleccion = Integer.parseInt(entry.nextLine()); 
                       regresar = false;
                        while(!regresar)
                       {
                           switch(eleccion)
                           {
                               case 1: //crear
                                   prove.insertarProveedor(prove, entry);
                                   break; 
                               case 2: //listar
                                   prove.listarProveedor(listaProve, DNI);
                                   break; 
                               case 3: //eliminar
                                   System.out.println("Ingrese el RUC del proveedor que desea eliminar: ");
                                   String RUC = entry.nextLine(); 
                                   prove.eliminarProveedor(listaProve, RUC);
                                   break;
                               case 4: //modificar
                                   System.out.println("Ingrese el RUC del proveedor que desea modificar: ");
                                   RUC = entry.nextLine(); 
                                   prove.modificarProveedor(listaProve, RUC, entry);
                                   break; 
                               case 0:
                                   regresar = true; 
                                   break; 
                               default: 
                                   System.out.println("Opción inválida");
                                   break; 
                           }
                       }
                        break;
                    case 4: //articulos
                       System.out.println("====SELECCIONE ALGUNA OPCION ===");
                       System.out.println(" 1 - Crear artículos. ");
                       System.out.println(" 2 - Listar artículos. ");
                       System.out.println(" 3 - Eliminar artículos. ");
                       System.out.println(" 4 - Modificar artículos. ");
                       System.out.println(" 0 - Regresar. ");
                       Articulo art = new Articulo(); 
                       eleccion = Integer.parseInt(entry.nextLine()); 
                       regresar = false;
                        while(!regresar)
                       {
                           switch(eleccion)
                           {
                               case 1: // crear
                                   art.insertarArticulo(art, entry);
                                   break;
                               case 2: //listar
                                   art.listarArticulo(listArticulo, Integer.parseInt(art.codigo));
                                   break; 
                               case 3: //eliminar
                                   System.out.println("Inserte codigo de articulo que desea eliminar: ");
                                   int cod = Integer.parseInt(entry.nextLine()); 
                                   art.eliminarArticulo(listArticulo, cod);
                                   break;
                               case 4: //modificar
                                   System.out.println("Inserte codigo de articulo que desea modificar: ");
                                   cod = Integer.parseInt(entry.nextLine()); 
                                   art.modificarArticulo(listArticulo, cod, entry);
                                   break; 
                               case 0:
                                   regresar = true; 
                                   break; 
                               default: 
                                   System.out.println("Opción inválida");
                                   break; 
                           }
                       }
                        break; 
                    case 5: //vendedores
                       System.out.println("====SELECCIONE ALGUNA OPCION ===");
                       System.out.println(" 1 - Incluir vendedor ");
                       System.out.println(" 2 - Listar vendedores. ");
                       System.out.println(" 3 - Eliminar vendedor. ");
                       System.out.println(" 4 - Modificar vendedor. ");
                       System.out.println(" 0 - Regresar. ");
                       eleccion = Integer.parseInt(entry.nextLine()); 
                       regresar = false;
                        while(!regresar)
                       {
                           switch(eleccion)
                           {
                               case 1: //incluir
                                   Vendedores vend = new Vendedores(); 
                                   incluirVendedor(vend,entry); 
                                   break;
                               case 2: //listar
                                   listarVendedores(listaVendedores, DNI); 
                                   break; 
                               case 3: //eliminar
                                   System.out.println("Ingresar el dni del vendedor que desea eliminar:"); 
                                   int dni = Integer.parseInt(entry.nextLine()); 
                                   eliminarVendedor(listaVendedores,dni); 
                                   break;
                               case 4: //modificar
                                   System.out.println("Ingresar el dni del vendedor que desea modificar:"); 
                                   dni = Integer.parseInt(entry.nextLine()); 
                                   modificarVendedor(listaVendedores,dni,entry); 
                                   break; 
                               case 0:
                                   regresar = true; 
                                   break; 
                               default: 
                                   System.out.println("Opción inválida");
                                   break; 
                           }
                       }
                        break; 
                    case 6: //tienda
                         System.out.println("==== EN MANTENIMIENTO JIJI ===");
                         cerrar = true; 
                        break;
                    case 0: //Cerrar
                        cerrar = true; 
                        break; 
                    default: 
                        System.out.println("Opción invalida");
                        break; 
                }
            }
        //}
        
    }
    
}
