package app.AD02;
public class Producto {
    int idProducto;
    String nombre;
    int prezo; 
    int cantidade;


    public Producto(int idProducto, String nombre, int prezo, int cantidade) {
        this.idProducto = idProducto;
        this.nombre = descripción;
        this.prezo = prezo;
        this.cantidade = cantidade;
    }

    public String getIdProducto() {
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
