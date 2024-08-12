package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.ClientOrganisation;
import Project.Spring.Boot.Project.University.Models.ClientSite;
import Project.Spring.Boot.Project.UniversityRepository.ClientOrganisationRepository;
import Project.Spring.Boot.Project.UniversityRepository.ClientSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClientSiteService {

    @Autowired
    private ClientSiteRepository clientSiteRepository;
    @Autowired
    private ClientOrganisationRepository clientOrganisationRepository;

    public ClientSite createClientSite(ClientSite clientSite) {
        ClientOrganisation clientOrganisation = clientSite.getClientOrganisation();
        if (clientOrganisation == null) {
            throw new IllegalArgumentException("ClientOrganisation cannot be null");
        }

        System.out.println("ClientOrganisation name: " + clientOrganisation.getName()); // Debugging line

        Optional<ClientOrganisation> existingOrg = clientOrganisationRepository.findById(clientOrganisation.getId());
        if (existingOrg.isPresent()) {
            clientSite.setClientOrganisation(existingOrg.get());
        } else {
            ClientOrganisation savedOrg = clientOrganisationRepository.save(clientOrganisation);
            clientSite.setClientOrganisation(savedOrg);
        }

        return clientSiteRepository.save(clientSite);
    }

    public List<ClientSite> getAllClientSites() {
        return clientSiteRepository.findAll();
    }

    public long countClientSites() {
        return clientSiteRepository.count();
    }

    public boolean deleteClientSite(Long id) {
        // Check if the client site exists by ID
        if (!clientSiteRepository.existsById(id)) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("ClientSite:"+id+"not found").hasBody();
        }

        // Delete the client site
        clientSiteRepository.deleteById(id);

        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body("ClientSite:"+id+"not found").hasBody();
    }

    public ResponseEntity<?> updateClientSite(Long ClientSiteId, ClientSite updatedClientSite) {
        // Check if the client site exists by ID
        Optional<ClientSite> existingClientSiteOpt = clientSiteRepository.findById(ClientSiteId);
        if (!existingClientSiteOpt.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("ClientSite: " + ClientSiteId + " not found");
        }

        ClientSite existingClientSite = existingClientSiteOpt.get();

        // Check if clientOrganisation already exists by name
        ClientOrganisation updatedClientOrganisation = updatedClientSite.getClientOrganisation();
        Optional<ClientOrganisation> existingOrg = clientOrganisationRepository.findByName(updatedClientOrganisation.getName());
        if (existingOrg.isPresent()) {
            existingClientSite.setClientOrganisation(existingOrg.get());
        } else {
            // Save new clientOrganisation
            ClientOrganisation savedOrg = clientOrganisationRepository.save(updatedClientOrganisation);
            existingClientSite.setClientOrganisation(savedOrg);
        }

        // Update other fields of the client site
        existingClientSite.setName(updatedClientSite.getName());
        // add other fields as necessary

        // Save the updated client site
        ClientSite savedClientSite = clientSiteRepository.save(existingClientSite);

        return ResponseEntity.ok(savedClientSite);
    }


}
