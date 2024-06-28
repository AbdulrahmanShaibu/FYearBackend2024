package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Attachment;
import Project.Spring.Boot.Project.University.Models.Staffs;
import Project.Spring.Boot.Project.UniversityRepository.AttachmentRepository;
import Project.Spring.Boot.Project.UniversityRepository.StaffsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

    @Autowired
    private StaffsRepository staffsRepository;

    private final String uploadDir = "uploads/";

    public Attachment saveAttachment(MultipartFile file, Long staffId) throws IOException {
        // Create the directory if it doesn't exist
        Path uploadPath = Paths.get(uploadDir);
        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        // Retrieve the original filename of the uploaded file
        String fileName = file.getOriginalFilename();
        Path filePath = uploadPath.resolve(fileName);
        // Copy the uploaded file's content to the target location
        Files.copy(file.getInputStream(), filePath);

        // Fetch the existing Staffs entity from the database
        Staffs staffs = staffsRepository.findById(Math.toIntExact(staffId)).orElseThrow(() -> new RuntimeException("Staff not found with id: " + staffId));

        Attachment attachment = new Attachment();
        attachment.setFileName(fileName);
        attachment.setStaffs(staffs);

        return attachmentRepository.save(attachment);
    }

    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    public Optional<Attachment> getAttachmentById(Long id) {
        return attachmentRepository.findById(id);
    }

    public Attachment updateAttachment(Long id, MultipartFile file, Long staffId) throws IOException {
        Optional<Attachment> optionalAttachment = attachmentRepository.findById(id);
        if (optionalAttachment.isPresent()) {
            Attachment attachment = optionalAttachment.get();

            if (file != null && !file.isEmpty()) {
                Path uploadPath = Paths.get(uploadDir);
                if (!Files.exists(uploadPath)) {
                    Files.createDirectories(uploadPath);
                }

                String fileName = file.getOriginalFilename();
                Path filePath = uploadPath.resolve(fileName);
                Files.copy(file.getInputStream(), filePath);

                attachment.setFileName(fileName);
            }

            if (staffId != null) {
                Staffs staffs = staffsRepository.findById(Math.toIntExact(staffId)).orElseThrow(() -> new RuntimeException("Staff not found with id: " + staffId));
                attachment.setStaffs(staffs);
            }

            return attachmentRepository.save(attachment);
        } else {
            throw new RuntimeException("Attachment not found with id " + id);
        }
    }

    public void deleteAttachment(Long id) {
        attachmentRepository.deleteById(id);
    }
}
