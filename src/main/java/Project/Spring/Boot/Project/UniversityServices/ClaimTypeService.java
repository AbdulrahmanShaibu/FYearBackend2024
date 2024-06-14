package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.ClaimType;
import Project.Spring.Boot.Project.UniversityRepository.ClaimTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClaimTypeService {
    @Autowired
    private ClaimTypeRepository repository;

    public List<ClaimType> findAll() {
        return repository.findAll();
    }

    public ClaimType findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public ClaimType save(ClaimType claimType) {
        return repository.save(claimType);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
