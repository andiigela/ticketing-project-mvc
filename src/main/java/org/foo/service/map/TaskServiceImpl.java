package org.foo.service.map;
import org.foo.dto.ProjectDTO;
import org.foo.dto.TaskDTO;
import org.foo.enums.Status;
import org.foo.service.TaskService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskServiceImpl extends AbstractMapService<TaskDTO, Long> implements TaskService {
    @Override
    public TaskDTO save(TaskDTO object) {
        if(object.getTaskStatus() == null){
            object.setTaskStatus(Status.OPEN);
        }
        object.setAssignedDate(LocalDate.now());
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
