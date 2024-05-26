package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Staff;
import Project.Spring.Boot.Project.UniversityRepository.StaffRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StaffService {

    @Autowired
    private StaffRepository staffRepository;

    public Staff createStaff(Staff staff) {
        return staffRepository.save(staff);
    }

    public List<Staff> staffList() {
        return staffRepository.findAll();
    }

    public long countStaff() {
        return staffRepository.count();
    }

    public Optional<Staff> findStaffById(int id) {
        return Optional.ofNullable(staffRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id " + id)));
    }

    public void deleteStaff(Staff staff) {
        staffRepository.delete(staff);
    }

    public Staff updateStaff(int id, Staff staff) {
        Optional<Staff> optionalStaff = findStaffById(id);
        if (optionalStaff.isPresent()) {
            Staff existingStaff = optionalStaff.get();
            existingStaff.setStaffName(staff.getStaffName());
            existingStaff.setStaffEmail(staff.getStaffEmail());
            existingStaff.setStaffPhone(staff.getStaffPhone());
            // set other attributes if needed
            return staffRepository.save(existingStaff);
        } else {
            throw new RuntimeException("Staff not updated with id: " + id);
        }
    }

    public long staffClaims() {
        return staffRepository.count();
    }


//    public Staff getByStaffName(String StaffName) {
//        return staffRepository.getByStaffName(StaffName);
//    }

}
