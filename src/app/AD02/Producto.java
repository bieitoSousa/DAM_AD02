package app.AD02;
public class Producto {
    int idProducto;
    String nombre;
    int prezo; 
    int cantidade;


    public Producto(int idProducto, String nombre, int prezo) {
        this.idProducto = idProducto;
        this.nombre = nombre;
        this.prezo = prezo;
        
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrezo() {
        return prezo;
    }

    public void setPrezo(int prezo) {
        this.prezo = prezo;
    }

    public int getCantidade() {
        return cantidade;
    }

    public void setCantidade(int cantidade) {
        this.cantidade = cantidade;
    }


}
