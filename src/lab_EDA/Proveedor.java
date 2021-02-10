
package lab_EDA;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Proveedor {
    private static final String FILENAME = "F:\\JAREKYALE\\clases 2020 2\\EDA\\Java\\TienditaRecursivo2\\src\\datos\\proveedores.txt";
    public String ruc;
    public String razon_social;
    public String correo;

    public Proveedor() {
    }

    public Proveedor(String ruc, String razon_social, String correo) {
        this.ruc = ruc;
        this.razon_social = razon_social;
        this.correo = correo;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazon_social() {
        return razon_social;
    }

    public void setRazon_social(String razon_social) {
        this.razon_social = razon_social;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public void proveedorOpciones(ArrayList<Proveedor> listaProveedor){
        
        Scanner entry = new Scanner(System.in);
        
        
        boolean regresar = false;
        while(!regresar){
            System.out.println("====SELECCIONE LAS OPCIONES PARA PROVEEDOR===");
            System.out.println(" 1 - Crear Proveedor ");
            System.out.println(" 2 - Listar Proveedores");
            System.out.println(" 3 - Eliminar Proveedor ");
            System.out.println(" 4 - Modificar Proveedor ");
            System.out.println(" 0 - Regresar ");
            
            int option = Integer.parseInt(entry.nextLine());
            switch(option) {
                case 1:
                    Proveedor pr = new Proveedor(); 
                    insertarProveedor(pr, entry);
                    listaProveedor.add(pr);
                    GuardarDatosTxt(listaProveedor);
                    break;
                case 2:
                    if(listaProveedor.size()==0){
                        System.out.println("No hay registro de Proveedors");
                    }else{
                        listarProveedor(listaProveedor,listaProveedor.size()-1); 
                    }
                    break;
                case 3:
                    System.out.println(" Ingrese el id del Proveedor para eliminar");
                    eliminarProveedor(listaProveedor, entry.nextLine());
                    break;
                case 4:
                    System.out.println(" Ingrese el id del Proveedor a mdificar");
                    modificarProveedor(listaProveedor, entry.nextLine(), entry);
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

    public void insertarProveedor(Proveedor pr, Scanner entry){
                    System.out.println("Ingrese Razon Social: ");
                    pr.setRazon_social(entry.nextLine());
                    
                    System.out.println("Ingrese Razon RUC: ");
                    pr.setRuc(entry.nextLine());
                    
                    System.out.println("Ingrese Correo: ");
                    pr.setCorreo(entry.nextLine());
                    
                    System.out.println("=========================");
                    System.out.println("PROVEEDOR CREADO\n");
    }
    
    public void eliminarProveedor(ArrayList<Proveedor> lista, String eli){
        for(int i=0; i<lista.size(); i++){
            Proveedor pr_cod = lista.get(i);
            if(eli == pr_cod.getRuc()){
                lista.remove(i);
                System.out.println("=========================");
                System.out.println("PROVEEDOR ELIMINADO\n");
            }
        }
        GuardarDatosTxt(lista);
    }
    
    public void modificarProveedor(ArrayList<Proveedor> lista, String cod, Scanner entry){
        for (int i = 0; i < lista.size(); i++) {
            Proveedor pr_cod = lista.get(i);
            if(cod == pr_cod.getRuc()){
                System.out.println("Razón Social: " + pr_cod.getRazon_social());
                System.out.println("RUC: " + pr_cod.getRuc());
                System.out.println("Correo: " + pr_cod.getCorreo());
                System.out.println("Ingrese nueva Razón Social: ");
                String Razon = entry.nextLine();
                System.out.println("Ingrese nuevo Correo: ");
                String Correo = entry.nextLine();
                
                pr_cod.setRazon_social(Razon);
                pr_cod.setCorreo(Correo);
                System.out.println("=========================");
                System.out.println("PROVEEDOR MODIFICADO\n");
            }
        }
        GuardarDatosTxt(lista);
    }
    
    public void listarProveedor(ArrayList<Proveedor> lista, int i){
        if(0<i ){
            listarProveedor(lista, i-1);
        }
        System.out.println("Proveedor N°" + (i+1));
        System.out.println("Razón Social: " + lista.get(i).getRazon_social());
        System.out.println("RUC: " + lista.get(i).getRuc());
        System.out.println("Correo: " + lista.get(i).getCorreo()+"\n");
    }
    
    public static void GuardarDatosTxt(ArrayList<Proveedor> listaProveedor){
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(FILENAME));
            for(Proveedor p : listaProveedor){
                bw.write(p.getRuc()+ ", "+p.getRazon_social()+  ", "+ p.getCorreo()+"\n");
            }
            bw.close();
        } catch (Exception e) {
            System.out.println( e.getMessage() );
        }
    }
    
    public static void getDatosTxt(ArrayList<Proveedor> listaProveedor){
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {   
            String strCurrentLine;   
            while ((strCurrentLine = br.readLine()) != null) {
                String[] dato = strCurrentLine.split(", ");
                Proveedor proveedor = new Proveedor();
                proveedor.setRuc(dato[0].trim());
                proveedor.setRazon_social(dato[1].trim());
                proveedor.setCorreo(dato[2].trim());
                listaProveedor.add(proveedor);
                
            }  
        } catch (IOException e) {  
            e.getMessage();
        }
    }
    
    
}
