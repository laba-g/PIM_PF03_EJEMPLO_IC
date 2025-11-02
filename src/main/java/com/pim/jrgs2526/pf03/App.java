package com.pim.jrgs2526.pf03;

/**
 * Hello world!
 *
 */
public class App
{
    public static final String ERR_CALC_NOTA = "Error al calcular nota";
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
    }

    public int calcularNota(int nota) {
        if (nota >= 0 && nota <= 4)
            return -1;
        if (nota >= 5 && nota <= 10)
            return 1;
        throw new IllegalArgumentException(ERR_CALC_NOTA);
    }

}
