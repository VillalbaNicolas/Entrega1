import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

    public static void main(String[] args) {
        String nomMeses[] = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        Especiales esp1 = new Especiales(12, 15159, 1998, 795, 5, 2);
        Especiales esp2 = new Especiales(11, 8585, 1999, 1200, 15, 4);
        Especiales esp3 = new Especiales(10, 4225, 2010, 1024, 9, 3);
        Especiales esp4 = new Especiales(15, 9758, 2005, 500, 2, 1);
        Especiales esp5 = new Especiales(19, 6325, 1995, 650, 4, 2);
        Especiales esp6 = new Especiales(5, 9898, 1985, 700, 1, 2);

        Cliente cli1 = new Cliente(15, "nicolas", "villalba", 37840383, esp1);
        Cliente cli2 = new Cliente(10, "nini", "modo", 39658248, esp2);
        Cliente cli3 = new Cliente(5, "lalolanda", "nicolaquiere", 348569741, esp3);
        Cliente cli4 = new Cliente(2, "fulano", "uno", 37840383, esp4);
        Cliente cli5 = new Cliente(9, "rodrigo", "bueno", 42858963, esp5);
        Cliente cli6 = new Cliente(4, "sol", "yeti", 39687451, esp6);

        Alquiler alq1 = new Alquiler("2020-1-20", "2020-1-26", 2, cli1, esp1);
        Alquiler alq2 = new Alquiler("2020-2-10", "2020-2-11", 5, cli3, esp3);
        Alquiler alq3 = new Alquiler("2020-3-5", "2020-3-9", 6, cli4, esp4);
        Alquiler alq4 = new Alquiler("2020-4-6", "2020-4-12", 4, cli2, esp2);
        Alquiler alq5 = new Alquiler("2020-5-1", "2020-5-22", 3, cli5, esp5);
        Alquiler alq6 = new Alquiler("2020-6-18", "2020-6-25", 11, cli6, esp6);
        Alquiler alq7 = new Alquiler("2020-7-2", "2020-7-11", 1, cli6, esp6);
        Alquiler alq8 = new Alquiler("2020-8-1", "2020-8-10", 5, cli5, esp5);
        Alquiler alq9 = new Alquiler("2020-9-4", "2020-9-19", 11, cli2, esp2);
        Alquiler alq10 = new Alquiler("2020-10-11", "2020-10-27", 10, cli3, esp3);
        Alquiler alq11 = new Alquiler("2020-11-4", "2020-11-19", 11, cli2, esp2);
        Alquiler alq12 = new Alquiler("2020-12-11", "2020-12-12", 10, cli3, esp3);

        ArrayList<Alquiler> alquiler = new ArrayList();
        alquiler.add(alq1);

        alquiler.add(alq2);
        alquiler.add(alq3);
        alquiler.add(alq4);
        alquiler.add(alq5);
        alquiler.add(alq6);
        alquiler.add(alq7);
        alquiler.add(alq8);
        alquiler.add(alq9);
        alquiler.add(alq10);
        alquiler.add(alq11);
        alquiler.add(alq12);


        int promAlquil[] = PromAlq(alquiler, nomMeses);

        int promAnual = PromAño(promAlquil);

        int maxAlquil[] = MaxPrice(alquiler, nomMeses);

        int maxAnual = MaxAño(maxAlquil);

        int minAlquil[] = MinPrice(alquiler, nomMeses);

        int minAnual = MinAño(minAlquil, maxAnual);


        for (int i = 0; i < nomMeses.length; i++)
        {
            System.out.println("El mes de  " + nomMeses[i] + "    el promedio de alquiler fue de:  " + promAlquil[i] + "    lo maximo que se pago fue de   " + maxAlquil[i] +
                    "   y lo que menos se pago fue de:   "  + minAlquil[i] + "\n");
        }
        System.out.println("\nEl promedio Anual fue de:   " + promAnual + "     El alquiler mas alto fue de:    " + maxAnual + "     Y el menor de todos fue de:   " + minAnual);
    }





        public static int[] MaxPrice(ArrayList<Alquiler> alquiler, String nomMeses[])
        {
            int maxAlquileres[] = new int[12];
            int max;

            for (int i = 0; i < nomMeses.length; i++)
            {
                Calendar inicio = new GregorianCalendar(2020, i, 1);
                Calendar fin = new GregorianCalendar(2020, i, 30);
                max = 0;

                for (int j = 0; j < alquiler.size(); j++)
                {
                    Calendar fecha = alquiler.get(j).FIstart();

                    if ((fecha.getTime().after(inicio.getTime()) || fecha.getTime().equals(inicio.getTime())) &&
                            ((fecha.getTime().before(fin.getTime())) || fecha.getTime().equals(inicio.getTime())))
                    {
                        if (max < alquiler.get(j).pago())
                        {
                            max = alquiler.get(j).pago();
                        }
                    }
                    else {
                        continue;
                    }
                }
                maxAlquileres[i] = max;
            }
            return maxAlquileres;
        }


        public static int[] MinPrice(ArrayList<Alquiler> alquiler, String nomMeses[])
        {
            int menorAlq[] = new int[12];
            int menor;

            for (int i = 0; i < nomMeses.length; i++) {
                Calendar inicio = new GregorianCalendar(2020, i, 1);
                Calendar fin = new GregorianCalendar(2020, i, 30);
                menor = 9999999;

                for (int j = 0; j < alquiler.size(); j++)
                {
                    Calendar fecha = alquiler.get(j).FIstart();

                    if ((fecha.getTime().after(inicio.getTime()) || fecha.getTime().equals(inicio.getTime())) &&
                            ((fecha.getTime().before(fin.getTime())) || fecha.getTime().equals(inicio.getTime())))
                    {

                        if (menor > alquiler.get(j).pago())
                        {
                            menor = alquiler.get(j).pago();
                        }
                        else {
                            continue;
                        }
                    }
                }
                if (menor != 9999999 || menor ==0)
                {
                    menorAlq[i] = menor;
                }
                else {
                    menorAlq[i] = 0;

                }


            }
            return menorAlq;
        }



        public static int[] PromAlq(ArrayList<Alquiler> alquiler, String nomMeses[])
        {
            int promAlquiler[] = new int[12];
            int sumatoria;


            for (int i = 0; i < nomMeses.length; i++)
            {
                Calendar inicio = new GregorianCalendar(2020, i, 1);
                Calendar fin = new GregorianCalendar(2020, i, 30);
                sumatoria = 0;
                int contador = 0;
                for (int j = 0; j < alquiler.size(); j++)
                {
                    Calendar fecha = alquiler.get(j).FIstart();

                    if ((fecha.getTime().after(inicio.getTime()) || fecha.getTime().equals(inicio.getTime())) &&
                            ((fecha.getTime().before(fin.getTime())) || fecha.getTime().equals(inicio.getTime())))
                    {
                        sumatoria += alquiler.get(j).pago();
                        contador++;




                    } else {
                        continue;
                    }
                }
                if (sumatoria != 0)
                promAlquiler[i] = (sumatoria / contador);
                else
                    promAlquiler[i] = 0;
            }
            return promAlquiler;
        }

    public static int PromAño(int prom[])
    {
        int promedio = 0;

        for (int i = 0; i < prom.length; i++)
        {
            promedio += prom[i];
        }
        return (promedio / 12);
    }


    public static int MaxAño(int maxAlquil[])
    {
        int max = 0;

        for (int i = 0; i < maxAlquil.length; i++)
        {
            if (max < maxAlquil[i]) {
                max = maxAlquil[i];
            }
            else {
                continue;
            }
        }
        return max;
    }

    public static int MinAño(int minAlquiler[], int maxAnual)
    {
        int min = 0;


        for (int i = 0; i < minAlquiler.length; i++)
        {

            if(i == 0)
            {
                if (maxAnual > minAlquiler[i])
                {
                    min = minAlquiler[i];

                }
            }
            else if (i > 0){
                if (min > minAlquiler[i])
                {
                    min = minAlquiler[i];


                }
                else
                    continue;


            }
        }
        return min;
    }








    }



