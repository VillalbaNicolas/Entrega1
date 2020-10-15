public class Cliente {

    public int idCliente;
    public String nombre;
    public String apellido;
    public int dni;
    public Barco barco;


    public Cliente(int idCliente, String nombre, String apellido, int dni, Barco barco){

        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.barco = barco;

    }


    public int IdCliente(){
        return this.idCliente;
    }


}
