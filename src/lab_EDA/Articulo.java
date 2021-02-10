
package lab_EDA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Articulo {
    private static final String FILENAME = "F:\\JAREKYALE\\clases 2020 2\\EDA\\Java\\TienditaRecursivo2\\src\\datos\\articulos.txt";
    public String codigo;
    public String nombre;
    public double precio;

    public Articulo() {
    }

    public Articulo(String codigo, String nombre, double precio) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
    
    public void articuloOpciones(ArrayList<Articulo> listaArticulos)    
    {
        
        Scanner entry = new Scanner(System.in);
        
        boolean regresar = false;
        while(!regresar){
            System.out.println("====SELECCIONE LAS OPCIONES PARA ARTICULO===");
            System.out.println(" 1 - Crear Articulo ");
            System.out.println(" 2 - Listar Articulos");
            System.out.println(" 3 - Eliminar Articulo ");
            System.out.println(" 4 - Modificar Articulo ");
            System.out.println(" 0 - Regresar ");
            
            int option = Integer.parseInt(entry.nextLine());
            switch(option) {
                case 1:
                    Articulo ar = new Articulo(); 
                    insertarArticulo(ar, entry);
                    listaArticulos.add(ar);
                    GuardarDatosTxt(listaArticulos);
                    break;
                case 2:
                    if(listaArticulos.size()==0){
                        System.out.println("No hay registro de Articulos");
                    }else{
                        listarArticulo(listaArticulos,listaArticulos.size()-1); 
                    }
                    break;
                case 3:
                    System.out.println(" Ingrese el codigo de Articulo a eliminar");
                    int eli = Integer.parseInt(entry.nextLine());
                    eliminarArticulo(listaArticulos, eli);
                    break;
                case 4:
                    System.out.println(" Ingrese el codigo de Articulo a mdificar");
                    int cod = Integer.parseInt(entry.nextLine());
                    modificarArticulo(listaArticulos, cod, entry);
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
    
    public void insertarArticulo(Articulo ar, Scanner entry){
                    System.out.println("Ingrese Codigo:");
                    ar.setCodigo(entry.nextLine());
                    
                    System.out.println("Ingrese Nombre: ");
                    ar.setNombre(entry.nextLine());
                    
                    System.out.println("Ingrese Costo: ");
                    ar.setPrecio(Double.parseDouble(entry.nextLine()));
                    
                    System.out.println("=========================");
                    System.out.println("ARTICULO CREADO\n");
                    
    }
    
    public void eliminarArticulo(ArrayList<Articulo> lista, int eli){
        for(int i=0; i<lista.size(); i++){
            Articulo ar_cod = lista.get(i);
            if(eli == Integer.parseInt(ar_cod.getCodigo())){
                lista.remove(i);
                System.out.println("=========================");
                System.out.println("Articulo ELIMINADO\n");
            }
        }
        GuardarDatosTxt(lista);
    }
    
    public void modificarArticulo(ArrayList<Articulo> lista, int cod, Scanner entry){
        for (int i = 0; i < lista.size(); i++) {
            Articulo ar_cod = lista.get(i);
            if(cod == Integer.parseInt(ar_cod.getCodigo())){
                System.out.println("Nombre: " + ar_cod.getNombre());
                System.out.println("Precio: " + ar_cod.getPrecio());
                System.out.println("Ingrese nuevo Nombre: ");
                String Nombre = entry.nextLine();
                System.out.println("Ingrese nuevo Precio: ");
                Double Precio = Double.parseDouble(entry.nextLine());
                
                ar_cod.setNombre(Nombre);
                ar_cod.setPrecio(Precio);
                System.out.println("=========================");
                System.out.println("Articulo MODIFICADO\n");
            }
        }
        GuardarDatosTxt(lista);
    }
    
    public void listarArticulo(ArrayList<Articulo> lista, int i){
        if(0<i ){
            listarArticulo(lista, i-1);
        }
        System.out.println("Articulo N°" + (i+1));
        System.out.println("Codigo: " + lista.get(i).getCodigo());
        System.out.println("Nombre: " + lista.get(i).getNombre());
        System.out.println("Precio: " + lista.get(i).getPrecio()+"\n");
    }
    
    public static void GuardarDatosTxt(ArrayList<Articulo> listArticulo){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
            for(Articulo a : listArticulo){
                bw.write(a.getCodigo()+ ", "+a.getNombre()+  ", "+ a.getPrecio()+"\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }
    
    public static void getDatosTxt(ArrayList<Articulo> listArticulo){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {   
            String strCurrentLine;   
            while ((strCurrentLine = br.readLine()) != null) {
                String[] dato = strCurrentLine.split(", ");
                Articulo articulo = new Articulo();
                articulo.setCodigo(dato[0].trim());
                articulo.setNombre(dato[1].trim());
                articulo.setPrecio(Double.parseDouble(dato[2].trim()));
                listArticulo.add(articulo);
                
            }  
        } catch (IOException e) {  
            e.getMessage();
        }
    }    

    
}
