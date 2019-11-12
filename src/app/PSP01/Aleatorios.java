package app.PSP01;

public class Aleatorios {
/**
 * FUNCIONALIDAD APP
 *  **********************************************************************************************************************
 *      PSP01_EJ1_Segunda parte: 
 *      implementa una aplicación, llamada 'aleatorios'
 *      que genere al menos 40 números aleatorios (entre 0 y 100), y que los escriba en su salida estándar.
 * ***********************************************************************************************************************
 */

/**
 * 
 * @param args
 */
 public static void main(String[] args) {
    Aleatorios al = new Aleatorios();
    al.escribirIntSalidaEstandar(al.numAleatorios(40, 0, 100));
    }
/**
 * Recive una cantidad de numeros , y un rango [numero inicial - numero final] y devuleve esa cantidad de numeros aleatorios en el rango deseado.
 * @param   int cantAleat
 * @param   int nIncial
 * @param   int nFinal
 * @return  String  res
 */ 
     int [] numAleatorios(int cantAleat, int nIncial, int nFinal) {
        int n; int[] res= new int [cantAleat];

        for (int i=0; i<cantAleat; i++){
            n = (int) (Math.random() * nFinal)+nIncial ;
            res[i]=n ;  
        }
       return res;
     } 
     void escribirIntSalidaEstandar( int [] towrite ){



    } 

}
