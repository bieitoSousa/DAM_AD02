package app.AD02;
public class Cliente {
	    
    String nomCliente;
    int idCliente;
    String mailCliente;
    String apellidoCliente;    
    private static int count;

    public Cliente(String nomCliente,String apellidoCliente, String mailCliente ) {
        this.nomCliente = nomCliente;
        this.idCliente = count++;
        this.mailCliente = mailCliente;
        this.apellidoCliente = apellidoCliente;
    }

    public String getNomCliente() {
        return nomCliente;
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getMailCliente() {
        return mailCliente;
    }

    public void setMailCliente(String mailCliente) {
        this.mailCliente = mailCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }
	


}
