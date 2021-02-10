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
    //private static final String FILENAME = "F:\\JAREKYALE\\clases 2020 2\\EDA\\Java\\TienditaRecursivo2\\src\\datos\\Clientes.txt";
    private static final String FILENAME = "D:\\prueba2\\TiendaRecursivo\\src\\datos\\Clientes.txt";
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
            
            boolean mnucli = false; 
            while(!mnucli)
            {
                
                int opcion = Integer.parseInt(entry.nextLine());
                switch(opcion)
                {
                case 1:
                    System.out.println("Digita tu documento de identidad.");
                    int cd = Integer.parseInt(entry.nextLine());
                    if(BuscarCliente(cd, listaClientes) == true)
                    {
                       int cli_dni = buscarClienteDNI(cd, listaClientes);
                       String cli_nombre = buscarClienteNombre(cd, listaClientes);
                       boolean bu = false;
                       while(!bu){
                           System.out.println("====SELECCIONE ALGUNA OPCION ===");
                           System.out.println(" 1 - Comprar ");
                           System.out.println(" 2 - Modificar cuenta ");
                           System.out.println(" 3 - Eliminar cuenta ");                       
                           System.out.println(" 0 - Cerrar cuenta ");
                           int option = Integer.parseInt(entry.nextLine());
                       switch(option)
                        {
                            case 1: 
                                Ventas ven = new Ventas(); 
                                ven.CrearVenta(ven, entry, listaVentas, listArticulo,cli_dni,cli_nombre);
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
                                mnucli = true;
                                bu = true;
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
    
    public boolean BuscarCliente(int cd, ArrayList<Cliente> listaClientes)
    {
        int dni = cd;
        boolean ingreso = false;
        for(Cliente cli : listaClientes)
            {
               if(cli.getDNI() == dni)
               {
                   ingreso = true;
               }
            }
        return ingreso; 
    }
    
    public int buscarClienteDNI(int cd,ArrayList<Cliente> listaClientes){
        int dni = 0;
        for(Cliente cli : listaClientes){
            if(cli.getDNI() == cd){
                dni = cli.getDNI();
            }
        }
        return dni;
    }
    
    public String buscarClienteNombre(int cd,ArrayList<Cliente> listaClientes){
        String nombre = "";
        for(Cliente cli : listaClientes){
            if(cli.getDNI() == cd){
                nombre = cli.getNombre();
            }
        }
        return nombre;
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
                bw.write(cli.getDNI() + ", "+ cli.getNombre() + ", " + cli.getApellidoPa() + 
                        ", " + cli.getApellidoMa() + "\n");
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
   
   public void articuloOpcionesV(ArrayList<Cliente> listaCliente)    
    {
        
        Scanner entry = new Scanner(System.in);
        
        boolean regresar = false;
        while(!regresar){
            System.out.println("====SELECCIONE LAS OPCIONES PARA CLIENTES===");
            System.out.println(" 1 - Crear Articulo ");
            System.out.println(" 2 - Listar Articulos");
            System.out.println(" 3 - Eliminar Articulo ");
            System.out.println(" 4 - Modificar Articulo ");
            System.out.println(" 0 - Regresar ");
            
            int option = Integer.parseInt(entry.nextLine());
            switch(option) {
                case 1:
                    Cliente ar = new Cliente(); 
                    incluirCliente(ar, entry);
                    listaCliente.add(ar);
                    GuardarDatosClienteTxt(listaCliente);
                    break;
                case 2:
                    if(listaCliente.size()==0){
                        System.out.println("No hay registro de Clientes");
                    }else{
                        listarClientes(listaCliente,listaCliente.size()-1); 
                    }
                    break;
                case 3:
                    System.out.println(" Ingrese el dni del Cliente a eliminar");
                    int eli = Integer.parseInt(entry.nextLine());
                    eliminarCliente(listaCliente, eli);
                    break;
                case 4:
                    System.out.println(" Ingrese el dni del Cliente a mdificar");
                    int cod = Integer.parseInt(entry.nextLine());
                    modificarCliente(listaCliente, cod, entry);
                    break;
                case 0:
                    regresar = true;
                    System.out.println("Regresando\n");
                    break;
                default:
                    System.out.println("Opcion invalida!\n");
                break;
            }
        }
        
    }
}
