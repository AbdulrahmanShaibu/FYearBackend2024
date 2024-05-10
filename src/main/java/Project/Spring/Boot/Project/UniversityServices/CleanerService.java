package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Cleaner;
import Project.Spring.Boot.Project.UniversityRepository.CleanerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CleanerService {

    @Autowired
    private CleanerRepository cleanerRepository;

    public Cleaner createCleaner(Cleaner cleaner) {
        return cleanerRepository.save(cleaner);
    }

    public List<Cleaner> cleanerList() {
        return cleanerRepository.findAll();
    }

    public Optional<Cleaner> getCleanerById(int id) {
     return cleanerRepository.findById(id);
    }

    public void deleteCleaner(int id) {
       Optional<Cleaner> optionalCleaner = getCleanerById(id);
       if (optionalCleaner.isPresent()){
            cleanerRepository.delete(optionalCleaner.get());
            ResponseEntity.ok("successfully deleted with with ID"+" "+id);
       }
       else {
           throw new RuntimeException("Failed to delete cleaner with id: " + id);
       }
    }

    public Cleaner updateCleaner(int id, Cleaner newCleanerDetails) {
        Optional<Cleaner> optionalCleaner = cleanerRepository.findById(id);
        if (optionalCleaner.isPresent()) {
            Cleaner existingCleaner = optionalCleaner.get();

            existingCleaner.setCleanerName(newCleanerDetails.getCleanerName());
            existingCleaner.setGender(newCleanerDetails.getGender());

            existingCleaner.setDepartment(newCleanerDetails.getDepartment());
            existingCleaner.setTool(newCleanerDetails.getTool());

            ResponseEntity.ok("update success with id:"+id);
            return cleanerRepository.save(existingCleaner);
        } else {
            ResponseEntity.notFound();
            throw new RuntimeException("Cleaner not found with id: " + id);
        }
    }

    public long countCleaners() {
        return cleanerRepository.count();
    }
}
