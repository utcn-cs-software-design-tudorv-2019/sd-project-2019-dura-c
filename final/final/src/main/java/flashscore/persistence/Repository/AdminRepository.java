package flashscore.persistence.Repository;

import flashscore.persistence.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
    public Admin findByUsername(String username);
    public Admin save(Admin admin);
}
