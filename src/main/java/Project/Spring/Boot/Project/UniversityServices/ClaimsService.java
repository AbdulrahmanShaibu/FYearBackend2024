package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Claims;
import Project.Spring.Boot.Project.UniversityRepository.ClaimsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClaimsService {

    @Autowired
    private ClaimsRepository claimsRepository;

    public Claims saveClaims(Claims claims) {
        return claimsRepository.save(claims);
    }

    public List<Claims> claimsList() {
        return claimsRepository.findAll();
    }

    public Optional<Claims> findClaimsById(int id) {
        return claimsRepository.findById(id);
    }

    public Claims updateClaims(int id, Claims newClaims) {
        Optional<Claims> data =findClaimsById(id);
        if (data.isPresent()){
            Claims existingClaims=data.get();
            existingClaims.setClaimsDescription(newClaims.getClaimsDescription());
            existingClaims.setSubmissionDate(newClaims.getSubmissionDate());
            existingClaims.setClaimType(newClaims.getClaimType());
            existingClaims.setStaffs(newClaims.getStaffs());
            existingClaims.setCleaners(newClaims.getCleaners());
            return claimsRepository.save(newClaims);
        }
        else {
            ResponseEntity.notFound();
            throw new RuntimeException("Cleaner not found with id: " + id);
        }
    }

    public void deleteClaims(int id) {
        Optional<Claims>data =findClaimsById(id);
        if (data.isPresent()){
            claimsRepository.delete(data.get());
            ResponseEntity.ok("successfully deleted with with ID"+" "+id);
        }
        else {
            ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("failed to delete claims with id:"+id);
        }
    }

    public long countClaims() {
        return claimsRepository.count();
    }
}
