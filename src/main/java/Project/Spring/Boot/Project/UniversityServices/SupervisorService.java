package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Supervisor;
import Project.Spring.Boot.Project.UniversityRepository.SupervisorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class SupervisorService {
    @Autowired
    private  SupervisorRepository supervisorRepository;

    public List<Supervisor> getAllSupervisors() {
        return supervisorRepository.findAll();
    }

    public Supervisor getSupervisorById(Long id) {
        return supervisorRepository.findById(id)
                .orElseThrow(() -> new
                        NoSuchElementException("Supervisor not found with id " + id));
    }

    public ResponseEntity<String> createSupervisor(Supervisor supervisor) {
        try {
            supervisorRepository.save(supervisor);
            return ResponseEntity.ok("Saved successfully");
        } catch (Exception exception) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error while saving details: " + exception.getMessage());
        }
    }
        public Supervisor updateSupervisor (Long id, Supervisor supervisorDetails){
            Supervisor supervisor = getSupervisorById(id);

//        supervisor.setEmployee(supervisorDetails.getEmployee());

            supervisor.setSupervisorName(supervisorDetails.getSupervisorName());
            supervisor.setDepartment(supervisorDetails.getDepartment());
            return supervisorRepository.save(supervisor);
        }

        public ResponseEntity<?> deleteSupervisor (Long id){
            try {
                // Check if supervisor exists
                if (!supervisorRepository.existsById(id)) {
                    return ResponseEntity
                            .status(HttpStatus.NOT_FOUND)
                            .body("Supervisor with ID " + id + " not found.");
                }
                // Delete supervisor
                supervisorRepository.deleteById(id);
                // Return success message
                return ResponseEntity
                        .ok()
                        .body("Supervisor with ID " + id + " has been successfully deleted.");
            } catch (Exception deleteException) {
                return ResponseEntity
                        .status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Failed to delete supervisor with ID " + id);
            }
        }
    }
