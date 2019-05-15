package persistence.Entity;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idamatch;

    @Column
    private String name;

    @Column
    private String category;

    @Column
    private String firstTeam;

    @Column
    private String secondTeam;

    @Column
    private String score;

    @OneToMany(fetch=FetchType.EAGER)
    private List<ClientList> clienLits;


    public Match(){};

    public Match(String name, String category, String firstTeam, String secondTeam, String score, List<ClientList> clienLits) {
        this.name = name;
        this.category = category;
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
        this.score = score;
        this.clienLits = clienLits;
    }

    public Integer getIdamatch() {
        return idamatch;
    }

    public void setIdamatch(Integer idamatch) {
        this.idamatch = idamatch;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                "idamatch=" + idamatch +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", firstTeam='" + firstTeam + '\'' +
                ", secondTeam='" + secondTeam + '\'' +
                ", score='" + score + '\'' +
                '}';
    }
}
