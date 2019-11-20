package app.AD02;

import java.util.ArrayList;
import java.util.Stack;
import java.util. *;
import app.AD02. *;

public class Tienda extends Compania {
    Tienda tSelecct = null;
    LinkedHashMap<String, Empleado> mapEmpleado = new LinkedHashMap<>();
    LinkedHashMap<Integer, Producto> mapProducto = new LinkedHashMap<>();
    LinkedHashMap<String, Cliente> mapCliente = new LinkedHashMap<>();

    private String nombre;
    private String ciudad;


    public Tienda(String nom, String cidade) {
        this.nombre = nom;
        this.ciudad = cidade;
    }

    public void deleteAllEmpleado() {
        mapEmpleado.clear();

    }
    public void deleteAllProductos() {
        mapProducto.clear();
    }

    /* Operaciones Producto  [  int idProducto;
     							String nombre;
     							int prezo; 
     							int cantidade;] 
	 */
    public void addProducto(int idProducto) { // introduzco en mi mapaProductos un objeto del catalogo de la Compañia
        mapProducto.put(new Integer(idProducto), (Producto)catalogoProductos.get(new Integer(idProducto)));
    }

    public void setProductoCantidad(int idProducto, int cantidade) {
        mapProducto.get(idProducto).setCantidade(cantidade);
    }

    public void deleteProducto(int idProducto) {
        mapProducto.remove(idProducto);
    }

    // Recorriendo los mapas


    public void viewProductosList() {
        System.out.println("Los Productos de la tienda "+this.nombre+"son :");
        for (int k : mapProducto.keySet()) {
            System.out.println(k + ". " + mapProducto.get(k).getNombre() + " (" + mapProducto.get(k).getPrezo() + ")");
        }
        System.out.println("_____________________________________________________");
    }
    public void viewEmpregadoList() {
        System.out.println("Los Empleados de la tienda "+this.nombre+"son :");
        for (String k : mapEmpleado.keySet()) {
            System.out.println(k + ". " + mapEmpleado.get(k).getNomEmpleado() + " (" + mapEmpleado.get(k).getApellidoEmpleado() + ")");
        }
        System.out.println("_____________________________________________________");
    }
    public void viewClienteList() {
        System.out.println("Los Clientes de la tienda "+this.nombre+"son :");
        for (String k : mapCliente.keySet()) {
            System.out.println(k + ". " + mapCliente.get(k).getNomCliente() + " (" + mapCliente.get(k).getMailCliente() + ")");
        }
        System.out.println("_____________________________________________________");
    }

    /*Operaciones Empleado [    
	 							int idEmpleado;
     							String nomEmpleado;
     							String apellidoEmpleado; 
     						] 
	 */

    public void addEmpregado(String nomEmp, String apelEmp) {
        mapEmpleado.put(nomEmp, new Empleado(nomEmp, apelEmp));
    }


    public void deleteEmpregado(String nomEmp) {
        mapEmpleado.remove(nomEmp);
    }

    // /*Operaciones Cliente [
    // int idCliente;
    // String nomCliente;
    // String apellidoCliente;
    // String mailCliente
    // ]
    // */

    public void addCliente(String nomCli, String apelCli, String mailCli) {
        mapCliente.put(nomCli, new Cliente(nomCli, apelCli, mailCli));
    }

    public void deleteCliente(String nomCli) {
        mapCliente.remove(nomCli);
    }
    // // to get
    public String getNombre() {
        return nombre;
    }

    public String getCiudad() {
        return ciudad;
    }


    // // to set
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String toString(){
        return "nombre => ["+this.nombre + "]  ciudad => ["+this.ciudad+"]";
    }

}

