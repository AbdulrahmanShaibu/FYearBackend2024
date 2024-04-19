package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Tool;
import Project.Spring.Boot.Project.UniversityRepository.ToolRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;
    public List<Tool> getAllTools() {
        return toolRepository.findAll();
    }
    public Tool getToolById(Long id) {
        return toolRepository.findById(id)
                .orElseThrow(() -> new
                        ResourceNotFoundException("Tool not found with id " + id));
    }
    public Tool createTool(Tool tool) {
        return toolRepository.save(tool);
    }
    public Tool updateTool(Long id, Tool toolDetails) {
        Tool tool = getToolById(id);
        tool.setToolName(toolDetails.getToolName());
        tool.setQuantity(toolDetails.getQuantity());
        tool.setAvailabilityStatus(toolDetails.getAvailabilityStatus());
// update other fields as needed
        System.out.println("update tools success"+tool);
        return toolRepository.save(tool);
    }
    public ResponseEntity<?> deleteTool(Long id) {
        Tool tool = getToolById(id);
        toolRepository.delete(tool);
        return ResponseEntity.ok("successfully deleted with with ID"+" "+id);
    }


    public long countTools() {
        return toolRepository.count();
    }
}
