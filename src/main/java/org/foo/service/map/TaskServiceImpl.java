package org.foo.service.map;
import org.foo.dto.ProjectDTO;
import org.foo.dto.TaskDTO;
import org.foo.dto.UserDTO;
import org.foo.enums.Status;
import org.foo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public List<TaskDTO> findTasksByManager(UserDTO manager) {
        return findAll().stream()
                .filter(task -> task.getProject().getAssignedManager().equals(manager))
                .collect(Collectors.toList());
    }

    @Override
    public TaskDTO save(TaskDTO object) {
        if(object.getTaskStatus() == null){
            object.setTaskStatus(Status.OPEN);
        }
        if(object.getAssignedDate() == null){
            object.setAssignedDate(LocalDate.now());
        }
        if(object.getId() == null){
            object.setId(UUID.randomUUID().getMostSignificantBits());
        }
        return super.save(object.getId(), object);
    }

    @Override
    public void update(TaskDTO object) {
        TaskDTO newTask = findById(object.getId());
        if(object.getTaskStatus() == null){
            object.setTaskStatus(newTask.getTaskStatus());
        }
        object.setAssignedDate(LocalDate.now());
        super.update(object.getId(), object);
    }

    @Override
    public List<TaskDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public TaskDTO findById(Long id) {
        return super.findById(id);
    }
}
