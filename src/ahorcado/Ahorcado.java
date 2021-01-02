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
import java.util.Arrays;

/**
 *
 * @author Victor
 */
public class Ahorcado {
    
    public static String selectorNivel(){
        String nivel;
        Scanner teclado = new Scanner(System.in);
        nivel =teclado.next().toUpperCase();
        boolean nivelCorrecto=true;
        while(nivelCorrecto) {
            switch (nivel){
                case "FACIL":
                    nivelCorrecto=false;
                    System.out.println("HAS SELECCIONADO NIVEL "+nivel);
                    break;
                case "MEDIO":
                    nivelCorrecto=false;
                    System.out.println("HAS SELECCIONADO NIVEL "+nivel);
                    break;
                case "DIFICIL":
                    nivelCorrecto=false;
                    System.out.println("HAS SELECCIONADO NIVEL "+nivel);
                    break;
                case "INSTRUCCIONES":
                    nivelCorrecto=false;
                    break;
                default:
                    System.out.println("PERO QUE RESPUESTA ES ESTA??!! ESCRIBE SOLO \"FACIL\" O \"MEDIO\" O \"DIFICIL\" O \"INSTRUCCIONES\"" );
                    nivel =teclado.next().toUpperCase();
            }
        }
        return nivel;
    }
    public static String selectorPalabra(String nivel)throws FileNotFoundException {
        File archivoFacil = new File ("src/ahorcado/facil.txt");
        File archivoMedio = new File ("src/ahorcado/medio.txt");
        File archivoDificil = new File ("src/ahorcado/dificil.txt");
        File archivoInstrucciones = new File ("src/ahorcado/instrucciones.txt");
        Scanner entradaFacil = new Scanner (archivoFacil);
        Scanner entradaMedio = new Scanner (archivoMedio);
        Scanner entradaDificil = new Scanner (archivoDificil);
        Scanner entradaInstrucciones = new Scanner (archivoInstrucciones);
        Random aleatorio = new Random();
        String [] arrayPalabras = new String [50];
        String palabra="";
        String Instrucciones;
        switch (nivel){
            case "FACIL":
                for (int i=0;i<arrayPalabras.length;i++){
                    palabra=entradaFacil.next().toUpperCase();
                    arrayPalabras[i]=palabra;
                }
                entradaFacil.close();
                break;
            case "MEDIO":
                for (int i=0;i<arrayPalabras.length;i++){
                    palabra=entradaMedio.next().toUpperCase();
                    arrayPalabras[i]=palabra;
                }
                entradaMedio.close();
                break;
            case "DIFICIL":
                for (int i=0;i<arrayPalabras.length;i++){
                    palabra=entradaDificil.next().toUpperCase();
                    arrayPalabras[i]=palabra;
                }
                entradaDificil.close();
                break;
            case "INSTRUCCIONES":
                while(entradaInstrucciones.hasNextLine()){
                    Instrucciones=entradaInstrucciones.nextLine();
                    System.out.println(Instrucciones);
                    palabra="instrucciones";
                }
                System.out.println("");
                entradaInstrucciones.close();
                break;
        }
        if(!palabra.equals("instrucciones")){
            palabra=arrayPalabras[aleatorio.nextInt(arrayPalabras.length)];
        }
        return palabra;
    }
    public static boolean jugarConPalabras(String palabra){
        Scanner teclado = new Scanner(System.in);
        boolean ganadas=true;
        char letra;
        char [] letras=palabra.toCharArray();// CONVIERTE LA PALABRA EN UN ARRAY DE LETRAS (char)
        char [] guiones= new char[letras.length];// CREA UN ARRAY DE MISMA LONGITUD QUE LAS LETRAS PERO SUSTITUYENDO LETRAS POR GUIONES
        for(int i = 0; i<letras.length;i++){
            guiones[i]='-';
            System.out.print(" " +guiones[i]+" ");
        }
        System.out.println("");
        int errores=0;
        while((errores<=6)){
            pintarMonigote(errores);
            if (errores==6){
                System.out.println("VAYA! HAS MATADO AL FIGURIN ESTE Y NO HAS ADIVINADO LA PALABRA!!");
                System.out.println("LA PALABRA ERA " + palabra);
                ganadas=false;
                break;
            }
            System.out.println("A VER DIME LA LETRA QUE QUIERES PROBAR");
            letra=teclado.next().toUpperCase().charAt(0);
            boolean acierto=false;
            for(int i = 0; i<letras.length;i++){
                if (letras[i]==letra){
                    guiones[i]=letra;
                    System.out.print(" " +guiones[i]+" ");
                    acierto=true;
                }else{
                    System.out.print(" " +guiones[i]+" ");
                }
            }
            System.out.println("");
            if(Arrays.equals(guiones,letras)){
                System.out.println("¡¡¡¡ BIEN !!! HAS ACERTADO LA PALABRA");
                ganadas=true;
                break;
            }
            if(acierto==false){
                System.out.println("VAYA NO HAS ACERTADO NINGUNA LETRA");
                errores++;
            }else
                System.out.println("MUY BIEN! HAS ADIVINADO LA "+ letra);
            System.out.println("");
        }
        return ganadas;
    }
    public static void pintarMonigote(int errores){
        switch (errores){
            case 0:
                System.out.println("      ______________________________        \n" +
                        "      ||                            |                  \n" +
                        "      ||                            |                  \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "  ____||____");
                break;
            case 1:
                System.out.println("      ______________________________        \n" +
                        "      ||                            |                  \n" +
                        "      ||                            |                  \n" +
                        "      ||                           _|_                 \n" +
                        "      ||                         _(___)_               \n" +
                        "      ||                         | - + |               \n" +
                        "      ||                         |  <  |               \n" +
                        "      ||                          \\_O_/               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "  ____||____");
                break;
            case 2:
                System.out.println("      ______________________________        \n" +
                        "      ||                            |                  \n" +
                        "      ||                            |                  \n" +
                        "      ||                           _|_                 \n" +
                        "      ||                         _(___)_               \n" +
                        "      ||                         | - + |               \n" +
                        "      ||                         |  <  |               \n" +
                        "      ||                          \\_O_/               \n" +
                        "      ||                            ||                 \n" +
                        "      ||                            ||                 \n" +
                        "      ||                            ||                 \n" +
                        "      ||                            ||                 \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "  ____||____");
                break;
            case 3:
                System.out.println("      ______________________________        \n" +
                        "      ||                            |                  \n" +
                        "      ||                            |                  \n" +
                        "      ||                           _|_                 \n" +
                        "      ||                         _(___)_               \n" +
                        "      ||                         | - + |               \n" +
                        "      ||                         |  <  |               \n" +
                        "      ||                          \\_O_/               \n" +
                        "      ||                            ||                 \n" +
                        "      ||                          ||||||               \n" +
                        "      ||                        ||  ||                 \n" +
                        "      ||                       ||   ||                 \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "  ____||____");
                break;
            case 4:
                System.out.println("      ______________________________        \n" +
                        "      ||                            |                  \n" +
                        "      ||                            |                  \n" +
                        "      ||                           _|_                 \n" +
                        "      ||                         _(___)_               \n" +
                        "      ||                         | - + |               \n" +
                        "      ||                         |  <  |               \n" +
                        "      ||                          \\_O_/               \n" +
                        "      ||                            ||                 \n" +
                        "      ||                          ||||||               \n" +
                        "      ||                        ||  ||  ||             \n" +
                        "      ||                       ||   ||    ||           \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "      ||                                               \n" +
                        "  ____||____");
                break;
            case 5:
                System.out.println("      ______________________________        \n" +
                        "      ||                            |                  \n" +
                        "      ||                            |                  \n" +
                        "      ||                           _|_                 \n" +
                        "      ||                         _(___)_               \n" +
                        "      ||                         | - + |               \n" +
                        "      ||                         |  <  |               \n" +
                        "      ||                          \\_O_/               \n" +
                        "      ||                            ||                 \n" +
                        "      ||                          ||||||               \n" +
                        "      ||                        ||  ||  ||             \n" +
                        "      ||                       ||   ||    ||           \n" +
                        "      ||                          ||                   \n" +
                        "      ||                         ||                    \n" +
                        "      ||                        ||                     \n" +
                        "      ||                       ---                     \n" +
                        "  ____||____");
                break;
                
            case 6:
                System.out.println("      ______________________________        \n" +
                        "      ||                            |                  \n" +
                        "      ||                            |                  \n" +
                        "      ||                           _|_                 \n" +
                        "      ||                         _(___)_               \n" +
                        "      ||      MUERTO!!!          | - + |               \n" +
                        "      ||                         |  <  |               \n" +
                        "      ||                          \\_O_/               \n" +
                        "      ||                            ||                 \n" +
                        "      ||                          ||||||               \n" +
                        "      ||                        ||  ||  ||             \n" +
                        "      ||                       ||   ||    ||           \n" +
                        "      ||                          ||  ||               \n" +
                        "      ||                         ||    ||              \n" +
                        "      ||                        ||      ||             \n" +
                        "      ||                       ---      ---            \n" +
                        "  ____||____");
        }
    }
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
    public static void main(String[] args)throws FileNotFoundException {
        Scanner teclado = new Scanner(System.in);
        String nivel;
        String nuevoJuego;
        String palabra;
        boolean ganadas=true;
        int facilWin=0, facilLoose=0, medioWin=0, medioLoose=0, dificilWin=0, dificilLoose=0; //CONTADORES  PARA EL RESUMEN DE LA PARTIDA
        boolean jugar=true;
        while (jugar){  //ESTE LOOP SE REPETIRA MIENTRAS EL JUGADOR RESPONDA SI A JUGAR OTRA PARTIDA
            System.out.println("SELECCIONE EL NIVEL QUE QUIERE JUGAR O ESCRIBA INSTRUCCIONES PARA SABER COMO JUGAR");
            System.out.println("FACIL - - - MEDIO - - - DIFICIL - - - INTRUCCIONES");
            nivel=selectorNivel();//METODO PARA SELECCIONAR NIVEL
            palabra=selectorPalabra(nivel);//METODO PARA SELECCIONAR PALABRA SEGUN EL NIVEL
            if (palabra.equals("instrucciones")){
                continue;
            }
            System.out.println("la palabra para jugar es "+ palabra);//   --------------------> HABILITANDO ESTA LINEA SE PUEDE VER LA PALABRA PARA AVERIGUAR PARA DEBUGUEAR EL JUEGO
            ganadas=jugarConPalabras(palabra); //METODO PARA IR PROBANDO LETRAS Y PINTAR EL MOÑECO
            System.out.println("");
            System.out.println("¿DESEAs JUGAR OTRA PARTIDA?");
            nuevoJuego =teclado.next().toUpperCase();
            jugar=otraPartida(nuevoJuego);//METODO PARA PREGUNTAR SI SE QUIERE JUGAR OTRA PARTIDA
            if (ganadas&&(nivel.equals("FACIL"))){
                facilWin++;
            }else if(!ganadas&&(nivel.equals("FACIL"))){
                facilLoose++;
            }else if(ganadas&&(nivel.equals("MEDIO"))){
                medioWin++;
            }else if(!ganadas&&(nivel.equals("MEDIO"))){
                medioLoose++;
            }else if(ganadas&&(nivel.equals("DIFICIL"))){
                dificilWin++;
            }else if(!ganadas&&(nivel.equals("DIFICIL"))){
                dificilLoose++;
            }
            
        }
        System.out.println("SI YA NO QUIERES JUGAR MAS PUES S'ACABO LO QUE SE DABA");
        System.out.println(" RESUMEN DE LA PARTIDA                                                  \n"+
                "      -NIVEL FÁCIL: "+facilWin+" Ganadas, "+facilLoose+" Perdidas         \n" +
                        "      -NIVEL MEDIO: "+medioWin+" Ganadas, "+medioLoose+" Perdidas         \n" +
                                "      -NIVEL DIFICIL: "+dificilWin+" Ganadas, "+dificilLoose+" Perdidas   \n");
    }
}
