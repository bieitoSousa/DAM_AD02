package app.AD02;

import java.util.ArrayList;
import java.util.Stack;

public class Tienda extends Compañia{
Tienda t = null;
 ArrayList clientList;
 ArrayList productosList;
 ArrayList empleadosList;
 Stack<String[][]> STACK = new Stack<String[][]>(); 
  
	private String ciu;
	private String nom;


	public Tienda(String nom, String cidade) {
		this.nom = nom;
		this.ciu = cidade;
	}

	public static Tienda cargarTienda() {
		return null;
	}

	public void deleteTienda(String nom) {
	
	}

	public void addProducto(String idProducto) {
	 
	}

	public void setProducto(String idProducto, String descripción, int prezo, int cantidade) {
	}

	public void deleteProducto(String idProducto) {
	}



	public void viewEmpregadoList() {
	}

	public void viewProductosList() {
	}

	public void addEmpregado(String nomEmp, String apelEmp) {
	}

	public void setEmpleado(String nomEmp, String apelEmp) {
	}

	public void deleteEmpregado(String nomEmp) {
	}

	public void viewClienteList() {
	}

	public void addCliente(String nomCli, String apelCli, String mailCli) {
	}

	public void deleteCliente(String nomCli) {
	}

	public void backup() {
	}

}
