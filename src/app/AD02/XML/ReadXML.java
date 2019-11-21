package app.AD02.XML;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class ReadXML {
    // public static void main(String[] args) throws Exception{
    // try {
    //     SAXParserFactory spf = SAXParserFactory.newInstance();
    //     SAXParser sp = spf.newSAXParser();
    //     File f = new File (".\\src\\app\\AD02\\XML\\XML_tarea.xml");
    //     TitularHandlet th = new TitularHandlet();
    //     sp.parse(f,th);
    //     ArrayList<Titulo> titulos = th.getTitulos();      
    //     for (Titulo t : titulos){
    //         System.out.println(t);
    //     }
    //   } catch (Exception e) {
    //       //TODO: handle exception
    //   } 
    // }

	public static void read() {
        try {
            SAXParserFactory spf = SAXParserFactory.newInstance();
            SAXParser sp = spf.newSAXParser();
            File f = new File (".\\src\\app\\AD02\\XML\\XML_tarea.xml");
            TitularHandlet th = new TitularHandlet();
            sp.parse(f,th);
            ArrayList<Titulo> titulos = th.getTitulos();
            
            for (Titulo t : titulos){
                System.out.println(t);
            }
    
    
          } catch (Exception e) {
              //TODO: handle exception
          } 

	}
}
