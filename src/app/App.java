package app;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner reader = new Scanner(System.in); // Invocamos un método sobre un objeto Scanner
        int op;
        boolean salir = false;
        Tienda t = Tienda.cargarTienda();
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
                    System.out.print(" nombre  ? .\n");
                    String nom = reader.nextLine();
                    System.out.print("cidade ? .\n");
                    String cidade = reader.nextLine();
                    t = new Tienda(nom, cidade);
                    System.out.print("Se a creado unha tenda:\n" + t.toString());
                    break;
                case 2:
                    if (t != null) {
                        System.out.print(" introduzca nombre de la tienda.\n");
                        String nomTienda = reader.nextLine();
                        t.deleteTienda(nomTienda);
                        System.out.print(" Se ha eliminado la tienda" + nomTienda + ").\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 3:
                    if (t != null) {
                        t.viewProductosList();
                        System.out.print(" introduzca id del producto.\n");
                        String idProducto = reader.nextLine();
                        // String descripción;
                        // int prezo;
                        // int cantidade;
                        t.addProducto(idProducto);
                        // t.setProducto(idProducto,descripción , prezo ,cantidade);
                        System.out.print(" SE ha engadir un producto a tenda.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 4:
                    if (t != null) {
                        t.viewProductosList();
                        System.out.print(" introduzca id del producto.\n");
                        String idProducto = reader.nextLine();
                        t.deleteProducto(idProducto);
                        System.out.print("4. - Eliminiar un producto a tenda.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 5:
                    if (t != null) {
                        t.viewEmpregadoList();
                        System.out.print(" introduzca nombre del empleado.\n");
                        String nomEmp = reader.nextLine();
                        System.out.print(" introduzca apellido del empleado.\n");
                        String apelEmp = reader.nextLine();
                        t.addEmpregado(nomEmp, apelEmp);
                        t.setEmpleado(nomEmp, apelEmp);
                        System.out.print("Se añadido un empleado.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 6:
                    if (t != null) {
                        t.viewEmpregadoList();
                        System.out.print(" introduzca nombre del empleado.\n");
                        String nomEmp = reader.nextLine();
                        t.deleteEmpregado(nomEmp);
                        System.out.print("6. - Eliminar un empregado a tenda.\n");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 7:
                    if (t != null) {
                        t.viewClienteList();
                        System.out.print(" introduzca nombre del cliente.\n");
                        String nomCli = reader.nextLine();
                        System.out.print(" introduzca apellido del cliente.\n");
                        String apelCli = reader.nextLine();
                        System.out.print(" introduzca email del cliente.\n");
                        String mailCli = reader.nextLine();
                        t.addCliente(nomCli, apelCli, mailCli);
                        System.out.print(" Se ha añadido un cliente.");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 8:
                    if (t != null) {
                        t.viewClienteList();
                        System.out.print(" introduzca nombre del cliente.\n");
                        String nomCli = reader.nextLine();
                        t.deleteCliente(nomCli);
                        System.out.print("8. - Eliminar un cliente.");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 9:
                    if (t != null) {
                        t.backup();
                        System.out.print("9. - Crear unha copia de seguriadade dos datos (Explícase máis abaixo).");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 10:
                    leerTitulares();
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

    private static void leerTitulares() {
        System.out.println("leyendo titulares");
    }

}
