package app.AD02.XML;

import java.util.ArrayList;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

class TitularHandlet extends DefaultHandler{

	 private ArrayList<Titulo> titulos = new ArrayList();
     //private Titulo titulo;
     private StringBuilder buffer=new StringBuilder();
     public ArrayList<Titulo> getTitulos() {
         return titulos;
     }
    
    
     @Override
     public void characters(char[] ch, int start, int length) throws SAXException {
         buffer.append(ch,start, length);
     }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        //cuando termine el titulo recoje la informacion del bufer
        switch(qName){
            case "title":
                titulos.add(new Titulo(buffer.toString()));
                break;        
         }
     }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case "title":
            //inicia el buffer
           
          System.out.println( uri);
                break;
           
        }
    }
    



}