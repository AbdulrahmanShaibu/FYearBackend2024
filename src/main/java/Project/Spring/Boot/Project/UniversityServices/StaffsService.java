//package Project.Spring.Boot.Project.UniversityServices;
//
//import Project.Spring.Boot.Project.University.Models.Staffs;
//import Project.Spring.Boot.Project.UniversityRepository.StaffsRepository;
//import org.apache.velocity.exception.ResourceNotFoundException;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class StaffsService {
//
//    @Autowired
//    private StaffsRepository staffsRepository;
//
////    public Staffs createStaff(Staffs staffs) {
////        return staffsRepository.save(staffs);
////    }
////
////    public List<Staffs> staffList() {
////        return staffsRepository.findAll();
////    }
////
////    public long countStaff() {
////        return staffsRepository.count();
////    }
////
////    public Optional<Staffs> findStaffById(int id) {
////        return Optional.ofNullable(staffsRepository.findById(id)
////                .orElseThrow(() -> new ResourceNotFoundException("Staff not found with id " + id)));
////    }
////
////    public void deleteStaff(Staffs staffs) {
////        staffsRepository.delete(staffs);
////    }
////
////    public Staffs updateStaff(int id, Staffs staffs) {
////        Optional<Staffs> optionalStaff = findStaffById(id);
////        if (optionalStaff.isPresent()) {
////            Staffs existingStaffs = optionalStaff.get();
////            existingStaffs.setStaffName(staffs.getStaffName());
////            existingStaffs.setStaffEmail(staffs.getStaffEmail());
////            existingStaffs.setStaffPhone(staffs.getStaffPhone());
////            existingStaffs.setStaffComplaints(staffs.getStaffComplaints());
////            existingStaffs.setAttachments(staffs.getAttachments());
////            // set other attributes if needed
////            return staffsRepository.save(existingStaffs);
////        } else {
////            throw new RuntimeException("Staff not updated with id: " + id);
////        }
////    }
////
////    public long staffClaims() {
////        return staffsRepository.count();
////    }
//
//
////    public Staff getByStaffName(String StaffName) {
////        return staffRepository.getByStaffName(StaffName);
////    }
//
//}
