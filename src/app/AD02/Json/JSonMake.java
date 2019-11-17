package app.AD02.Json;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.File;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonPrimitive;
import java.util.Map.Entry;
import app.AD02.*;

public class JSonMake {
    public static void main(String args[]) {

        File filedatos = new File(".\\src\\app\\AD02\\archivos\\" + "datos.json");
        try {
            readAsString_Json(filedatos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void readAsString_Json(File fileJson)throws java.io.IOException 
    {
        JsonParser parser = new JsonParser();
        
        FileReader fr = new FileReader(fileJson);
        JsonElement datos = parser.parse(fr);
        dumpJSONElement(datos);
    }
 
    public static void dumpJSONElement(JsonElement elemento) {
        if (elemento.isJsonObject()) {
            System.out.println("Es objeto");
            JsonObject obj = elemento.getAsJsonObject();
            java.util.Set<java.util.Map.Entry<String,JsonElement>> entradas = obj.entrySet();
            java.util.Iterator<java.util.Map.Entry<String,JsonElement>> iter = entradas.iterator();
            while (iter.hasNext()) {
                java.util.Map.Entry<String,JsonElement> entrada = iter.next();
                System.out.println("Clave: " + entrada.getKey());
                System.out.println("Valor:");
                dumpJSONElement(entrada.getValue());
            }
     
        } else if (elemento.isJsonArray()) {
            JsonArray array = elemento.getAsJsonArray();
            System.out.println("Es array. Numero de elementos: " + array.size());
            java.util.Iterator<JsonElement> iter = array.iterator();
            while (iter.hasNext()) {
                JsonElement entrada = iter.next();
                dumpJSONElement(entrada);
            }
        } else if (elemento.isJsonPrimitive()) {
            System.out.println("Es primitiva");
            JsonPrimitive valor = elemento.getAsJsonPrimitive();
            if (valor.isBoolean()) {
                System.out.println("Es booleano: " + valor.getAsBoolean());
            } else if (valor.isNumber()) {
                System.out.println("Es numero: " + valor.getAsNumber());
            } else if (valor.isString()) {
                System.out.println("Es texto: " + valor.getAsString());
            }
        } else if (elemento.isJsonNull()) {
            System.out.println("Es NULL");
        } else {
            System.out.println("Es otra cosa");
        }
    }
    
    public static void ObjJsontoString( Object obj ){
        Gson gson = new Gson();
        System.out.println(gson.toJson(obj));
    }


    public static void WriteObjJsonInFile( File objectFile , Object obj){
        Gson gson = new Gson();

        // Java objects to String
        // String json = gson.toJson(staff);

        // Java objects to File
         try (FileWriter writer = new FileWriter(objectFile)) {
             gson.toJson(obj, writer);
         } catch (IOException e) {
             e.printStackTrace();
         }

       // System.out.println(gson.toJson(obj));



    }

    public static Object ReadObjJsonInFile( File objectFile){
        Gson gson = new Gson();
        Object obj = null ;
        try (Reader reader = new FileReader(objectFile)) {
            // Convert JSON File to Java Object
            obj = gson.fromJson(reader,Object.class );
            // print staff object
            System.out.println(obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }
    


public static Compania ReadObjJsonInFileCompania( File objectFile){
    Gson gson = new Gson();
    Compania obj = null ;
    try (Reader reader = new FileReader(objectFile)) {
        // Convert JSON File to Java Object
        obj = gson.fromJson(reader,Compania.class );
        // print staff object
        System.out.println(obj);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return obj;
}

}



