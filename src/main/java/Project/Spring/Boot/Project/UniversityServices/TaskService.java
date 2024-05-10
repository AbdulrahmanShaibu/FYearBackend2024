package Project.Spring.Boot.Project.UniversityServices;

import Project.Spring.Boot.Project.University.Models.Task;
import Project.Spring.Boot.Project.UniversityRepository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    @Autowired
    private TaskRepository taskRepository;

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> taskList() {
        return taskRepository.findAll();
    }

    public Optional<Task> findTaskById(int id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(int id, Task task) {
        Optional<Task> data=findTaskById(id);
        if (data.isPresent()){
            task.setDescription(task.getDescription());
            taskRepository.save(task);
        } else {
            ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("failed to update task with id:"+id);
        }return task;
    }

    public void deleteTask(int id, Task task) {
        Optional<Task> data=findTaskById(id);
        if (data.isPresent()){
            taskRepository.delete(task);
        }else {
            ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("failed to delete task with id:"+id);
        }
    }

    public long countTasks() {
        return taskRepository.count();
    }
}
