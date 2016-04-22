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
    private String nome;
    private String cognome;
    private String password;
    private String nickname;
    private String telefono; 

    public Studente(String email, String password, String telefono) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.telefono = telefono;
        this.nome = nome;
        this.cognome = cognome;
    }
    
    public void setNickname() {
        String s = email;
        s = s.replace(".", ",");
        String parts[] = s.split(",");
        String nome = parts[0];
        String cognome = parts[1].charAt(0)+"";
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
        cognome = cognome.substring(0, 1).toUpperCase() + cognome.substring(1);
        nickname = nome+" "+cognome+".";
    }
    
    public void setNome() {
        String s = email;
        s = s.replace(".", ",");
        String parts[] = s.split(",");
        String nome = parts[0];
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
        this.nome = nome;
    }
    
    public void setCognome() {
        String s = email;
        s = s.replace(".", ",");
        String parts[] = s.split(",");
        String cognome = parts[1];
        String parts2[] = cognome.split("0");
        cognome = parts2[0];
        cognome = cognome.substring(0, 1).toUpperCase() + cognome.substring(1);
        this.cognome = cognome;
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

    public String getTelefono() {
        return telefono;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

}
