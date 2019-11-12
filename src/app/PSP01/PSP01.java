package app.PSP01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PSP01 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in); // Invocamos un método sobre un objeto Scanner
        int op;
        boolean salir = false;
        while (!salir) {

            System.out.println(

                            "1. - .\n"
                            + "2. - .\n"
                            + "3. - .\n" + "4. - .\n"
                            + "5. - .\n" + "6. - .\n"
                            + "7. - .\n" + "8. - .\n"
                            + "9. - .\n"
                            + "10. - \n"
                            + "0. - Sair do programa.\n"

            );

            try {
                op = reader.nextInt();

                switch (op) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    System.out.println(
                        " PSP01_EJ1_Primera parte:"
                        +" implementa una aplicación que ordena un conjunto indeterminado de números que recibe a través de su entrada estándar;"
                        +" y muestra el resultado de la ordenación en su salida estándar. La aplicación se llamará 'ordenarNumeros'."
                       
                    );
                    OrdenarNumeros.main(args);
                    break;
                case 2:
                System.out.println(
                     " PSP01_EJ1_Segunda parte: "
                    +" implementa una aplicación, llamada 'aleatorios'"
                    +" que genere al menos 40 números aleatorios (entre 0 y 100), y que los escriba en su salida estándar."
                   
                );
                Aleatorios.main(args);
                    break;
                case 3:
                System.out.println(
                    " PSP01_EJ1_Tercera parte: Realiza un pequeño manual (tipo '¿Cómo se hace?' o 'HowTo'), utilizando un editor de textos (tipo word o writer)"
                    +"en el que indiques, con pequeñas explicaciones y capturas, cómo has probado la ejecución de las aplicaciones que has implementado en este ejercicio." 
                    +" Entre las pruebas que hayas realizado, debes incluir una prueba en la que utilizando el operador '|'' (tubería) redirijas la salida de la aplicación 'aleatorios' a la entrada de la aplicación 'ordenarNumeros'.'"
                );
                    break;
                case 4:
                System.out.println(
                    " PSP01_EJ2_Primera parte:"
                    +" implementa una aplicación que escriba en un fichero indicado por el usuario conjuntos de letras generadas de forma aleatoria (sin sentido real). Escribiendo cada conjunto de letras en una línea distinta."
                    +" El número de conjuntos de letras a generar por el proceso, también será dado por el usuario en el momento de su ejecución."
                    +" Esta aplicación se llamará 'lenguaje' y como ejemplo, podrá ser invocada así:"
                    +"java -jar lenguaje 40 miFicheroDeLenguaje.txt"
                    +"Indicando que se generarán 40 palabras del lenguaje y serán guardadas en miFicheroDeLenguaje.txt"
                );
                    break;
                case 5:
                System.out.println(
                    " PSP01_EJ2_Segunda parte:"
                    +"implementa una aplicación, llamada 'colaborar', que lance al menos 10 instancias de la aplicación 'lenguaje'." 
                    +" Haciendo que todas ellas, colaboren en generar un gran fichero de palabras."
                    +" Cada instancia generará un número creciente de palabras de 10, 20, 30, … "
                    +"Por supuesto, cada proceso seguirá escribiendo su palabra en una línea independiente de las otras."
                    +" Es decir, si lanzamos 10 instancias de 'lenguaje', al final, debemos tener en el fichero 10 + 20 + 30 + … + 100 = 550 líneas."
                   
                );
                    break;
                case 6:
                System.out.println(
                    " PSP01_EJ2_Tercera parte:"
                    +"Realiza un pequeño manual (tipo '¿Cómo se hace?'' o 'HowTo'), utilizando un editor de textos (tipo word o writer) en el que indiques, con pequeñas explicaciones y capturas, cómo has probado la ejecución de las aplicaciones que has implementado en este ejercicio."
                    
                );
                    break;
                case 7:
                    
                    break;
                case 8:
                   
                    break;
                case 9:
                    
                    break;
                case 10:
                   
                    break;
                }

            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                reader.next();
            }
        }
        reader.close(); // Cerramos el objeto Scanner

    }
   
}
