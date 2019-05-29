package flashscore.Model.Entity;

import javax.persistence.*;

@Entity
@Table(name="game")
public class Game {
    @Id
    @Column(name = "idgame", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idgame;

    @Column(name="category")
    private String category;

    @Column(name="firstteam")
    private String firstTeam;

    @Column(name="secondteam")
    private String secondTeam;

    @Column(name="score")
    private String score;

    public Game(){};

    public Game( String category, String firstTeam, String secondTeam) {
        this.category = category;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }

    public Integer getIdamatch() {
        return idgame;
    }

    public void setIdamatch(Integer idamatch) {
        this.idgame = idamatch;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(String firstTeam) {
        this.firstTeam = firstTeam;
    }

    public String getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(String secondTeam) {
        this.secondTeam = secondTeam;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Match{" +
                "idgame=" + idgame +
                ", category='" + category + '\'' +
                ", firstTeam='" + firstTeam + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
