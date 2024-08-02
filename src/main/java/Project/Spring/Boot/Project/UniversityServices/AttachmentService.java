package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.Model.JwtUser;
import Project.Spring.Boot.Project.Repository.JwtRepository;
import Project.Spring.Boot.Project.University.Models.Attachment;
//import Project.Spring.Boot.Project.University.Models.Staffs;
import Project.Spring.Boot.Project.UniversityRepository.AttachmentRepository;
//import Project.Spring.Boot.Project.UniversityRepository.StaffsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class AttachmentService {

    @Autowired
    private AttachmentRepository attachmentRepository;

//    @Autowired
//    private StaffsRepository staffsRepository;

    @Autowired
    private JwtRepository jwtRepository;


    public Attachment saveAttachment(MultipartFile file, int staffId) throws IOException {
        String fileName = file.getOriginalFilename();
        byte[] imageData = file.getBytes();

        JwtUser staffs = jwtRepository.findById(staffId)
                .orElseThrow(() -> new RuntimeException("Staff not found with id: " + staffId));

        Attachment attachment = new Attachment();
        attachment.setFileName(fileName);
        attachment.setImageData(imageData);
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
                String fileName = file.getOriginalFilename();
                byte[] imageData = file.getBytes();

                attachment.setFileName(fileName);
                attachment.setImageData(imageData);
            }

            if (staffId != null) {
                JwtUser staffs = jwtRepository.findById(Math.toIntExact(staffId))
                        .orElseThrow(() -> new RuntimeException("Staff not found with id: " + staffId));
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

    public long countAttachments() {
        return attachmentRepository.count();
    }
}
