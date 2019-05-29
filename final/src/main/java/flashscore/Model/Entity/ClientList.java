package flashscore.Model.Entity;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="clientlist")
public class ClientList {
    @Id
    @Column(name = "idclientlist", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="client")
    @NotNull
    private Client client;

    @ManyToOne
    @JoinColumn(name="game")
    @NotNull
    private Game game;

    public ClientList(){};

    public ClientList(@NotNull Client client, @NotNull Game game) {
        this.client = client;
        this.game = game;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Game getMatch() {
        return game;
    }

    public void setMatch(Game game) {
        this.game = game;
    }

    @Override
    public String toString() {
        return "ClientList{" +
                "id=" + id +
                ", client=" + client +
                ", match=" + game +
                '}';
    }
}
