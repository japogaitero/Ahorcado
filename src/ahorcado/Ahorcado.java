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
import java.util.ArrayList;

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
        /*SEGUN EL NIVEL SELECCIONADO O LAS INSTRUCCIONES EN EL METODO ANTERIOR ESTE METODO LEE DE FICHERO Y DEVUELVE LO CORRESPONDIENTE*/
        File archivoFacil = new File ("src/ahorcado/facil.txt");
        File archivoMedio = new File ("src/ahorcado/medio.txt");
        File archivoDificil = new File ("src/ahorcado/dificil.txt");
        File archivoInstrucciones = new File ("src/ahorcado/instrucciones.txt");
        Scanner entradaFacil = new Scanner (archivoFacil);
        Scanner entradaMedio = new Scanner (archivoMedio);
        Scanner entradaDificil = new Scanner (archivoDificil);
        Scanner entradaInstrucciones = new Scanner (archivoInstrucciones);
        Random aleatorio = new Random();
        String [] arrayPalabras = new String [50]; // ARRAY DE 50 POSICIONES PARA LEER EL ARCHIVO DE 50 PALABRAS
        String palabra="";
        String Instrucciones;
        switch (nivel){// EN CADA CASO SE RELLENA UN ARRAY CON LAS PALABRAS DE CADA NIVEL (MAS ABAJO SE SELECCIONA UNA AL AZAR)
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
        if(!palabra.equals("instrucciones")){//SE SELECCIONA UNA PALABRA AL AZAR DEL ARRAY DE PALABRAS
            palabra=arrayPalabras[aleatorio.nextInt(arrayPalabras.length)];
        }
        return palabra;
    }
    public static boolean jugarConPalabras(String palabra){
        Scanner teclado = new Scanner(System.in);
        boolean ganadas=true;
        int intento=1;
        char letra;
        char [] letras=palabra.toCharArray();// CONVIERTE LA PALABRA(STRING) EN UN ARRAY DE LETRAS (CARACTERES) (char)
        int p = 0; //CONTADOR PARA EL ARRAY LIST DE LAS LETRAS YA EINTRODIDAS
        char [] guiones= new char[letras.length];// CREA UN ARRAY DE MISMA LONGITUD QUE LAS LETRAS PERO SUSTITUYENDO LETRAS POR GUIONES
        int errores=0;
        ArrayList<Character> letrasIntroducidas = new ArrayList<Character>();//ESTE ARRAY DINAMICO PERMITE ACUMULAR LAS LETRAS YA PROBADAS Y MOSTRARLAS
        for(int i = 0; i<letras.length;i++){// ESTE BUCLE RELLENA UN ARRAY CON O GUIONES EQUIVALENTES A LA PALABRA A ADIVINAR, MAS ABAJO SE PINTAN
            guiones[i]='-';
        }
        while((errores<=6)){
            pintarMonigote(errores); //SE PINTA AL MOÑECO SEGUN EL CASO DE ERRORES
            if (errores==6){// ESTA CONDICION ESTA AL PRINCIPIO PARA EN CASO DE LLEGAR A 6 ERRORES NO CONTINUAR CON LA EJECUCION DEL RESTO DEL CICLO
                System.out.println("VAYA! HAS MATADO AL MOÑECO Y NO HAS ADIVINADO LA PALABRA!!");
                System.out.println("LA PALABRA ERA " + palabra);
                ganadas=false;
                break;
            }
            if (intento!=6){
                System.out.print("ESTE TU INTENTO Nº "+ intento + ": ");
            }else{
                System.out.print("¡¡¡CUIDADO!!! ESTE ES TU SEXTO Y ULTIMO INTENTO DE SALVAR AL MOÑECO:  ");
            }
            for(int i = 0; i<letras.length;i++){//PINTADO DE LOS GUIONES PARA SABER CUANTAS LETRAS TIENE LA PALABRA
                System.out.print(" " +guiones[i]+" ");
            }
            System.out.println("");
            System.out.println("A VER DIME UNA LETRA QUE QUIERAS PROBAR");
            letra=teclado.next().toUpperCase().charAt(0);
            if (letrasIntroducidas.contains(letra)){//CON ESTA CONDICION SE DA UNA AYUDA EN CASO DE INTRODUCIR UNA LETRA YA INTRODUCIDA
                System.out.println("YA HAS INTRODUCIDO LA LETRA " +  letra);
                System.out.print("PARA QUE LO TENGAS EN CUENTA YA HAS INTRODUCIDO LAS  SIGUIENTES LETRAS: ");
                for (int i = 0; i < letrasIntroducidas.size(); i++) {
                    System.out.print(letrasIntroducidas.get(i) + " ");
                }
                System.out.println("");
                continue;//SE PASA A LA SIGUIENTE ITERACION DEL BUCLE SIN CONTAR COMO ERROR ESTE INTENTO
            }
            letrasIntroducidas.add(p,letra);//SI LA LETRA NO ESTABA EN EL ARRAY LIST DE LETRAS INTRODUCIDAS SE INTRODUCE
            boolean acierto=false;//ESTA VARIABLE
            for(int i = 0; i<letras.length;i++){//ESTE BUCLE COMPARA SI LA LETRA INTRODUCIDA SE ENCUENTRA EN ALGUNA POSICION DEL ARRAY QUE FORMA LA PALABRA
                if (letras[i]==letra){
                    guiones[i]=letra;//SI LA LETRA INTRODUCIDA ES BUENA SE SUSTITUYE EL GUION POR ESTA Y SE CONSIDERA LETRA ACERTADA
                    acierto=true;
                }
            }
            if(Arrays.equals(guiones,letras)){//SI EL ARRAY DE LA PALABRA Y EL DE GUIONES SUSTITUIDOS CON  LETRAS CORRECTAS SON IDENTICOS LA PALABRA HABRA SIDO DESCUBIERTA
                System.out.println("¡¡¡¡ BIEN !!! HAS ACERTADO LA PALABRA");
                ganadas=true;
                break;
            }
            if(acierto==false){
                System.out.println("VAYA, LA LETRA " + letra + " PARECE QUE NO ESTA");
                errores++;
                intento++;
            }else
                System.out.println("MUY BIEN! HAS ADIVINADO LA "+ letra);
            System.out.println("");
            p++;//AUMENTO EL CONTADOR PARA LA POSICION DEL ARRAY LIST letrasIntroducidas
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
                        "      ||         HAS MATADO      _(___)_               \n" +
                        "      ||       A CRISPIN !!!     | - + |               \n" +
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
        while (jugar){  //ESTE LOOP SE REPETIRA MIENTRAS EL JUGADOR DECIDA JUGAR OTRA PARTIDA, SI DICE QUE NO, SALE Y MUESTRA RESULTADO DE PARTIDAS
            System.out.println("SELECCIONE EL NIVEL QUE QUIERE JUGAR O ESCRIBA INSTRUCCIONES PARA SABER COMO JUGAR");
            System.out.println("FACIL - - - MEDIO - - - DIFICIL - - - INTRUCCIONES");
            nivel=selectorNivel();//METODO PARA SELECCIONAR NIVEL
            palabra=selectorPalabra(nivel);//METODO PARA SELECCIONAR PALABRA SEGUN EL NIVEL O MOSTRAR LAS INSTRUCCIONES
            if (palabra.equals("instrucciones")){
                continue;// EN CASO DE QUE SE MUESTREN LAS INTRUCCIONES SE VUELVE A PEDIR QUE SE SELECCIONE EL NIVEL PARA JUGAR
            }
            //System.out.println("la palabra para jugar es "+ palabra);//   --------------------> HABILITANDO ESTA LINEA SE PUEDE VER LA PALABRA PARA AVERIGUAR PARA PROBAR EL JUEGO
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
        System.out.println("DEJAMOS EL JUEGO POR AHORA...");
        System.out.println(" EL RESUMEN DE ESTA PARTIDA  HA SIDO                                 \n"+
                "      -NIVEL FÁCIL:    "+facilWin+" Ganadas, "+facilLoose+" Perdidas            \n"+
                "      -NIVEL MEDIO:    "+medioWin+" Ganadas, "+medioLoose+" Perdidas            \n"+
                "      -NIVEL DIFICIL:  "+dificilWin+" Ganadas, "+dificilLoose+" Perdidas        \n");
    }
}
