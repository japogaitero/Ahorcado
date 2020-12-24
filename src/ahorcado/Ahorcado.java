/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ahorcado;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Victor
 */
public class Ahorcado {
    public static boolean otraPartida(String juego){
        Scanner teclado = new Scanner(System.in);
        boolean jugar=true;
        boolean preguntaCorrecta=true;
        while(preguntaCorrecta) {
            switch (juego){
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
    public static String selectorNivel(String nivel){
        Scanner teclado = new Scanner(System.in);
        boolean nivelCorrecto=true;
        while(nivelCorrecto) {
            switch (nivel){
                case "FACIL":
                    nivelCorrecto=false;
                    break;
                case "MEDIO":
                    nivelCorrecto=false;
                    break;
                case "DIFICIL":
                    nivelCorrecto=false;
                    break;
                default:
                    System.out.println("LIMITESE A ESCRIBIR \"FACIL\" O \"MEDIO\" O \"DIFICIL\"" );
                    nivel =teclado.next().toUpperCase();
            }
        }
        return nivel;
    }
    public static String selectorPalabra(String nivel)throws FileNotFoundException {
        File archivoFacil = new File ("src/ahorcado/facil.txt");
        File archivoMedio = new File ("src/ahorcado/medio.txt");
        File archivoDificil = new File ("src/ahorcado/dificil.txt");
        Scanner entradaFacil = new Scanner (archivoFacil);
        Scanner entradaMedio = new Scanner (archivoFacil);
        Scanner entradaDificil = new Scanner (archivoFacil);
        Random aleatorio = new Random();        
        String palabras="";
        String palabra;        
        switch (nivel){
            case "FACIL":                
                palabras=entradaFacil.nextLine();
                //String[] palabras= palabras.split(",");
                break;
            case "MEDIO":
                palabras=entradaMedio.nextLine();                
                break;
            case "DIFICIL": 
                palabras=entradaDificil.nextLine();
                break;            
        }
        String[] arrayPalabras =palabras.split(",");
        for (int i=0; i<arrayPalabras.length;i++){
            palabra= arrayPalabras[i];
            System.out.println(palabra);        
        }        
        palabra= arrayPalabras[aleatorio.nextInt(arrayPalabras.length)];
        
        return palabra;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        //Scanner entrada = new Scanner ("src/ahorcado/facil.txt");
        String nivel;
        String juego;
        String palabra;
        boolean jugar=true;
        while (jugar){
            /*-------------------------------------------------------------------
            *    METODO PARA SELECCIONAR NIVEL
            --------------------------------------------------------------------*/
            System.out.println("SELECCIONE EL NIVEL QUE QUIERE JUGAR");
            System.out.println("FACIL - - - MEDIO - - - DIFICIL");
            nivel =teclado.next().toUpperCase();
            nivel=selectorNivel(nivel);
            System.out.println("VAS A JUGAR EN NIVEL "+nivel);
            /*-------------------------------------------------------------------
            *    METODO PARA SELECCIONAR PALABRA SEGUN EL NIVEL
            --------------------------------------------------------------------*/            
            palabra=selectorPalabra(nivel);            
            System.out.println("la palabra para jugar es "+ palabra); 
            /*-------------------------------------------------------------------
            *    METODO PARA PREGUNTAR SI SE QUIERE JUGAR OTRA PARTIDA
            --------------------------------------------------------------------*/
            System.out.println("¿DESEA JUGAR OTRA PARTIDA?");
            juego =teclado.next().toUpperCase();
            jugar=otraPartida(juego);//METODO PARA PREGUNTAR SI SE QUIERE JUGAR OTRA VEZ
        }
        System.out.println("SI YA NO QUIERES JUGAR MAS PUES S'ACABO LO QUE SE DABA");
    }
}
