package org.foo.service.map;

import org.foo.dto.ProjectDTO;
import org.foo.dto.TaskDTO;
import org.foo.dto.UserDTO;
import org.foo.enums.Status;
import org.foo.service.ProjectService;
import org.foo.service.TaskService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {
    private final TaskService taskService;

    public ProjectServiceImpl(TaskService taskService) {
        super();
        this.taskService = taskService;
    }

    @Override
    public ProjectDTO save(ProjectDTO object) {
        if(object.getStatus() == null){
            object.setStatus(Status.OPEN);
        }
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public void update(ProjectDTO object) {
        ProjectDTO newProject = findById(object.getProjectCode());
        if(object.getStatus() == null){
            object.setStatus(newProject.getStatus());
        }
        super.update(object.getProjectCode(), object);
    }

    @Override
    public List<ProjectDTO> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(String projectCode) {
        super.deleteById(projectCode);
    }

    @Override
    public ProjectDTO findById(String projectCode) {
        return super.findById(projectCode);
    }

    @Override
    public List<ProjectDTO> getCountedListOfProjectDTO(UserDTO manager) {
        List<ProjectDTO> projectList = findAll().stream()
                .filter(project -> project.getAssignedManager().equals(manager))
                .map(project -> {
                    List<TaskDTO> taskList = taskService.findTasksByManager(manager);

                    int completeTaskCounts = (int)taskList.stream()
                            .filter(task -> task.getProject().equals(project) && task.getTaskStatus() == Status.COMPLETE)
                            .count();


                    int unfinishedTaskCounts = (int)taskList.stream()
                            .filter(task -> task.getProject().equals(project) && task.getTaskStatus() != Status.COMPLETE)
                            .count();;
                    project.setCompleteTaskCounts(completeTaskCounts);
                    project.setUnfinishedTaskCounts(unfinishedTaskCounts);
                    return project;
                })
                .collect(Collectors.toList());
        return projectList;
    }

    @Override
    public void complete(ProjectDTO projectDTO) {
        projectDTO.setStatus(Status.COMPLETE);
        super.save(projectDTO.getProjectCode(), projectDTO);
    }
}
