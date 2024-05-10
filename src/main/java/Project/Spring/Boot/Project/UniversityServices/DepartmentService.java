package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Department;
import Project.Spring.Boot.Project.UniversityRepository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department createDepartment(Department department){
        return departmentRepository.save(department);
    }

    public List<Department> getAllDepartments(){
        return departmentRepository.findAll();
    }

    public long countDepartments() {
        return departmentRepository.count();
    }

    public boolean deleteDepartment(Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public Department updateDepartment(Long departmentId, Department updatedDepartment) {
        Optional<Department>optionalDepartment=departmentRepository.findById(departmentId);
        if(optionalDepartment.isPresent()){
            Department existingDepartment=optionalDepartment.get();

            existingDepartment.setDepartmentName(updatedDepartment.getDepartmentName());

            return departmentRepository.save(existingDepartment);
        } else {
            throw new NoSuchElementException("Department not found with id: " + departmentId);
        }
    }
}
