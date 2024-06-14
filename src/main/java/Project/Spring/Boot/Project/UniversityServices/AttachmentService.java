package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Attachment;
import Project.Spring.Boot.Project.UniversityRepository.AttachmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachmentService {
    @Autowired
    private AttachmentRepository repository;

    public List<Attachment> findAll() {
        return repository.findAll();
    }

    public Attachment findById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public Attachment save(Attachment attachment) {
        return repository.save(attachment);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
