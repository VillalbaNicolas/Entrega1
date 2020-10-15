public class Velero extends Barco {

    public int mastil;
    static final String tipo = "Velero";

    public Velero(int eslora, int matricula, int añoFabricacion, int mastil){
        super(eslora, matricula, añoFabricacion,tipo);
        this.mastil = mastil;

    }

}
