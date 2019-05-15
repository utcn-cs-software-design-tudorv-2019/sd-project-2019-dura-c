package persistence.Entity;

import javax.persistence.*;

@Entity
@Table(name="admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idadmin;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String email;

    public Admin(){};

    public Admin(String username, String password, String email) {
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public Integer getId() {
        return idadmin;
    }

    public void setId(Integer id) {
        this.idadmin = id;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id=" + idadmin +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
