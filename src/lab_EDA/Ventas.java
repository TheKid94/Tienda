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
import static lab_EDA.Main.arti;


/**
 *
 * @author Natt
 */
public class Ventas {
    private String articulo; 
    private String cliente;
    private int DNI; 
    private int nroVentas;
    private int cantidad;
    private static final String FILENAME = "F:\\JAREKYALE\\clases 2020 2\\EDA\\Java\\TienditaRecursivo2\\src\\datos\\ventas.txt";
 
    
    // Este constructor nos permite crear una venta sin ningún atributo.
    public Ventas(){}
        
    // Este constructor nos permite crear una venta el cual va a contener inmediatamente
    // todas sus variables asignadas.
    public Ventas(String articulo, String cliente, int DNI, int Nventas, int cant){
        this.articulo = articulo;
        this.cliente = cliente;
        this.DNI = DNI; 
        nroVentas = Nventas;      
        cantidad = cant;
       
    }
    // Cabe mencionar que aunque creemos una venta sin atributos, siempre podemos
    // Asignarselos más adelante en el código utilizando los getters y setters.
    // (En la clase main hay un ejemplo de esto).
    public int getDNI()
    {
        return this.DNI; 
    }
    public void setDNI(int dni)
    {
        this.DNI = dni; 
    }
   public int getCant()
   {
       return this.cantidad;
   }
   public void setCant(int canti)
   {
       this.cantidad = canti; 
   }
   public int getNroV()
   {
       return this.nroVentas;
   }
   public void setNroV(int nro)
   {
       this.nroVentas = nro;
   }
     public String getCliente(){
        return this.cliente;
    }
    public void setCliente(String cte){
        this.cliente = cte;
    }
    
    
    public String getArticulo(){
        return this.articulo;
    }
    
    public void setArticulo(String art) {
        this.articulo = art;
    } 
    
   
    public void CrearVenta(Ventas ven, Scanner entrada, ArrayList<Ventas> listaVentas, ArrayList<Articulo> listArticulo){
                    System.out.println("¡Hola!");
                    Ventas a = new Ventas(); //se crea una nueva venta
                    //se instancia una venta vacia y se llena                      
                    for(int i = 0; i <= listaVentas.size(); i++)
                      {                            
                      // listaVentas.size() Permite ver cuantos elementos hay guardados.
                          a.setNroV( i + 1);
                      }
                    //Me falta guardar el nombre del cliente y su dni
                            
                    System.out.println("Ingrese articulo:");
                    for(Articulo arti : listArticulo)
                    {
                        System.out.println(Integer.parseInt(arti.getCodigo())+" - "+arti.getNombre());
                    };
                    System.out.println("¿Qué deseas comprar?"); 
                   
                    int objeto = Integer.parseInt(entrada.nextLine());
                    
                    for(int i=0; i<listArticulo.size(); i++)
                    {
                        Articulo arti_cod = listArticulo.get(i);
                        if(objeto == Integer.parseInt(arti_cod.getCodigo()))
                        {
                            a.setArticulo(arti_cod.getNombre());
                        }
                    }
                    System.out.println("¿Cuantos productos desea?");
                    int n = Integer.parseInt(entrada.nextLine());
                    a.setCant(n);
                    System.out.println("Precio:");
                    System.out.println(arti.Precios(objeto, n)); 
                    System.out.println("¿Finalizar la compra?");
                    System.out.println("1.- Finalizar.");
                    System.out.println("2.- Salir.");
                    
                    int respuesta = Integer.parseInt(entrada.nextLine());
                                        switch(respuesta)
                    {
                        case 1: 
                            System.out.println("¡Gracias por su compra!"); 
                             // Y lo guardamos en la lista de ventas utilizando el método de la lista .add(a);
                            listaVentas.add(a);                               
                            break; 
                        case 2: 
                            System.out.println("lo sentimos, vuelva pronto");
                            break; 
                        default: // En caso de que el numero ingresado no corresponda a ningún "case"
                        System.out.println("Opción inválida");
                        break;
                    }
                   

                    
    }
    
    public void eliminarVenta(ArrayList<Ventas> listaVenta, int eli)
    {
        for(int i=0; i<listaVenta.size(); i++)
        {
            Ventas ven = listaVenta.get(i);
            if(eli == ven.getNroV())
            {
                listaVenta.remove(i);
                System.out.println("=========================");
                System.out.println("VENTA ELIMINADA\n");
            }
        }
        GuardarDatosVentaTxt(listaVenta);
    }
    
