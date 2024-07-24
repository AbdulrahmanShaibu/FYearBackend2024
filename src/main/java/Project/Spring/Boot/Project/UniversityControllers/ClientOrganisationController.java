package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.ClientOrganisation;
import Project.Spring.Boot.Project.UniversityServices.ClientOrganisationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ClientOrganisationController {
    @Autowired
    private ClientOrganisationService clientOrganisationService;

    @PostMapping("/save/ClientOrganisation")
    public ResponseEntity<ClientOrganisation> createClientOrganisation(@RequestBody ClientOrganisation clientOrganisation) {
        ClientOrganisation savedOrganisation = clientOrganisationService.createClientOrganisation(clientOrganisation);
        System.out.println("Received payload: " + clientOrganisation);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedOrganisation);
    }

    @GetMapping("/ClientOrganisation/list")
    public List<ClientOrganisation>ClientOrganisationList(){
        return clientOrganisationService.ClientOrganisationList();
    }

    @GetMapping("/list/{id}")
    public Optional<ClientOrganisation> findClientOrganisationById(@PathVariable(value = "id") int id){
        return clientOrganisationService.findClientOrganisationById(id);
    }

    @PutMapping("/update/ClientOrganisation/{id}")
    public ResponseEntity<?> updateClientOrganisation(@PathVariable(value = "id") int id, @RequestBody ClientOrganisation clientOrganisation) {
        try {
            ClientOrganisation updatedClientOrganisation = clientOrganisationService.updateClientOrganisation(id, clientOrganisation);
            return ResponseEntity.ok(updatedClientOrganisation);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to update ClientOrganisation with id: " + id);
        }
    }

    @DeleteMapping("/delete/ClientOrganisation/{id}")
    public void deleteClientOrganisation(@PathVariable(value = "id") int id, ClientOrganisation clientOrganisation){
        clientOrganisationService.deleteClientOrganisation(id, clientOrganisation);
    }

    @GetMapping("/count/ClientOrganisations")
    public long countClientOrganisations(){
        return clientOrganisationService.countClientOrganisations();
    }

}
