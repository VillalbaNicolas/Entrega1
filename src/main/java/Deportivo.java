public class Deportivo extends Barco {

    public int potencia;
    static final String tipo = "Deportivo";

    public  Deportivo (int eslora, int matricula, int añoFabricacion, int potencia){
        super(eslora, matricula, añoFabricacion, tipo);
        this.potencia = potencia;
    }

}
