package app.AD02;

import java.util.InputMismatchException;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

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
        Compania c = Compania.getInstance();
        Tienda t = null;
        while (!salir) {
            String encabezado="";
            if(c != null){encabezado += "\nBienvenidos a la franquicia  "+c.toString();}
            if(t != null){
                encabezado += "\nTienda selecionada "+t.toString();
                     }else {
                         if(!c.mapTienda.isEmpty()){
                             encabezado += "\n Porfavor cree o seleccione una tienda.";
                            }else{
                                    encabezado += "\n Porfavor cree  una tienda";
                     }   
            }
            System.out.println(
                            encabezado
                            +"\n1. - Selecionar una tenda.\n"
                            + "2. - Engadir unha tenda.\n"
                            + "3. - Eliminar unha tenda (elimínanse tódolos productos e empragados desta).\n"
                            + "4. - Engadir un producto a tenda.\n" + "5. - Eliminiar un producto a tenda.\n"
                            + "6. - Engadir un empregado a tenda.\n" + "7. - Eliminar un empregado a tenda.\n"
                            + "8. - Engadir un cliente.\n" + "9. - Eliminar un cliente.\n"
                            + "10. - Crear unha copia de seguriadade dos datos .\n"
                            + "11. - Ler os titulares do periódico El País. \n"
                            + "0. - Sair do programa.\n"
            );

            try {
                op = reader.nextInt();
                
                switch (op) {
                case 0:
                    salir = true;
                    break;
                case 1:
                c.viewTiendaList();
                System.out.println(" Seleccione una tienda : .\n");
                String nomb = HelpFunctions.inputString("digame el nombre de la tienda ? ");

                if(c.mapTienda.containsKey(nomb)){
                    c.setTSelecct(c.getTienda(nomb));
                    t=c.getTSelecct();
                    System.out.println( "se ha seleccionado la tienda "+c.getTSelecct().toString()  );  
                }else{
                    System.out.println("valor incorrecto Tienda NO SELECIONADA");
                }
                break;    
                case 2:
                    System.out.println(" Creando una tienda dime: .\n");
                     String nom = HelpFunctions.inputString("nombre ? ");
                     String ciu = HelpFunctions.inputString("cidade ? ");
                     if(HelpFunctions.whiteSpace(nom) && HelpFunctions.whiteSpace(ciu)){
                        c.viewTiendaList();
                        c.addTienda(nom,ciu);
                        c.setTSelecct(c.getTienda(nom));
                        t=c.getTSelecct();
                        System.out.print("Se a creado unha tenda:\n" + t.toString());
                     }
                    break;
                case 3:
                    if (t != null) {
                        c.viewTiendaList();
                        String nomTienda = HelpFunctions.inputString(" introduzca nombre de la tienda.\n");
                        if(c.mapTienda.containsKey(nomTienda)){
                            c.deleteTienda(nomTienda);
                            System.out.print(" Se ha eliminado los productos y empleados de la tienda" + nomTienda + ").\n");
                        }else{ System.out.println("valor incorrecto los productos y empleados de la Tienda NO ELIMINADOS");}
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 4:
                    if (t != null) {
                        c.viewCatProducto();
                        t.viewProductosList();
                        int  idProducto = HelpFunctions.inputInt(" introduzca id del producto.\n");
                        if(c.catalogoProductos.containsKey(idProducto)){
                            t.addProducto(idProducto);
                            System.out.print(" SE ha añadido un producto a de la tienda : "+ t +" .\n");
                        }else{
                            System.out.print(" valor incorrecto PRODUCTO NO AÑADIDO.\n");
                        }
                       
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 5:
                    if (t != null) {
                        t.viewProductosList();
                        int  idProducto = HelpFunctions.inputInt(" introduzca id del producto.\n");
                        if(t.mapProducto.containsKey(idProducto)){
                            t.deleteProducto(idProducto);
                        System.out.print("Se a eliminado un producto de la tienda : "+ t +" .\n");
                        }else{
                            System.out.print(" valor incorrecto PRODUCTO NO elimniado.\n");
                        }
                       
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 6:
                    if (t != null) {
                        t.viewEmpregadoList();
                        String nomEmp = HelpFunctions.inputString(" introduzca nombre del empleado.\n");
                        String apelEmp = HelpFunctions.inputString(" introduzca apellido del empleado.\n");
                        if(HelpFunctions.whiteSpace(nomEmp) && HelpFunctions.whiteSpace(apelEmp)){
                        t.addEmpregado(nomEmp, apelEmp);                      
                        System.out.print("Se añadido un empleado.\n");
                        }
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 7:
                    if (t != null) {
                        t.viewEmpregadoList();
                        String nomEmp =  HelpFunctions.inputString(" introduzca nombre del empleado.\n");
                        if(t.mapEmpleado.containsKey(nomEmp)){
                            t.deleteEmpregado(nomEmp);
                        System.out.print("Se a eliminado el empleado de la tienda : "+ t +" .\n");
                        }else{
                            System.out.print(" valor incorrecto EMPLEADO NO elimniado.\n");
                        }
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 8:
                    if (t != null) {
                        t.viewClienteList();
                        String nomCli = HelpFunctions.inputString(" introduzca nombre del cliente.\n");
                        String apelCli = HelpFunctions.inputString(" introduzca apellido del cliente.\n");
                        String mailCli = HelpFunctions.inputString(" introduzca email del cliente.\n");
                        if(HelpFunctions.whiteSpace(nomCli) && HelpFunctions.whiteSpace(apelCli)&& HelpFunctions.whiteSpace(mailCli)){
                        t.addCliente(nomCli, apelCli, mailCli);
                        System.out.print(" Se ha añadido un cliente.");
                        }
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 9:
                    if (t != null) {
                        t.viewClienteList();
                        String nomCli = HelpFunctions.inputString(" introduzca nombre del cliente.\n");
                        if(t.mapCliente.containsKey(nomCli)){
                            t.deleteCliente(nomCli);
                        System.out.print("Se a eliminado el Cliente de la tienda : "+ t +" .\n");
                        }else{
                            System.out.print(" valor incorrecto CLIENTE NO elimniado.\n");
                        }
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 10:
                    if (t != null) {
                        c.backup();
                        System.out.print(" copia de seguriadade dos datos creada  .");
                    } else {
                        System.out.print("Primero deves de crear una tienda");
                    }
                    break;
                case 11:
                    
                    System.out.print("10. - Ler os titulares do periódico El País. ");
                    c.leerTitulares();
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
