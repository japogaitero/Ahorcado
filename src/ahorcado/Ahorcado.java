/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ahorcado;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Victor
 */
public class Ahorcado {
    public static boolean otraPartida(String juego){
        Scanner teclado = new Scanner(System.in);
        boolean jugar=true;
        boolean preguntaCorrecta=true;                
        preguntaCorrecta=true;
        while(preguntaCorrecta) {            
            switch (juego)
            {
                case "SI":
                    preguntaCorrecta=false;
                    break;
                case "NO":
                    preguntaCorrecta=false;
                    jugar=false;
                    break;
                default:
                    System.out.println("¿DESEA JUGAR OTRA PARTIDA?");
                    System.out.println("LIMITESE A CONTESTAR \"SI\" O \"NO\"" );
                    juego =teclado.next().toUpperCase();
            }
        }        
        return jugar;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        Scanner entrada = new Scanner ("src/ahorcado/facil.txt");
        boolean jugar=true;
        boolean preguntaCorrecta;
        String juego;
        while (jugar){
            System.out.println("¿DESEA JUGAR OTRA PARTIDA?");
            juego =teclado.next().toUpperCase();
            jugar=otraPartida(juego);//METODO PARA PREGUNTAR SI SE QUIERE JUGAR OTRA VEZ
        }
        System.out.println("SI YA NO QUIERES JUGAR MAS PUES S'ACABO LO QUE SE DABA");
    }
}
