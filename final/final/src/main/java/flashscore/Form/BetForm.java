package flashscore.Form;

public class BetForm {
    private String value;
    private String idgame;
    private String winner;
    public BetForm(){}

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getId() {
        return idgame;
    }

    public void setId(String id) {
        this.idgame = id;
    }

    @Override
    public String toString() {
        return "BetForm{" +
                "value='" + value + '\'' +
                ", idgame='" + idgame + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}
