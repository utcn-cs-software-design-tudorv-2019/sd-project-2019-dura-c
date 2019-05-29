package Data.Entity;

import com.sun.istack.internal.NotNull;

import javax.persistence.*;

@Entity
@Table(name="bet")
public class Bet {
    @Id
    @Column(name = "idbet", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idBet;

    @ManyToOne
    @JoinColumn(name = "idc")
    @NotNull
    private Client idc;

    @ManyToOne
    @JoinColumn(name = "idg")
    @NotNull
    private Game idGame;

    @Column(name = "value")
    private int value;

    @Column(name = "winner")
    private String winner;

    public Bet() {
    }

    public Bet(@NotNull Client idc, @NotNull Game idmatch, int value, String winner) {
        this.idc = idc;
        this.idGame = idmatch;
        this.value = value;
        this.winner = winner;
    }

    public Integer getIdBet() {
        return idBet;
    }

    public void setIdBet(Integer idBet) {
        this.idBet = idBet;
    }

    public Client getIdc() {
        return idc;
    }

    public void setIdc(Client idc) {
        this.idc = idc;
    }

    public Game getIdGame() {
        return idGame;
    }

    public void setIdmatch(Game idGame) {
        this.idGame = idGame;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "Bet{" +
                "idBet=" + idBet +
                ", idc=" + idc +
                ", idGame=" + idGame +
                ", value=" + value +
                ", winner='" + winner + '\'' +
                '}';
    }
}