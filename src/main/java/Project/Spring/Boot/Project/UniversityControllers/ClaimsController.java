package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Claims;
import Project.Spring.Boot.Project.UniversityServices.ClaimsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ClaimsController {

    @Autowired
    private ClaimsService claimsService;

    @PostMapping("/save/claims")
    public Claims saveClaims(@RequestBody Claims claims){
        return claimsService.saveClaims(claims);
    }

    @GetMapping("/list/claims")
    public List<Claims>claimsList(){
        return claimsService.claimsList();
    }

    @GetMapping("/get/claims/{id}")
    public Optional<Claims> findClaimsById(@PathVariable(value = "id") int id){
        return claimsService.findClaimsById(id);
    }

    @PutMapping("/update/claims/{id}")
    public Claims updateClaims(@PathVariable(value = "id") int id, Claims newClaims){
        return claimsService.updateClaims(id,newClaims);
    }

    @DeleteMapping("/delete/claims/{id}")
    public void deleteClaims(@PathVariable(value = "id") int id){
        claimsService.deleteClaims(id);
    }

    @GetMapping("/count/claims")
    public long countClaims(){
        return claimsService.countClaims();
    }
}