    public void modificarVentas(ArrayList<Ventas> listaVenta, int num, Scanner entry, ArrayList<Articulo> listArticulo)
    {
        for (int i = 0; i < listaVenta.size(); i++) 
        {
            Ventas ven = listaVenta.get(i); 
            if(num == ven.getNroV())
            {
                System.out.println("N° Venta: " + ven.getNroV());
                System.out.println("Nombre: " + ven.getCliente());
                System.out.println("DNI: " + ven.getDNI());
                System.out.println("Articulo: " + ven.getArticulo());
                System.out.println("Cantidad: " + ven.getCant());
                
                for(Articulo arti : listArticulo)
                {
                        System.out.println(Integer.parseInt(arti.getCodigo())+" - "+arti.getNombre());
                };
                System.out.println("¿Qué deseas comprar?"); 
                System.out.println("Ingrese nuevo Articulo: ");
                String Articulo = entry.nextLine();
                System.out.println("¿Cuántos desea?");
                int cant = Integer.parseInt(entry.nextLine()); 
                                               
                ven.setArticulo(Articulo);
                ven.setCant(cant);
                System.out.println("=========================");
                System.out.println("VENTA MODIFICADA\n");
            }
        }
        GuardarDatosVentaTxt(listaVenta);
    }
    
    public void listarVentas(ArrayList<Ventas> listaVenta, int i)
    {
        if(0<i)
        {
            listarVentas(listaVenta, i-1);
        }
        System.out.println("N° Venta" + (i+1)); 
        System.out.println("Nombre: " + listaVenta.get(i).getCliente());
        System.out.println("DNI: " + listaVenta.get(i).getDNI()); 
        System.out.println("Articulo: " + listaVenta.get(i).getArticulo());
        System.out.println("Cantidad: " + listaVenta.get(i).getCant()+"\n");
    }
    
    public static void GuardarDatosVentaTxt(ArrayList<Ventas> listaVenta){
        try 
        {
               BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
                for(Ventas ven : listaVenta)
                {
                   bw.write(ven.getNroV() + ", " + ven.getCliente()+  ", " +ven.getDNI()+ ", " 
                           + ven.getArticulo()+", " + ven.getCant() +  "\n");
                }
            bw.close();
        } 
        catch (Exception e) 
        {
            System.out.println( e.getMessage() );
        }
    }
    
    public static void getDatosVentaTxt(ArrayList<Ventas> listaVenta)
    {
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) 
        {   
            String strCurrentLine;   
            while ((strCurrentLine = br.readLine()) != null) {
                String[] dato = strCurrentLine.split(", ");
                Ventas ven = new Ventas(); 
                ven.setNroV(Integer.parseInt(dato[0].trim()));
                ven.setCliente(dato[1].trim());
                ven.setDNI(Integer.parseInt(dato[2].trim()));
                ven.setArticulo(dato[3].trim());
                ven.setCant(Integer.parseInt(dato[4].trim()));
                listaVenta.add(ven);                
            }  
        } 
        catch (IOException e) 
        {  
            e.getMessage();
        }
    }    
    
        //Creo no usaremos esto
//     public void VentaOpciones(ArrayList<Articulo> listaArticulos)    
//    {
//        
//        Scanner entry = new Scanner(System.in);
//        
//        boolean regresar = false;
//        while(!regresar){
//            System.out.println("====SELECCIONE LAS OPCIONES PARA ARTICULO===");
//            System.out.println(" 1 - Crear Articulo ");
//            System.out.println(" 2 - Listar Articulos");
//            System.out.println(" 3 - Eliminar Articulo ");
//            System.out.println(" 4 - Modificar Articulo ");
//            System.out.println(" 0 - Regresar ");
//            
//            int option = Integer.parseInt(entry.nextLine());
//            switch(option) {
//                case 1:
//                    Articulo ar = new Articulo(); 
//                    insertarArticulo(ar, entry);
//                    listaArticulos.add(ar);
//                    GuardarDatosTxt(listaArticulos);
//                    break;
//                case 2:
//                    if(listaArticulos.size()==0){
//                        System.out.println("No hay registro de Articulos");
//                    }else{
//                        listarArticulo(listaArticulos,listaArticulos.size()-1); 
//                    }
//                    break;
//                case 3:
//                    System.out.println(" Ingrese el codigo de Articulo a eliminar");
//                    int eli = Integer.parseInt(entry.nextLine());
//                    eliminarArticulo(listaArticulos, eli);
//                    break;
//                case 4:
//                    System.out.println(" Ingrese el codigo de Articulo a mdificar");
//                    int cod = Integer.parseInt(entry.nextLine());
//                    modificarArticulo(listaArticulos, cod, entry);
//                    break;
//                case 0:
//                    regresar = true;
//                    System.out.println("Regresando\n");
//                    break;
//                default:
//                    System.out.println("Opcion invalida!\n");
//                break;
//            }
//        }
//        
//    }
    
}
