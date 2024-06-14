package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.ClientSite;
import Project.Spring.Boot.Project.UniversityRepository.ClientSiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class ClientSiteService {

    @Autowired
    private ClientSiteRepository clientSiteRepository;

    public ClientSite createClientSite(ClientSite clientSite){
        return clientSiteRepository.save(clientSite);
    }

    public List<ClientSite> getAllClientSites() {
        return clientSiteRepository.findAll();
    }

    public long countClientSites() {
        return clientSiteRepository.count();
    }

    public boolean deleteClientSite(Long id) {
        if (clientSiteRepository.existsById(id)) {
            clientSiteRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public ClientSite updateClientSite(Long ClientSiteId, ClientSite updatedClientSite) {
        Optional<ClientSite>optionalClientSite= clientSiteRepository.findById(ClientSiteId);
        if(optionalClientSite.isPresent()){
            ClientSite existingClientSite =optionalClientSite.get();

            existingClientSite.setName(updatedClientSite.getName());
            existingClientSite.setTools(updatedClientSite.getTools());
            existingClientSite.setClientOrganisation(updatedClientSite.getClientOrganisation());

            return clientSiteRepository.save(existingClientSite);
        } else {
            throw new NoSuchElementException("ClientSite not found with id: " + ClientSiteId);
        }
    }


}
