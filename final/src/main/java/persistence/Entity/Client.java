package flashscore.persistence.Entity;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="client")
public class Client {
    @Id
    @Column(name = "idclient", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idclient;

    @Column(name="username")
    private String username;

    @Column(name="password")
    private String password;

    @Column(name="age")
    private String age;

    @Column(name="email")
    private String email;

    @Column(name="sold")
    private String sold;

    public Client(){};

    public Client(String username, String password, String age, String email,String sold) {
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.sold=sold;
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

    public String getSold() {
        return sold;
    }

    public void setSold(String sold) {
        this.sold = sold;
    }

    @Override
    public String toString() {
        return "Client{" +
                "idclient=" + idclient +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", email='" + email + '\'' +
                ", sold=" + sold +
                '}';
    }
}