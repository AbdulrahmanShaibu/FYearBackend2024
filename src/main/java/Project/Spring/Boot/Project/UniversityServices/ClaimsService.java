package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Claims;
import Project.Spring.Boot.Project.UniversityRepository.ClaimsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
        Logger logger = LoggerFactory.getLogger(this.getClass()); // Logger instance

        try {
            Optional<Claims> data = findClaimsById(id);
            if (data.isPresent()) {
                Claims existingClaims = data.get();
                existingClaims.setClaimsDescription(newClaims.getClaimsDescription());
                existingClaims.setSubmissionDate(newClaims.getSubmissionDate());
                existingClaims.setClaimType(newClaims.getClaimType());
                existingClaims.setStaffs(newClaims.getStaffs());
                existingClaims.setCleaners(newClaims.getCleaners());
                // Save the existingClaims, not newClaims
                return claimsRepository.save(existingClaims);
            } else {
                throw new RuntimeException("Claim not found with id: " + id);
            }
        } catch (RuntimeException e) {
            // Log the error
            logger.error("Error updating claims with id " + id, e);
            // Re-throw the exception to maintain the original behavior
            throw e;
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
