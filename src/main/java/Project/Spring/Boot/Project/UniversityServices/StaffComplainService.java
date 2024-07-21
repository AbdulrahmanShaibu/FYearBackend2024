package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.StaffComplain;
import Project.Spring.Boot.Project.UniversityRepository.StaffComplainRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffComplainService {

    @Autowired
    private StaffComplainRepository staffComplainRepository;

    public List<StaffComplain> StaffComplainList() {
        return staffComplainRepository.findAll();
    }

    public Optional<StaffComplain> findStaffComplainById(int id) {
        return staffComplainRepository.findById(id);
    }

    public StaffComplain updateStaffComplain(int id, StaffComplain newStaffComplain) {
        Logger logger = LoggerFactory.getLogger(this.getClass()); // Logger instance

        try {
            Optional<StaffComplain> data = findStaffComplainById(id);
            if (data.isPresent()) {
                StaffComplain existingStaffComplain = data.get();
//                existingStaffComplain.setStaffComplainDescription(newStaffComplain.getStaffComplainDescription());
                existingStaffComplain.setSubmissionDate(newStaffComplain.getSubmissionDate());
                existingStaffComplain.setDescription(newStaffComplain.getDescription());
                existingStaffComplain.setStaffs(newStaffComplain.getStaffs());
//                existingStaffComplain.setUniversityCleaners(newStaffComplain.getUniversityCleaners());
                // Save the existingStaffComplain, not newStaffComplain
                return staffComplainRepository.save(existingStaffComplain);
            } else {
                throw new RuntimeException("StaffClaim not found with id: " + id);
            }
        } catch (RuntimeException e) {
            // Log the error
            logger.error("Error updating StaffComplain with id " + id, e);
            // Re-throw the exception to maintain the original behavior
            throw e;
        }
    }



    public void deleteStaffComplain(int id) {
        Optional<StaffComplain>data =findStaffComplainById(id);
        if (data.isPresent()){
            staffComplainRepository.delete(data.get());
            ResponseEntity.ok("successfully deleted with with ID"+" "+id);
        }
        else {
            ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("failed to delete StaffComplain with id:"+id);
        }
    }

    public long countStaffComplain() {
        return staffComplainRepository.count();
    }

    public StaffComplain saveStaffComplain(StaffComplain staffComplain) {
        return staffComplainRepository.save(staffComplain);
    }
}
