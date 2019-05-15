package persistence.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclient;

    @Column
    private String username;

    @Column
    private String password;

    @Column
    private String age;

    @Column
    private String email;

    @OneToMany(fetch=FetchType.EAGER)
    private List<ClientList> matches;

    public Client(){};

    public Client(String username, String password, String age, String email, List<ClientList> matches) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.matches = matches;
    }

    public Integer getIdclient() {
        return idclient;
    }

    public void setIdclient(Integer idclient) {
        this.idclient = idclient;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idclient=" + idclient +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
