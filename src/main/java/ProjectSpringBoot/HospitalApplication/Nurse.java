package ProjectSpringBoot.HospitalApplication;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Nurse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int nurse_id;
    private String name;
    private String username;
    private String password;

    public Nurse() {}

    public Nurse(int nurse_id, String name, String username, String password) {
        this.nurse_id=nurse_id;
    this.name = name;
        this.username = username;
        this.password = password;
    }

    public int getNurse_id() {
        return nurse_id;
    }

    public void setNurse_id(int nurse_id) {
        this.nurse_id = nurse_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString() {
        return
               "Id: " + nurse_id + "\n" +
               "Name: " + name + "\n" +
               "Username: " + username + "\n" +
               "Password: " + password;
    }


    
}
