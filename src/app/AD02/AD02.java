package app.AD02;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.*;
import app.AD02.*;
import app.AD02.Producto;
import app.AD02.AD02.*;

public class AD02 {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in); // Invocamos un método sobre un objeto Scanner
        int op;
        boolean salir = false;
        //Compañia c = Compañia.getInstance();; 
        Compania c = new Compania();
        Tienda t = null;
        while (!salir) {

            System.out.println(

                    "1. - Engadir unha tenda.\n"
                            + "2. - Eliminar unha tenda (elimínanse tódolos productos e empragados desta).\n"
                            + "3. - Engadir un producto a tenda.\n" + "4. - Eliminiar un producto a tenda.\n"
                            + "5. - Engadir un empregado a tenda.\n" + "6. - Eliminar un emprega a tenda.\n"
                            + "7. - Engadir un cliente.\n" + "8. - Eliminar un cliente.\n"
                            + "9. - Crear unha copia de seguriadade dos datos (Explícase máis abaixo).\n"
                            + "10. - Ler os titulares do periódico El País. (Explícase máis abaixo)\n"
                            + "0. - Sair do programa.\n"

            );

            try {
                op = reader.nextInt();

                switch (op) {
                case 0:
                    salir = true;
                    break;
                case 1:

                    System.out.print(" Creando una tienda dime: .\n");
                    String nom = HelpFunctions.inputString("nombre ? .\n");
                    String ciu = HelpFunctions.inputString("cidade ? .\n");
                        c.viewTiendaList();
                        c.addTienda(nom,ciu);
                        c.setTSelecct(c.getTienda(nom));
                       
                        t=c.getTSelecct();
                        System.out.print("Se a creado unha tenda:\n" + t.toString());
                    break;
                case 2:
                    if (t != null) {
                        c.viewTiendaList();
                        String nomTienda = HelpFunctions.inputString(" introduzca nombre de la tienda.\n");
                        c.deleteTienda(nomTienda);
                        System.out.print(" Se ha eliminado la tienda" + nomTienda + ").\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 3:
                    if (t != null) {
                        t.viewProductosList();
                        int  idProducto = HelpFunctions.inputInt(" introduzca id del producto.\n");
                        t.addProducto(idProducto);
                        System.out.print(" SE ha engadir un producto a tenda.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 4:
                    if (t != null) {
                        t.viewProductosList();
                        int  idProducto = HelpFunctions.inputInt(" introduzca id del producto.\n");
                        t.deleteProducto(idProducto);
                        System.out.print("4. - Eliminiar un producto a tenda.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 5:
                    if (t != null) {
                        t.viewEmpregadoList();
                        String nomEmp = HelpFunctions.inputString(" introduzca nombre del empleado.\n");
                        String apelEmp = HelpFunctions.inputString(" introduzca apellido del empleado.\n");
                        t.addEmpregado(nomEmp, apelEmp);
                       
                        System.out.print("Se añadido un empleado.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 6:
                    if (t != null) {
                        t.viewEmpregadoList();
                        String nomEmp =  HelpFunctions.inputString(" introduzca nombre del empleado.\n");
                        t.deleteEmpregado(nomEmp);
                        System.out.print("6. - Eliminar un empregado a tenda.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 7:
                    if (t != null) {
                        t.viewClienteList();
                        String nomCli = HelpFunctions.inputString(" introduzca nombre del cliente.\n");
                        String apelCli = HelpFunctions.inputString(" introduzca apellido del cliente.\n");
                        String mailCli = HelpFunctions.inputString(" introduzca email del cliente.\n");
                        t.addCliente(nomCli, apelCli, mailCli);
                        System.out.print(" Se ha añadido un cliente.");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 8:
                    if (t != null) {
                        t.viewClienteList();
                        String nomCli = HelpFunctions.inputString(" introduzca nombre del cliente.\n");
                        t.deleteCliente(nomCli);
                        System.out.print("8. - Eliminar un cliente.");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 9:
                    if (t != null) {
                        c.backup();
                        System.out.print("9. - Crear unha copia de seguriadade dos datos (Explícase máis abaixo).");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 10:
                    c.leerTitulares();
                    System.out.print("10. - Ler os titulares do periódico El País. (Explícase máis abaixo)");
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
