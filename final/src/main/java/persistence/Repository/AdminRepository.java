package persistence.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import persistence.Entity.Admin;

public interface AdminRepository extends JpaRepository<Admin,Integer> {
}
