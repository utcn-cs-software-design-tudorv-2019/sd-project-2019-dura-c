package persistence.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="clientlist")
public class ClientList {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="client")
    @NotNull
    private Client client;

    @ManyToOne
    @JoinColumn(name="match")
    @NotNull
    private Match match;

    public ClientList(){};

    public ClientList(@NotNull Client client, @NotNull Match match) {
        this.client = client;
        this.match = match;
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

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    @Override
    public String toString() {
        return "ClientList{" +
                "id=" + id +
                ", client=" + client +
                ", match=" + match +
                '}';
    }
}
