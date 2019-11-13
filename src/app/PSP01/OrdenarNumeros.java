package app.PSP01;

import java.io.IOException;
import java.nio.IntBuffer;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * FUNCIONALIDAD APP
 *  **********************************************************************************************************************
 *   implementa una aplicación que ordena un conjunto indeterminado de números que recibe a través de su entrada estándar;
 *   y muestra el resultado de la ordenación en su salida estándar. La aplicación se llamará 'ordenarNumeros'.
 * ***********************************************************************************************************************
 */

public class OrdenarNumeros {

	public static void main(String[] args) {
        OrdenarNumeros order = new OrdenarNumeros();
        //order.orNum(order.LeerIntEntradaEstandar(),true);
        
    }
    int[] orNum(int[] arryNum, boolean asc) {
        int [] res = arryNum; 
        Arrays.sort(arryNum);

        if(asc){//ASCENDENTEMENTE 
            for(int i = 0; i < arryNum.length; i++){
               res[i]= arryNum[i]; 
            } 


        }else{//DESTENDENTEMENTE
            int z=0; 
            for(int i =arryNum.length-1; i>=0; i--){
                res[z]= arryNum[i]; 
                z++;  
            }
        } 
        return res;
    }
    int[] LeerIntEntradaEstandar() {
        int c;
        //creo una lista para poner uin numero indeterminado de numeros
        ArrayList<Integer> t = new ArrayList<Integer>();
        try{
            // si System.Int lee un numero
            while ((c=(int)System.in.read())!='\n'){
                t.add(c);// lo añado a un array list
            }
        }catch(IOException ex){}
        // pasamos a int 
        //creamos el array a partir de la longitud del ArrayList
        int [] res = new int[t.size()]; 
        //vinculamos los valores
        for(int i=0; t.size()<i;i++){
        res[i] = (int)t.get(i);
        }
        return res;
    }

}
