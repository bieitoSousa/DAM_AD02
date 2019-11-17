package app.AD02;
import java.util. *;

import com.google.gson.annotations.JsonAdapter;

import java.io. *;
import app.AD02. *;
import app.AD02.archivos. *;
import app.AD02.Json.*;
import app.AD02.XML.*;


public class Compania {
    String name = "Franquicia bieito";
    LinkedHashMap<String, Tienda> mapTienda = new LinkedHashMap<>();
    LinkedHashMap < Integer, Producto > catalogoProductos = new LinkedHashMap<>();
    public static Tienda tiendaSeleccionada;
    private static Compania companiaAux;
    // Tienda tSelecct = null;
    static File f = new File(".//datos.backup");

    public Compania() {
        createCatalogoProd();
    }
    public static Compania getInstance() {
        recovery();
        if (companiaAux != null) {
            return companiaAux;
        }
        return new Compania();
    }

    public static void main(String[] args) {
        Compania c = getInstance();

        c.addTienda("4ttttt", "4Ccccc");
        c.addTienda("4tttttttt", "4cccc");
        c.addTienda("4tttttt", "4ccccc");
        c.viewTiendaList();
        c.backup();
    }

    public void backup() { // sobreescribo datos en : datos.backap
        JSonMake.WriteObjJsonInFile(f, this);
        // JSonMake.ObjJsontoString(mapTienda);
        System.out.println("sobreescribo datos en : datos.backup");

    }

    private static void recovery() {
        companiaAux = JSonMake.ReadObjJsonInFileCompania(f);
        // sobreescribo datos en : datos.backap
        System.out.println("recupero las tiendas de : datos.backup");
        // return companiaAux;

    }


    private void createCatalogoProd() {
        Producto p1 = new Producto(1, "a1", 11);
        catalogoProductos.put(new Integer(p1.getIdProducto()), p1);
        Producto p2 = new Producto(2, "a2", 12);
        catalogoProductos.put(new Integer(p2.getIdProducto()), p2);
        Producto p3 = new Producto(3, "a3", 13);
        catalogoProductos.put(new Integer(p3.getIdProducto()), p3);
        Producto p4 = new Producto(4, "a4", 14);
        catalogoProductos.put(new Integer(p4.getIdProducto()), p4);
        Producto p5 = new Producto(5, "a5", 15);
        catalogoProductos.put(new Integer(p5.getIdProducto()), p5);
        Producto p6 = new Producto(6, "a6", 16);
        catalogoProductos.put(new Integer(p6.getIdProducto()), p6);
        Producto p7 = new Producto(7, "a7", 17);
        catalogoProductos.put(new Integer(p7.getIdProducto()), p7);
        Producto p8 = new Producto(8, "a8", 18);
        catalogoProductos.put(new Integer(p8.getIdProducto()), p8);
        Producto p9 = new Producto(9, "a9", 19);
        catalogoProductos.put(new Integer(p9.getIdProducto()), p9);
        Producto p10 = new Producto(10, "b1", 20);
        catalogoProductos.put(new Integer(p10.getIdProducto()), p10);
        Producto p11 = new Producto(11, "b2", 21);
        catalogoProductos.put(new Integer(p11.getIdProducto()), p11);
    }

    Tienda addTienda(String nomTienda, String nomCidade) {
        Tienda ti = new Tienda(nomTienda, nomCidade);
        mapTienda.put(nomTienda, ti);
        return ti;
    }

    public void deleteTienda(String nomTienda) {
        Tienda t = getTienda(nomTienda);
        t.deleteAllEmpleado();
        t.deleteAllProductos();
    }

    public Tienda getTienda(String nomTienda) {
        return(Tienda)mapTienda.get(nomTienda);
    }

    public void viewTiendaList() {
        for (String k : mapTienda.keySet()) {
            System.out.println(k + ". " + mapTienda.get(k).getNombre() + " (" + mapTienda.get(k).getCiudad() + ")");
        }
    }


    public Tienda getTSelecct() {
        return tiendaSeleccionada;
    }

    public void setTSelecct(Tienda t) {
        tiendaSeleccionada = t;
    }
	public void leerTitulares() {
        ReadXML.main(args);
	}


}
