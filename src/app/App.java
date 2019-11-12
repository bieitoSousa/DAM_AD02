package app;

import java.util.InputMismatchException;
import java.util.Scanner;

import app.AD02.AD02;
import app.PSP01.PSP01;

public class App {
    public static void main(String[] args) throws Exception {
 Scanner reader = new Scanner(System.in); // Invocamos un método sobre un objeto Scanner
        int op;
        boolean salir = false;
        while (!salir) {

            System.out.println(

                             "1. -  Execute AD02.\n"
                            + "2. - Execute PSP01.\n"
                            + "3. - .\n" + "4. - .\n"
                            + "5. - .\n" + "6. - .\n"
                            + "7. - .\n" + "8. - .\n"
                            + "9. - .\n"
                            + "10. - .\n"
                            + "0. - Sair do programa.\n"

            );
            try {
                op = reader.nextInt();

                switch (op) {
                case 0:
                    salir = true;
                    break;
                case 1:
                    
                    AD02.main(args);
                     break;
                case 2:
                    PSP01.main(args);
                    break;
                case 3:
                    
                    break;
                case 4:
                   
                    break;
                case 5:
                    
                    break;
                case 6:
                   
                    break;
                case 7:
                    
                    break;
                case 8:
                   
                    break;
                case 9:
                   
                    break;
                case 10:
                    
                    break;
                default:
                    System.out.print(" Opcion no valida inserte [0] si quiere cancelar ");
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


