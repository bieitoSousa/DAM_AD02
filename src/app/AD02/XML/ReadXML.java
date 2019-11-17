package app.AD02.XML;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.*;
import app.AD02.XML.*;
class ReadXML{
    public static void main(String[] args) {
       try {
        SAXParserFactory spf = SAXParserFactory.newInstance();
        SAXParser sp = spf.newSAXParser();
        File f = new File (".\\app\\AD02\\XML\\XML_tarea.xml");
        TitularHandlet th = new TitularHandlet();
        sp.parse(f,th);
      } catch (Exception e) {
          //TODO: handle exception
      } 
    }
}