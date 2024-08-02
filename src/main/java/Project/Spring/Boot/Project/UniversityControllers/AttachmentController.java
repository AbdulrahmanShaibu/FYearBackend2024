package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Attachment;
import Project.Spring.Boot.Project.UniversityServices.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class AttachmentController {

    @Autowired
    private AttachmentService attachmentService;

    @GetMapping("/get/attachments")
    public List<Attachment> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    @GetMapping("/count/attachments")
    public long countAttachments(){
        return attachmentService.countAttachments();
    }

    @GetMapping("/get/attachments/{id}")
    public Optional<Attachment> getAttachmentById(@PathVariable Long id) {
        return attachmentService.getAttachmentById(id);
    }

    @PostMapping("/upload/attachment")
    public ResponseEntity<Attachment> uploadAttachment(@RequestParam("file") MultipartFile file, @RequestParam("staffId") int staffId) throws IOException {
        Attachment savedAttachment = attachmentService.saveAttachment(file, staffId);
        return ResponseEntity.ok(savedAttachment);
    }

    @PutMapping("/update/attachments/{id}")
    public Attachment updateAttachment(@PathVariable Long id, @RequestParam("file") MultipartFile file, @RequestParam("staffId") Long staffId) throws Exception {
        return attachmentService.updateAttachment(id, file, staffId);
    }

    @DeleteMapping("/delete/attachments/{id}")
    public void deleteAttachment(@PathVariable Long id) {
        attachmentService.deleteAttachment(id);
    }

    @GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] getImage(@PathVariable Long id) {
        Optional<Attachment> attachment = attachmentService.getAttachmentById(id);
        if (attachment.isPresent()) {
            return attachment.get().getImageData();
        }
        return null;
    }
}
