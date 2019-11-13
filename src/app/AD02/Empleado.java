package app.AD02;
public class Empleado {
   
    int count;                           
    int idEmpleado;                         
    String nomEmpleado;                      
    String apellidoEmpleado;

    public Empleado( String nomEmpleado, String apellidoEmpleado) {
        this.idEmpleado = count++;
        this.nomEmpleado = nomEmpleado;
        this.apellidoEmpleado = apellidoEmpleado;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNomEmpleado() {
        return nomEmpleado;
    }

    public void setNomEmpleado(String nomEmpleado) {
        this.nomEmpleado = nomEmpleado;
    }

    public String getApellidoEmpleado() {
        return apellidoEmpleado;
    }

    public void setApellidoEmpleado(String apellidoEmpleado) {
        this.apellidoEmpleado = apellidoEmpleado;
    }
    



}
