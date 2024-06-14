package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.CleaningCompany;
import Project.Spring.Boot.Project.UniversityRepository.CleaningCompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleaningCompanyCompanyService {

    @Autowired
    private CleaningCompanyRepository cleaningCompanyRepository;

    public List<CleaningCompany> getAllCompanies() {
        return cleaningCompanyRepository.findAll();
    }

    public Optional<CleaningCompany> getCompanyById(int id) {
        return cleaningCompanyRepository.findById(id);
    }

    public CleaningCompany saveCompany(CleaningCompany cleaningCompany) {
        return cleaningCompanyRepository.save(cleaningCompany);
    }

    public CleaningCompany updateCompany(CleaningCompany cleaningCompany) {
        return cleaningCompanyRepository.save(cleaningCompany);
    }

    public void deleteCompany(int id) {
        cleaningCompanyRepository.deleteById(id);
    }
}
