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
public class Cliente {
    private static final String FILENAME = "F:\\JAREKYALE\\clases 2020 2\\EDA\\Java\\TienditaRecursivo2\\src\\datos\\Clientes.txt";
    public int DNI;
    public String nombre;
    public String ApellidoPa;
    public String ApellidoMa; 
    
      public Cliente() 
      {
          
      }

    public Cliente(int DNI, String nombre, String ApellidoPa, String ApellidoMa) {
        this.DNI = DNI; 
        this.nombre = nombre;
        this.ApellidoPa = ApellidoPa;
        this.ApellidoMa = ApellidoMa; 
    }

    public int getDNI() {
        return DNI;
    }

    public void setDNI(int DNI) {
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
    public void ClienteOpciones(ArrayList<Cliente> listaClientes, ArrayList<Ventas> listaVentas, ArrayList<Articulo> listArticulo)    
    {
        Scanner entry = new Scanner(System.in);

        boolean regresar = false;
        while(!regresar)
        {
            System.out.println("Bienvenido"); 
            System.out.println("1.- Inicia sesión.");
            System.out.println("2.- Registrarse.");
            System.out.println("0.- Regresar al menu.");
            
            int opcion = Integer.parseInt(entry.nextLine());
            boolean mnucli = false; 
            while(!mnucli)
            {
                 switch(opcion)
                {
                case 1: 
                    mnucli = false;
                    System.out.println("Digita tu documento de identidad.");
                    if(BuscarCliente(entry, listaClientes) == true)
                    {
                       System.out.println("====SELECCIONE ALGUNA OPCION ===");
                       System.out.println(" 1 - Comprar ");
                       System.out.println(" 2 - Modificar cuenta ");
                       System.out.println(" 3 - Eliminar cuenta ");                       
                       System.out.println(" 0 - Cerrar cuenta ");
                       
                       int option = Integer.parseInt(entry.nextLine());
                       boolean cerrar = false; 
                       while(!cerrar)
                       {
                            switch(option)
                            {
                                case 1: 
                                    Ventas ven = new Ventas(); 
                                    ven.CrearVenta(ven, entry, listaVentas, listArticulo);
                                    break; 
                                case 2: 
                                    System.out.println("Ingrese su documento de identidad." + "\n");
                                    int dni = Integer.parseInt(entry.nextLine());
                                    modificarCliente(listaClientes, dni, entry);
                                    break; 
                                case 3:
                                    System.out.println(" Ingrese su documento de identidad." + "\n");
                                    int eli = Integer.parseInt(entry.nextLine());
                                    eliminarCliente(listaClientes, eli);                                    
                                    break;
                                case 0: 
                                    cerrar = true; 
                                    mnucli = true; 
                                    regresar = true; 
                                    break; 
                                default: 
                                    System.out.println("Opción inválida."); 
                                    break; 
                            }
                       }                       
                    }
                    else
                    {
                        System.out.println("DNI no existente. Por favor ingrese nuevamente.");
                    }
                    break; 
                case 2: 
                    Cliente cl = new Cliente();  
                    incluirCliente(cl, entry); 
                    listaClientes.add(cl);
                    GuardarDatosClienteTxt(listaClientes); 
                    mnucli = true; 
                    break; 
                case 0: 
                    regresar = true;
                    mnucli = true; 
                    System.out.println("Regresando\n");
                    break; 
                default: 
                    System.out.println("Opción inválida.");
                    break;
                }
            }     
            
        }

    }
    
    public boolean BuscarCliente(Scanner entry, ArrayList<Cliente> listaClientes)
    {
        int dni = entry.nextInt();
        boolean ingreso = false;
        for(Cliente cli : listaClientes)
            {
               if(dni == cli.getDNI())
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
    
     public void incluirCliente(Cliente cli, Scanner entry){
                    System.out.println("Ingrese Nombre:");
                    cli.setNombre(entry.nextLine());
                    
                    System.out.println("Ingrese Apellido Paterno: ");
                    cli.setApellidoPa(entry.nextLine());
                    
                    System.out.println("Ingrese Apellido Materno: ");
                    cli.setApellidoMa(entry.nextLine());
                    
                    System.out.println("Ingrese Documento de identidad: ");
                    cli.setDNI(Integer.parseInt(entry.nextLine()));
                    
                    System.out.println("=========================");
                    System.out.println("Ya está registrado, ya puede comprar.\n");
                    
    }
     
     public void eliminarCliente(ArrayList<Cliente> lista, int eli){
        //Se podría convertir a recursivo 
         for(int i=0; i<lista.size(); i++)
        {
            Cliente cliEli = lista.get(i);            
            if(eli == cliEli.getDNI())
            {
                lista.remove(i);
                System.out.println("=========================");
                System.out.println("Cliente ELIMINADO\n");
            }
        }
        GuardarDatosClienteTxt(lista);
    }
      public void modificarCliente(ArrayList<Cliente> lista, int dni, Scanner entry)
      {
        for (int i = 0; i < lista.size(); i++) 
        {
            Cliente cli = lista.get(i); 
            
            if(dni == cli.getDNI())
            {
                System.out.println("DNI: " + cli.getDNI());
                System.out.println("Nombre: " + cli.getNombre());
                System.out.println("Apellido Paterno: " + cli.getApellidoPa());
                System.out.println("Apellido Materno: " + cli.getApellidoMa());
                System.out.println("Ingrese nuevo Nombre: ");
                String Nombre = entry.nextLine();
                System.out.println("Ingrese nuevo Apellido Paterno : ");
                String Paterno = entry.nextLine(); 
                System.out.println("Ingrese nuevo Apellido Materno : ");     
                String Materno = entry.nextLine();                 
                
                cli.setNombre(Nombre);
                cli.setApellidoPa(Paterno);
                cli.setApellidoMa(Materno);
                System.out.println("=========================");
                System.out.println("DATOS MODIFICADOS.\n");
            }
        }
        GuardarDatosClienteTxt(lista);
    }
      
     public void listarClientes(ArrayList<Cliente> lista, int i)
     {
        if(0 < i)
        {
            listarClientes(lista, i-1);
        }
       
        System.out.println("DNI: " + lista.get(i).getDNI()+ "\n ");
        System.out.println("Nombre: " + lista.get(i).getNombre() + "\n ");
        System.out.println("Apellido paterno : " + lista.get(i).getApellidoPa() +"\n");
        System.out.println("Apellido materno : " + lista.get(i).getApellidoMa() +"\n");
    }
    
   public static void GuardarDatosClienteTxt(ArrayList<Cliente> listaCliente)
       {
        try 
        {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
            for(Cliente cli : listaCliente)
            {
                bw.write("DNI: " + cli.getDNI() + "\n" + "Nombre: "+ cli.getNombre() + "\n "
                         + "Apellido paterno: " + cli.getApellidoPa() + 
                        "Apellido materno: " + cli.getApellidoMa() + "\n");
            }
            bw.close();
        } 
        catch (Exception e) 
        {
            System.out.println( e.getMessage());
        }
    }
    public static void getDatosClienteTxt(ArrayList<Cliente> listaCliente)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
        {   
            String strCurrentLine;   
            while ((strCurrentLine = br.readLine()) != null) 
            {
                String[] dato = strCurrentLine.split(", ");
                Cliente cliente = new Cliente(); 
                cliente.setDNI(Integer.parseInt(dato[0].trim()));
                cliente.setNombre(dato[1].trim());
                cliente.setApellidoPa(dato[2].trim());
                cliente.setApellidoMa(dato[3].trim());
                listaCliente.add(cliente);
                
            }  
        } 
        catch (IOException e) 
        {  
            e.getMessage();
        }
    }
}
