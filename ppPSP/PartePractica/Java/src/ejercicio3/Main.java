package ejercicio3;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {
        //Random aleatorio = new Random();
        Cuerda cuerda = new Cuerda();
        Thread a = new Thread(new Equipo(LadoEquipo.A_IZQUIERDO, cuerda));
        Thread b = new Thread(new Equipo(LadoEquipo.B_DERECHO, cuerda));
        a.start();
        b.start();
        ScheduledExecutorService ses=Executors.newScheduledThreadPool(1);
        //ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
        ses.scheduleAtFixedRate(()->{
            String linea="";
            for(int i = 0; i <= 100; i++) {

                if(i==cuerda.getPosicion()){
                    linea+="P";//System.out.print("P");
                }else{
                    linea+="-";//System.out.print("-");
                }
                //linea+=i==cuerda.getPosicion()?"P":"-";
            }
            System.out.println(linea);
        },0,1, TimeUnit.SECONDS);
        while (!cuerda.hayGanador()){
            try {
                synchronized (cuerda) {
                    cuerda.wait();
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Hay ganador "+ cuerda.hayGanador());



        //t2.start();

    }
}
