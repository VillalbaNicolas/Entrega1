import java.util.Calendar;
import java.util.GregorianCalendar;

public class Alquiler {

    public String dateStart;
    public String dateEnd;
    public int cantdias;
    public  int pago;
    public int posicionAlq;
    public Cliente cliente;
    public Barco barco;

    public Alquiler(String dateStart, String dateEnd, int posicionAlq, Cliente cliente, Barco barco ) {

        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.posicionAlq = posicionAlq;
        this.cliente = cliente;
        this.barco = barco;

    }
    private Calendar Transf(String fecha) {
        String fec [] = fecha.split("-");
        int dia = Integer.parseInt(fec[2]);
        int mes = Integer.parseInt(fec[1])-1;
        int año = Integer.parseInt(fec[0]);
        Calendar formatoFecha = new GregorianCalendar(año, mes, dia);
        return formatoFecha;
    }

    public Calendar FIstart() {
        return Transf(this.dateStart);
    }

    public Calendar FEnd() {
        return Transf(this.dateEnd);
    }


    public int calcularNumDias() {
        Calendar ini = Transf(this.dateStart);
        Calendar fi = Transf(this.dateEnd);
        int dias =  fi.get(Calendar.DATE) - ini.get(Calendar.DATE);
        return dias;
    }


    public int pago() {
        int dias = calcularNumDias();


        int pago = dias * (barco.eslora * 10) * 2;
        return pago;

    }


}
