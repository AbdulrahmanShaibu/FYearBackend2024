package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.ClientSite;
import Project.Spring.Boot.Project.UniversityServices.ClientSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ClientSiteController {

    @Autowired
    private ClientSiteService clientSiteService;

    @PostMapping("/post/client-site")
    public ResponseEntity<ClientSite> createClientSite(@RequestBody ClientSite clientSite) {
        ClientSite createdClientSite = clientSiteService.createClientSite(clientSite);
        return ResponseEntity.ok(createdClientSite);
    }

    @GetMapping("/get/client-sites")
    public List<ClientSite> getAllClientSites(){
        return clientSiteService.getAllClientSites();
    }

    @GetMapping("/count/client-site")
    public long countClientSites(){
        return clientSiteService.countClientSites();
    }

    @DeleteMapping("/delete/client-site/{ClientSiteId}")
    public ResponseEntity<String> deleteClientSite(@PathVariable Long ClientSiteId) {
        boolean deleted = clientSiteService.deleteClientSite(ClientSiteId);
        if (deleted) {
            return ResponseEntity.ok("ClientSite deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/client-site/{ClientSiteId}")
    public ResponseEntity<?> updateClientSite(@PathVariable Long ClientSiteId, @RequestBody ClientSite clientSite) {
        try {
            ResponseEntity<?> updated = clientSiteService.updateClientSite(ClientSiteId, clientSite);
            return updated;
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to update ClientSite: " + e.getMessage());
        }
    }

}
