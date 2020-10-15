 public class Especiales extends Barco {

        private int potencia;
        private int camarotes;
        private int mastiles;
        static final String tipo = "Especial";

        public Especiales(int eslora, int matricula, int añoFabric, int potencia, int camarotes, int mastiles){
            super(eslora, matricula, añoFabric, tipo);
            this.potencia = potencia;
            this.camarotes = camarotes;
            this.mastiles = mastiles;

        }

}
