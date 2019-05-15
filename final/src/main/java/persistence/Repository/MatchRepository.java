package persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.Entity.Match;

public interface MatchRepository extends JpaRepository<Match,Integer> {
}
