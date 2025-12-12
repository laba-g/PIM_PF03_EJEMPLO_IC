package ejercicio3;

import java.util.Random;

public class Equipo implements Runnable {
    Random r = new Random();

    LadoEquipo ladoEquipo;
    Cuerda cuerda;


    public Equipo(LadoEquipo ladoEquipo, Cuerda cuerda) {
        this.ladoEquipo = ladoEquipo;
        this.cuerda = cuerda;

    }

    @Override
    public void run() {
        Random r = new Random();
        while(cuerda.obtenerGanador()!= ladoEquipo){
            int fuerza = r.nextInt(0,2);
            //synchronized (cuerda) {
                cuerda.tirar(fuerza,ladoEquipo );
                //if(cuerda.hayGanador()){
                  //  cuerda.obtenerGanador();
                //}
            //}

        }
        synchronized (cuerda){
            cuerda.notify();
        }

    }
}















