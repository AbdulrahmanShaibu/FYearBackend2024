package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Area;
import Project.Spring.Boot.Project.UniversityServices.AreaService;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class AreaController {

    @Autowired
    private AreaService areaService;

    @PostMapping("/post/area")
    public Area createArea(@RequestBody Area area){
        return areaService.createArea(area);
    }

    @GetMapping("/list/area")
    public List<Area>areaList(){
        return areaService.areaList();
    }

    @GetMapping("/get/area/byId/{id}")
    public Area
    findAreaById(@PathVariable(value = "id") int id){
        return areaService.findAreaById(id);
    }

    @DeleteMapping("/delete/area/{id}")
    public ResponseEntity<?>
    deleteArea(@PathVariable(value = "id") int id){
    return areaService.deleteArea(id);
    }

    @PutMapping("/update/area/{id}")
    public ResponseEntity<Area>
    updateArea(@PathVariable(value = "id") int id, @RequestBody Area areaDetails) {
        try {
            Area updatedArea = areaService.updateArea(id, areaDetails);
            return ResponseEntity.ok(updatedArea);
        } catch (ResourceNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

//    Optional Codes(postman request to getAreaByName)
//    http://localhost:8080/api/v1/get?areaName=added
    @GetMapping("/get")
    public ResponseEntity<Area> getAreaByName(@RequestParam String areaName) {
        Area area = areaService.findAreaByName(areaName);
        if (area != null) {
            return ResponseEntity.ok(area);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
