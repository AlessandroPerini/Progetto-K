
package Studenti;

/**
 * Classe contentenete la struttura di uno studente:
 * attributi, costruttore, metodi get - set
 * @author te4o
 */

public class Studente {
    
    private String email;
    private String nome;
    private String cognome;
    private String password;
    private String nickname;
    private String telefono; 

    /**
     * Il metodo inizializza Studente in base ai parametri passati
     * 
     * @param email 
     * @param password
     * @param telefono
     * @param nickname 
     */
    
    public Studente(String email, String password, String telefono, String nickname) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.telefono = telefono;
        this.nome = nome;
        this.cognome = cognome;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    
    /**
     * Crea il nome scomponendo la mail
     */
    public void setNome() {
        String s = email;
        s = s.replace(".", ",");
        String parts[] = s.split(",");
        String nome = parts[0];
        nome = nome.substring(0, 1).toUpperCase() + nome.substring(1);
        this.nome = nome;
    }
    
    /**
     * Crea il cognome scomponendo la mail
     */
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

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}
