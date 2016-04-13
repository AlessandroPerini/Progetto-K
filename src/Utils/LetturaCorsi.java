/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author Te4o
 */
public class LetturaCorsi {
    
    private static ArrayList<String> corsi = new ArrayList<>();
    private static String nome;
    private static int numeroCorsi = 0;
    
    public static ArrayList leggi(String nomeFacolta){

        nome = nomeFacolta;
        
        try{
              BufferedReader in = new BufferedReader(new FileReader("files/corsi/"+nomeFacolta+".txt"));
              String corso, line;

              while((line = in.readLine()) != null){

                  corso = line;
                  corsi.add(corso);

                  numeroCorsi++;
              }
              in.close();
          }
          catch(FileNotFoundException ex1){System.err.println("File non trovato.");}
          catch(IOException ex2){System.err.println("Errore I/O.");}

        return corsi;  
    }

    public static ArrayList<String> getCorsi() {
        return corsi;
    }

    public static String getNome() {
        return nome;
    }

    public static int getNumeroCorsi() {
        return numeroCorsi;
    }
    
}
