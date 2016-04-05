/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Studente;

/**
 *
 * @author cl418646
 */
public class Studente {
    
    private String email;
    private String password;
    private String nickname;
    private int punti;
    private String telefono; 

    public Studente(String email, String password, int punti, String telefono) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.punti = punti;
        this.telefono = telefono;
    }
    
    public void setNickname() {
        String s = email;
        s = s.replace(".", ",");
        String parts[] = s.split(",");
        String name = parts[0];
        String surname = parts[1].charAt(0)+"";
        name = name.substring(0, 1).toUpperCase() + name.substring(1);
        surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);
        nickname = name+" "+surname+".";
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public String getPassword() {
        return password;
    }

    public int getPunti() {
        return punti;
    }

    public String getTelefono() {
        return telefono;
    }
    
    
    
}
