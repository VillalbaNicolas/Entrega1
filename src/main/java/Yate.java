public class Yate extends Barco {

    public int potencia;
    public int camarotes;
    static final String tipo = "Yate";

    public Yate (int eslora, int matricula, int añoFabricacion, int potencia, int camarotes){
        super(eslora,matricula,añoFabricacion, tipo);
        this.potencia = potencia;
        this.camarotes = camarotes;

    }

}
