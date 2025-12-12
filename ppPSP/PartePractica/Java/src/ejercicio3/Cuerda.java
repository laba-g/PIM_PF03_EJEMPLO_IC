package ejercicio3;

public class Cuerda {

    private int posicion;
    private int fuerzaTotalA=0;
    private int fuerzaTotalB=0;
    //public Cuerda(int posicion) {}
    public void  setPosicion(int posicion) {this.posicion = posicion;}
    public synchronized int getPosicion() {return this.posicion;}


    public synchronized void tirar(int fuerza, LadoEquipo equipo) {
        if(equipo == LadoEquipo.A_IZQUIERDO) {
            fuerzaTotalA += fuerza;
        } else if (equipo== LadoEquipo.B_DERECHO) {
            fuerzaTotalB += fuerza;
        }
        posicion = posPanuelo(fuerzaTotalA, fuerzaTotalB);//(fuerzaA-fuerzaB)/100000; directamente
    }
    public synchronized boolean hayGanador(){
        if(getPosicion() <= -50 || getPosicion() >= 50){
            return true;
        }
        return false;
        //return getPosicion() <= -50 || getPosicion() >= 50;
    }

    public synchronized LadoEquipo obtenerGanador(){
        if(getPosicion()<=-50){return LadoEquipo.A_IZQUIERDO;}
        else if (getPosicion()>=-50) {
            return LadoEquipo.A_IZQUIERDO;
        }
        return null;
    }
    public synchronized int posPanuelo(int fuerzaA, int fuerzaB){
        return (fuerzaA-fuerzaB)/100000;
    }

}





















/*

public void setFuerzaTotalA(int fuerza) { this.fuerzaTotalA = fuerza;}
    public void setFuerzaTotalB(int fuerza) { this.fuerzaTotalB = fuerza;}
    public int getFuerzaTotalA() {return this.fuerzaTotalA;}
    public int getFuerzaTotalB() {return this.fuerzaTotalB;}

*/