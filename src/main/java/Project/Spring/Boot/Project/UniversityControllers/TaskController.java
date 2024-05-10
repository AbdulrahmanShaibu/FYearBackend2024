package Project.Spring.Boot.Project.UniversityControllers;

import Project.Spring.Boot.Project.University.Models.Task;
import Project.Spring.Boot.Project.UniversityServices.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/v1")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping("/save/task")
    public Task createTask(@RequestBody Task task){
        return taskService.createTask(task);
    }

    @GetMapping("/task/list")
    public List<Task>taskList(){
        return taskService.taskList();
    }

    @GetMapping("/list/{id}")
    public Optional<Task> findTaskById(@PathVariable(value = "id") int id){
        return taskService.findTaskById(id);
    }

    @PutMapping("/update/task/{id}")
    public Task updateTask(@PathVariable(value = "id") int id, Task task){
        return taskService.updateTask(id,task);
    }

    @DeleteMapping("/delete/task/{id}")
    public void deleteTask(@PathVariable(value = "id") int id, Task task){
        taskService.deleteTask(id,task);
    }

    @GetMapping("/count/tasks")
    public long countTasks(){
        return taskService.countTasks();
    }

}
