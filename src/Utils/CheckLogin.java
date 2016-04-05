/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utils;

import Studente.Studente;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author te4o
 */
public class CheckLogin {

    private static ArrayList<Studente> studenti = new ArrayList<>();
    private static boolean check;
    private static Studente guest = new Studente("", "", 0, "");
    
    public static void Check(String email, String psw) throws InternalError, IOException{
    
        if (studenti.isEmpty()) {
            ReadFile();
        }
       
        check= false;
        
        for (int i=0; i<studenti.size(); i++) {
            if((email+"@universitadipavia.it").equals(studenti.get(i).getEmail())){
                if(psw.equals(studenti.get(i).getPassword())){
                    check = true;
                    guest = studenti.get(i);
                    guest.setNickname();
                }
            }
        }
        InternalError LoginEx = new InternalError("Wrong email/password");
        if(check == false) {throw LoginEx;}
    }

    private static void ReadFile () throws IOException{
        
        studenti = new ArrayList<>();
        try{
            BufferedReader in = new BufferedReader(new FileReader("files/credenziali.txt"));
            String line, email, password, telefono;
            int points;

            while((line = in.readLine()) != null){

                StringTokenizer st = new StringTokenizer(line, "\t");
                while(st.hasMoreTokens()){

                    email = st.nextToken();
                    password = st.nextToken();
                    points = Integer.parseInt(st.nextToken());
                    telefono = st.nextToken();

                    Studente studente = new Studente(email, password, points, telefono);
                    studenti.add(studente);
                }
            }
            in.close();
        }catch(FileNotFoundException ex0){System.err.println("File not found.");}
    }

    public static Studente getGuest() {
        return guest;
    }
    
    public static void deleteGuest(){guest = new Studente("", "", 0, "");}
}
