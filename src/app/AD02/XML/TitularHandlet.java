package app.AD02;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class TitularHandlet extends DefaultHandler{

	// private ArrayList<Version> versiones = new ArrayList();
    // private Version version;
    // private StringBuilder buffer=new StringBuilder();

    // public ArrayList<Version> getVersiones() {
    //     return versiones;
    // }
    
    
    
    // @Override
    // public void characters(char[] ch, int start, int length) throws SAXException {
    //     buffer.append(ch,start, length);
    // }

    // @Override
    // public void endElement(String uri, String localName, String qName) throws SAXException {
    //     switch(qName){
    //         case "nombre":
    //             version.setNombre(buffer.toString());
    //             break;
    //         case "api":
    //             version.setApi(Integer.parseInt(buffer.toString()));
    //             break;
            
    //     }
    // }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "title":
          System.out.println( uri);
                break;
           
        }
    }
    



}