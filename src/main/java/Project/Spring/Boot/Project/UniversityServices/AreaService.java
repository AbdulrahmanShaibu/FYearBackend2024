package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Area;
import Project.Spring.Boot.Project.UniversityRepository.AreaRepository;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AreaService {

    @Autowired
    private AreaRepository areaRepository;

    public Area createArea(Area area) {
        return areaRepository.save(area);
    }

    public List<Area> areaList() {
        return areaRepository.findAll();
    }

    public ResponseEntity<?> deleteArea(int id) {
        Area area= findAreaById(id);
        areaRepository.delete(area);
        return ResponseEntity.ok().build();
    }

    public Area findAreaById(int id) {
        return areaRepository.findById(id)
         .orElseThrow(() -> new ResourceNotFoundException("Area not found with id " + id));
    }

    public Area updateArea(int id, Area areaDetails) {
        Area area = findAreaById(id);
        // Set the properties of the area object with the provided details
        area.setAreaName(areaDetails.getAreaName());
        area.setLocation(areaDetails.getLocation());
        area.setCleaner(area.getCleaner());
        Area savedArea = areaRepository.save(area);
        return savedArea;
    }

    public Area findAreaByName(String areaName) {
        // Use the repository method to find the area by its name
        return areaRepository.findByAreaName(areaName);
    }
}
