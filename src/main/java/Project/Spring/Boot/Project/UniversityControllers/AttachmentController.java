package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Attachment;
import Project.Spring.Boot.Project.UniversityServices.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class AttachmentController {
    @Autowired
    private AttachmentService service;

    @GetMapping("/attachment")
    public List<Attachment> findAll() {
        return service.findAll();
    }

    @GetMapping("/attachment/{id}")
    public Attachment findById(@PathVariable Long id) {
        return service.findById(id);
    }

    @PostMapping("/post/attachment")
    public Attachment save(@RequestBody Attachment attachment) {
        return service.save(attachment);
    }

    @PutMapping("/update/{id}")
    public Attachment update(@PathVariable Long id, @RequestBody Attachment attachment) {
        attachment.setId(id);
        return service.save(attachment);
    }

    @DeleteMapping("/delete/attachment/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}
