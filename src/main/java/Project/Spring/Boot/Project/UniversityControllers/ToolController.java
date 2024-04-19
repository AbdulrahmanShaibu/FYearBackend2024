package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Tool;
import Project.Spring.Boot.Project.UniversityServices.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class ToolController {
    @Autowired
    private ToolService toolService;

    @GetMapping("/list/tools")
    public List<Tool> getAllTools() {
        return toolService.getAllTools();
    }

    @GetMapping("/get/tools/{id}")
    public ResponseEntity<Tool>
    getToolById(@PathVariable(value = "id") Long id) {
        Tool tool = toolService.getToolById(id);
        return ResponseEntity.ok().body(tool);
    }

    @PostMapping("/save/tools")
    public ResponseEntity<Tool>
    createTool(@RequestBody Tool tool) {
        Tool createdTool = toolService.createTool(tool);
        return
                ResponseEntity.status(HttpStatus.CREATED).body(createdTool);
    }

    @PutMapping("/update/tools/{id}")
    public ResponseEntity<Tool>
    updateTool(@PathVariable(value = "id") Long id, @RequestBody Tool toolDetails) {
        Tool updatedTool = toolService.updateTool(id, toolDetails);
        return ResponseEntity.ok().body(updatedTool);
    }

    @DeleteMapping("/delete/tools/{id}")
    public ResponseEntity<?>
    deleteTool(@PathVariable(value = "id") Long id) {
        return toolService.deleteTool(id);
    }

    @GetMapping("/count/tools")
    public long countTools(){
        return toolService.countTools();
    }

}
