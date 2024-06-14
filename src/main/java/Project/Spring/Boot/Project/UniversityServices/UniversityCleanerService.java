//package Project.Spring.Boot.Project.UniversityServices;
//
//import Project.Spring.Boot.Project.University.Models.UniversityCleaner;
//import Project.Spring.Boot.Project.UniversityRepository.UniversityCleanerRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UniversityCleanerService {
//
//    @Autowired
//    private UniversityCleanerRepository universityCleanerRepository;
//
//    public UniversityCleaner createCleaner(UniversityCleaner universityCleaner) {
//        return universityCleanerRepository.save(universityCleaner);
//    }
//
//    public List<UniversityCleaner> cleanerList() {
//        return universityCleanerRepository.findAll();
//    }
//
//    public Optional<UniversityCleaner> getCleanerById(int id) {
//     return universityCleanerRepository.findById(id);
//    }
//
//    public void deleteCleaner(int id) {
//       Optional<UniversityCleaner> optionalCleaner = getCleanerById(id);
//       if (optionalCleaner.isPresent()){
//            universityCleanerRepository.delete(optionalCleaner.get());
//            ResponseEntity.ok("successfully deleted with with ID"+" "+id);
//       }
//       else {
//           throw new RuntimeException("Failed to delete cleaner with id: " + id);
//       }
//    }
//
//    public UniversityCleaner updateCleaner(int id, UniversityCleaner newUniversityCleanerDetails) {
//        Optional<UniversityCleaner> optionalCleaner = universityCleanerRepository.findById(id);
//        if (optionalCleaner.isPresent()) {
//            UniversityCleaner existingUniversityCleaner = optionalCleaner.get();
//
//            existingUniversityCleaner.setCleanerName(newUniversityCleanerDetails.getCleanerName());
//            existingUniversityCleaner.setGender(newUniversityCleanerDetails.getGender());
//
//            existingUniversityCleaner.setClientSite(newUniversityCleanerDetails.getClientSite());
//            existingUniversityCleaner.setTool(newUniversityCleanerDetails.getTool());
//
//            ResponseEntity.ok("update success with id:"+id);
//            return universityCleanerRepository.save(existingUniversityCleaner);
//        } else {
//            ResponseEntity.notFound();
//            throw new RuntimeException("Cleaner not found with id: " + id);
//        }
//    }
//
//    public long countCleaners() {
//        return universityCleanerRepository.count();
//    }
//}
