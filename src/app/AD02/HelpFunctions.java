package app.AD02;

import java.lang.reflect.Array;
import app.AD02.*;
import java.util.*;
import java.io.*;

public class HelpFunctions {
    


    // public static void main(String[] args) throws Exception {
    //    int letra1 = inputInt("dimeletra 1");
    //    int letra2 = inputInt("dimeletra 1");
    //    int letra3 = inputInt("dimeletra 1");
    //    int letra4 = inputInt("dimeletra 1");
    //    System.out.println(letra1+letra2+letra3+letra4);
  

    // }



    // public static int inputInt(String mensaje) {
    //     Scanner reader = new Scanner(System.in); // Invocamos un método sobre un objeto Scanner
    //     int op = -1;

    //     boolean salir = false;
    //     while (!salir) {
    //         System.out.println(mensaje);
    //         try {
    //             op = reader.nextInt();
    //         } catch (InputMismatchException e) {
    //             System.out.println("Debes insertar un número");
    //             reader.next();
    //         } catch (Exception f) {
    //             f.getMessage();
    //         }
    //         salir = true;
    //     }
    //     reader.close(); // Cerramos el objeto Scanner

    //     return op;
    // }

    public static String inputString(String mensaje) {
        Scanner reader = new Scanner(System.in);
        System.out.print(mensaje);
    
        while (!reader.hasNextLine()) {
            System.out.print(mensaje);
            reader.next();
        }
        return reader.nextLine();
    }
        //reader.close(); // Cerramos el objeto Scanner

    public static int inputInt(String mensaje) {
            Scanner reader = new Scanner(System.in);
            System.out.print(mensaje);
        
            while (!reader.hasNextInt()) {
                System.out.print(mensaje);
                reader.next();
            }
            return reader.nextInt();
        }

    public static void writeOnFile(File f, String[] lineas) {
        FileWriter fichero = null;
        PrintWriter pw = null;
        try {
            fichero = new FileWriter(f);
            // Escribimos linea a linea en el fichero
            for (String linea : lineas) {
                fichero.write(linea + "\n");
            }

        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void writeNextOnFile(File f, String[] lineas) {
        FileWriter fichero = null;
        try {
            fichero = new FileWriter(f,true);
            // Escribimos linea a linea en el fichero
            for (String linea : lineas) {
                fichero.write(linea + "\n");
            }

        } catch (Exception ex) {
            System.out.println("Mensaje de la excepción: " + ex.getMessage());
        
        } finally {
            try {
                // Nuevamente aprovechamos el finally para
                // asegurarnos que se cierra el fichero.
                if (null != fichero)
                    fichero.close();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void readonOnFile(File fichero) {

        // Fichero del que queremos leer
        //File fichero = new File("urlFichero");
        Scanner s = null;

        try
        {
            // Leemos el contenido del fichero
            System.out.println("... Leemos el contenido del fichero ...");
            s = new Scanner(fichero);

            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                String linea = s.nextLine(); // Guardamos la linea en un String
                System.out.println(linea); // Imprimimos la linea
            }

        }catch(
        Exception ex)
        {
            System.out.println("Mensaje: " + ex.getMessage());
        }finally
        {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
    }


    public static String[] readonOnFile(File fichero,boolean bool) {

        // Fichero del que queremos leer
        //File fichero = new File("urlFichero");
        Scanner s = null;
        String arry[] = null; 
        List<String> lineas = new ArrayList<String>(); 

        try
        {
            // Leemos el contenido del fichero
            System.out.println("... Leemos el contenido del fichero ...");
            s = new Scanner(fichero);

            // Leemos linea a linea el fichero
            while (s.hasNextLine()) {
                String linea = s.nextLine(); // Guardamos la linea en un String
                if (bool){
                lineas.add(linea);
               }else {
                System.out.println(linea); // Imprimimos la linea
               } 
            }

        }catch(
        Exception ex)
        {
            System.out.println("Mensaje: " + ex.getMessage());
        }finally
        {
            // Cerramos el fichero tanto si la lectura ha sido correcta o no
            try {
                if (s != null)
                    s.close();
            } catch (Exception ex2) {
                System.out.println("Mensaje 2: " + ex2.getMessage());
            }
        }
         arry = lineas.toArray(new String[lineas.size()]);
        return arry;
    }

}

