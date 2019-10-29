
package app;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.nio.file.FileSystem;
import java.util.ArrayList;

import javax.swing.ListModel;

public class FileManager {

    private File wS;
    private ArrayList<File> carpeta = new ArrayList<File>();

    /**
     * File(File parent, String child) __ Creates a new File instance from a parent
     * abstract pathname and a child pathname string. File(String pathname) __
     * Creates a new File instance by converting the given pathname string into an
     * abstract pathname. File(String parent, String child) __ Creates a new File
     * instance from a parent pathname string and a child pathname string. File(URI
     * uri) __ Creates a new File instance by converting the given file: URI into an
     * abstract pathname.
     */
    // ========================================================
    // = Manexo de FicheirosPáxina =
    // ========================================================

    public FileManager() {
        // creo una carpeta de trabajo

        if (myWorkSpace().mkdir()) {
            System.out.println(" La carpeta ha sido creada satisfactoriamente");
            this.wS = myWorkSpace();
        } else {
            System.out.println("Error la carpeta no se ha podido borrar");
        }
    }

    public File myWorkSpace() {
        String separardor = File.separator;
        File miDir = new File("." + separardor + "myWorkSpace" + separardor);
        try {
            System.out.println("Directorio actual CanonicalPath: " + miDir.getCanonicalPath());
            System.out.println("Directorio actual Path: " + miDir.getPath());
            System.out.println("Directorio actual AbsolutePath: " + miDir.getAbsolutePath());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return miDir;
    }

    public void viewDirectorio(File directorio) {
        String[] archivos = directorio.list();
        System.out.printf("Ficheiros do directorio %s : %d %n", directorio.getPath(), archivos.length);
        // Recorremos todolos arquivos para imprimir a sua informacion
        for (int i = 0; i < archivos.length; i++) {
            File archivoAux = new File(directorio.getPath(), archivos[i]);
            if (archivoAux.isFile())
                System.out.printf("Arquivo: %s %n", archivoAux.getName());
            else if (archivoAux.isDirectory())
                System.out.printf("Directorio: %s %n", archivoAux.getName());
        }
        System.out.printf("Ficheiros do directorio %s : %d %n", directorio.getPath(), archivos.length);
        // Recorremos todolos arquivos para imprimir a sua informacion
        for (int i = 0; i < archivos.length; i++) {
            File archivoAux = new File(directorio.getPath(), archivos[i]);
            if (archivoAux.isFile())
                System.out.printf("Arquivo: %s %n", archivoAux.getName());
            else if (archivoAux.isDirectory())
                System.out.printf("Directorio: %s %n", archivoAux.getName());
        }

    }

    public void addFileToWorkSpace(String name) throws IOException {
        File f = new File(wS, name);
        if (f.createNewFile()) {
            this.carpeta.add(f);
            System.out.println("El fichero" + f.getName() + " ha sido creado satisfactoriamente");
        } else {
            System.out.println("El fichero " + f.getName() + " no puede ser cerado");
        }
        /**
         * IOException - Si ocurrió un error de E / S SecurityException- Si existe un
         * administrador de seguridad y su SecurityManager.checkWrite(java.lang.String)
         * --- método niega el acceso de escritura al archivo
         */
    }

    public void deleteFileOnWorkSpace(File fichero) {
        if (fichero.delete()) {
            this.carpeta.remove((File) fichero);
            System.out.println("El fichero " + fichero.getName() + " ha sido borrado satisfactoriamente");
        } else {
            System.out.println("El fichero " + fichero.getName() + " no puede ser borrado");
        }
        /**
         * IOException - Si ocurrió un error de E / S SecurityException- Si existe un
         * administrador de seguridad y su SecurityManager.checkWrite(java.lang.String)
         * --- método niega el acceso de escritura al archivo
         */

    }

    // ========================================================
    // = Lectura e escritura de caracteres nun arquivoPáxina =
    // ========================================================

    public String showFiles() {
        int index = 0;
        String result = "";
        result = this.wS.getName() + "/n";
        do {
            File archivo = carpeta.get(index);
            result = result + archivo.getName() + "/n" + "|___";
            index++;
        } while (index == carpeta.size());
        return result;
    }

    public String readCharFile(File arquivo) {
        // Vamos comezar declarando o ficheiro
        String result = "";
        try {

            // Creamos un fluxo de entrada para o arquivo
            FileReader fluxoDatos;
            fluxoDatos = new FileReader(arquivo);

            // Imos lendo caracter a caracter
            int caracter;
            while ((caracter = fluxoDatos.read()) != -1) {
                result = result + (char) caracter;
            }
            // Temos que cerrar sempre o ficheiro
            fluxoDatos.close();

        } catch (FileNotFoundException e) {
            System.out.println("Non se encontra o arquivo");
        } catch (IOException e) {
            System.out.println("Erro de entrada saída");
        }
        if (result == "") {
            return "fichero vacio";
        }
        return result;
    } // fin de readCharFile

    public void writeCharFile(File arquivo, String datosAGardar) {
        try {
            // Creamos o fluxo de saida
            FileWriter fluxoDatos = new FileWriter(arquivo);

            // Transformamos a cadea nun array de caracteres
            char[] caracteres = datosAGardar.toCharArray();

            // Imos escribindo caracter a caracter
            for (int i = 0; i < caracteres.length; i++) {
                fluxoDatos.write(caracteres[i]);
            }

            // Cerramos o arquivo
            fluxoDatos.close();
        } catch (IOException e) {
            System.out.println("Non se pode escribir no arquivo");
        }
    }

    public String readLineFile(File arquivo) {
        String result = "";

        try {

            // Creamos un fluxo de entrada para o arquivo
            FileReader fluxoDatos;
            fluxoDatos = new FileReader(arquivo);

            // Creamos o bufer de entrada
            BufferedReader buferEntrada = new BufferedReader(fluxoDatos);

            // Imos lendo linea a linea
            String linea;
            int numeroLinea = 1;
            while ((linea = buferEntrada.readLine()) != null) {
                result = result + linea + "\n";
                numeroLinea++;
            }

            // Temos que cerrar sempre o ficheiro
            buferEntrada.close();

        } catch (FileNotFoundException e) {
            System.out.println("Non se encontra o arquivo");
        } catch (IOException e) {
            System.out.println("Erro de entrada saída");
        }
        return result;
    }

    public void writeLineFile(File arquivo, String datosAGardar[]) {

        try {
            // Creamos o fluxo de saida
            FileWriter fluxoDatos = new FileWriter(arquivo);
            BufferedWriter buferSaida = new BufferedWriter(fluxoDatos);

            // Imos escribindo caracter a caracter
            for (int i = 0; i < datosAGardar.length; i++) {
                buferSaida.write(datosAGardar[i]);
                buferSaida.newLine();
            }

            // Cerramos o arquivo
            buferSaida.close();
        } catch (IOException e) {
            System.out.println("Non se pode escribir no arquivo");
        }
    }

    // ========================================================
    // = Lectura e escritura de arquivos binariosPáxina =
    // ========================================================

    public void readBinaryFile(File arquivo) {
        try {

            // Creamos un fluxo de entrada para o arquivo
            FileInputStream fluxoDatos;
            fluxoDatos = new FileInputStream(arquivo);

            // Imos lendo byte a byte
            int datobyte;
            while ((datobyte = fluxoDatos.read()) != -1) {
                System.out.print(datobyte);
            }

            // Temos que cerrar sempre o ficheiro
            fluxoDatos.close();
        } catch (FileNotFoundException e) {
            System.out.println("Non se atopa o archivo");
        } catch (IOException e) {
            System.out.println("Non se poido escribir no arquivo");
        }
    }

    public void writeBinaryFile(File arquivo) {
        try {
            // Creamos un fluxo de saida para o arquivo
            FileOutputStream fluxoDatos;
            fluxoDatos = new FileOutputStream(arquivo);

            // Imos escribir 100 bytes
            for (int i = 0; i < 100; i++) {
                fluxoDatos.write(i);
            }

            // Temos que cerrar sempre o ficheiro
            fluxoDatos.close();

        } catch (IOException e) {
            System.out.println("Non se poido escribir no arquivo");
        }
    }

    public void writeDateFile(ArrayList<Object> objList) {
        // creas las instancias del objeto en un array
        // ArrayList<Object> objList = new ArrayList<Object>();
        // objList.add(new Object());
        // objList.add(new Object());
        // objList.add(new Object());
        // objList.add(new Object());

        try {
            // Vamos comezar declarando o ficheiro
            File arquivo = new File("data.dat");

            // Creamos un fluxo de saida para o arquivo
            FileOutputStream fileOut = new FileOutputStream(arquivo);
            DataOutputStream fluxoDatos = new DataOutputStream(fileOut);

            // Imos gardalos datos das persoas
            for (int i = 0; i < objList.size(); i++) {
                Object persoaAux = objList.get(i);
                fluxoDatos.writeUTF(persoaAux.toString());
                fluxoDatos.writeInt(persoaAux.hashCode());
            }

            // Temos que cerrar sempre o ficheiro
            fluxoDatos.close();

        } catch (IOException e) {
            System.out.println("Non se poido escribir no arquivo");
        }
    }

    public void readDateFile(ArrayList<Object> objList) {

        // ArrayList<Object> objList = new ArrayList<Object>();

        try {
            // Vamos comezar declarando o ficheiro
            File arquivo = new File("data.dat");

            // Creamos un fluxo de entrada para o arquivo
            FileInputStream fileIn = new FileInputStream(arquivo);
            DataInputStream fluxoDatos = new DataInputStream(fileIn);

            try {

                // lemos os datos e imolo gardando nun array
                while (true) {
                    // recuperamos parametros
                    String nomeAux = fluxoDatos.readUTF();
                    int idadeAux = fluxoDatos.readInt();
                    // asociamos parametros
                    Object objAux = new Object();
                    objList.add(objAux);

                }

                // Esta execepcion salta a ler ao rematar de lelo arquivo
            } catch (EOFException e) {
                System.out.println("Rematouse de ler o arquivo");
            }

            // Temos que cerrar sempre o ficheiro
            fluxoDatos.close();

            // Imprimimos por pantalla as persoas
            for (int i = 0; i < objList.size(); i++) {
                Object objAux = objList.get(i);
                System.out.println(objAux.toString() + " " + objAux.hashCode());
            }

        } catch (IOException e) {
            System.out.println("Rematouse de ler o arquivo");
        }
    }

    public void writeObjectFile(ArrayList<Object> listObject) { // pasamos un array de objetos serializables.

        // ArrayList<Object> listObject = new ArrayList<Object>();
        // listObject.add(new Object());
        // listObject.add(new Object());
        // listObject.add(new Object());
        // listObject.add(new Object());

        try {
            // Vamos comezar declarando o ficheiro
            File arquivo = new File("data.dat");

            // Creamos un fluxo de saida para o arquivo
            FileOutputStream fileOut = new FileOutputStream(arquivo);
            ObjectOutputStream fluxoDatos = new ObjectOutputStream(fileOut);

            // Imos gardalos persoas
            for (int i = 0; i < listObject.size(); i++) {
                Object objectAux = listObject.get(i);
                fluxoDatos.writeObject(objectAux);
            }

            // Temos que cerrar sempre o ficheiro
            fluxoDatos.close();

        } catch (IOException e) {
            System.out.println("Non se poido escribir no arquivo");
        }
    }

    public void readObjectFile(ArrayList<Object> listObject) {

        // ArrayList<Persoa> persoas = new ArrayList<Persoa>();

        try {
            // Vamos comezar declarando o ficheiro
            File arquivo = new File("data.dat");

            // Creamos un fluxo de entrada para o arquivo
            FileInputStream fileIn = new FileInputStream(arquivo);
            ObjectInputStream fluxoDatos = new ObjectInputStream(fileIn);

            try {

                // lemos os datos e imolo gardando nun array
                while (true) {

                    Object objAux = (Object) fluxoDatos.readObject();
                    listObject.add(objAux);

                }

                // Esta execepcion salta a ler ao rematar de lelo arquivo
            } catch (EOFException e) {
                System.out.println("Rematouse de ler o arquivo");
            } catch (ClassNotFoundException ex) {
                System.out.println("Non se atopa a clase");
            }

            // Temos que cerrar sempre o ficheiro
            fluxoDatos.close();

            // Imprimimos por pantalla as persoas
            for (int i = 0; i < listObject.size(); i++) {
                Object objAux = listObject.get(i);
                System.out.println(objAux.toString() + " " + objAux.hashCode());
            }

        } catch (IOException e) {
            System.out.println("Rematouse de ler o arquivo");
        }
    }

    // ========================================================
    // = Parsear ficheiros XML con SAXPáxina =
    // ========================================================

    // ========================================================
    // = Lectura e escritura de JSONPáxina =
    // ========================================================

}// fin de clase
