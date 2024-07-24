package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.ClientOrganisation;
import Project.Spring.Boot.Project.UniversityRepository.ClientOrganisationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientOrganisationService {

    @Autowired
    private ClientOrganisationRepository clientOrganisationRepository;

    public ClientOrganisation createClientOrganisation(ClientOrganisation clientOrganisation) {
        return clientOrganisationRepository.save(clientOrganisation);
    }


    public List<ClientOrganisation> ClientOrganisationList() {
        return clientOrganisationRepository.findAll();
    }

    public Optional<ClientOrganisation> findClientOrganisationById(int id) {
        return clientOrganisationRepository.findById(id);
    }

    public ClientOrganisation updateClientOrganisation(int id, ClientOrganisation clientOrganisation) throws Exception {
        Optional<ClientOrganisation> existingClientOrganisationOpt = clientOrganisationRepository.findById(id);

        if (existingClientOrganisationOpt.isPresent()) {
            ClientOrganisation existingClientOrganisation = existingClientOrganisationOpt.get();
            existingClientOrganisation.setName(clientOrganisation.getName());
            // Update other fields as needed
            return clientOrganisationRepository.save(existingClientOrganisation);
        } else {
            throw new Exception("ClientOrganisation with id " + id + " not found");
        }
    }

    public void deleteClientOrganisation(int id, ClientOrganisation clientOrganisation) {
        Optional<ClientOrganisation> data=findClientOrganisationById(id);
        if (data.isPresent()){
            clientOrganisationRepository.delete(clientOrganisation);
        }else {
            ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("failed to delete ClientOrganisation with id:"+id);
        }
    }

    public long countClientOrganisations() {
        return clientOrganisationRepository.count();
    }
}
