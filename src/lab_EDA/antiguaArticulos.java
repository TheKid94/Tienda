/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab_EDA;

/**
 *
 * @author VVT
 */
public class antiguaArticulos 
{
    public String []articulos = new String[10]; 
    
    
    public void MostrarArticulosRecursivo(String[] array, int indice)
    {
        if(indice == array.length)
        {
           
        } 
        else
        {   
            System.out.println(indice + ".- " + array[indice]);       
            
            MostrarArticulosRecursivo(array, indice + 1); 
            
        }
    }
   
    public String GuardarArticulo(String []arreglo,int posicionbuscar,int i)
    {
        if(i == posicionbuscar)
        {                            
           return arreglo[i];     
        }
        else
        {       
           return GuardarArticulo(arreglo, posicionbuscar, i+1);
        }
    }
    
    public int StockDeArticulos(int i)
    {
        for(i = 0; i < articulos.length ; i++)
        {
            if(i == 0)
            {
                 return 10; 
            }
            if(i == 1)
            {
                return 25; 
            }
            if(i == 2)
            {
                return 28; 
            }
             if(i == 3)
            {
                 return 25; 
            }
            if(i == 4)
            {
                return 28; 
            }
            if(i == 5)
            {
                return 25; 
            }
             if(i == 6)
            {
                 return 25; 
            }
            if(i == 7)
            {
                return 18; 
            }
            if(i == 8)
            {
                return 25; 
            }
            if(i == 9)
            {
                return 45;
            }
        }
        return 0; 
    }
    
    public double Precios(int i, int n)
    {             
            if(i == 0)
            {
                 return 10.00*n; 
            }
            if(i == 1)
            {
                return 25.00*n; 
            }
            if(i == 2)
            {
                return 28.00*n; 
            }
             if(i == 3)
            {
                 return 25.00*n; 
            }
            if(i == 4)
            {
                return 28.00*n; 
            }
            if(i == 5)
            {
                return 25.00*n;
            }
             if(i == 6)
            {
                 return 25.00*n; 
            }
            if(i == 7)
            {
                return 18.00*n; 
            }
            if(i == 8)
            {
                return 25.00*n; 
            }
            if(i == 9)
            {
                return 80.00*n;
            }
            return 0.0;       
    }
}
