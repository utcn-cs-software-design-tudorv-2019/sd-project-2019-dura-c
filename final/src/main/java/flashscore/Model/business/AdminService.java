package flashscore.Model.business;

import flashscore.Model.Entity.Admin;
import flashscore.Model.Repository.AdminRepository;
import org.springframework.stereotype.Service;
import javax.inject.Inject;


@Service
public class AdminService {
    @Inject
    private AdminRepository adminRepository;

    public Admin findByUsername(String username)
    {
        return adminRepository.findByUsername(username);
    }

    public void saveAdmin(Admin admin){
        adminRepository.save(admin);
    }
}
