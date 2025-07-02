package org.foo.service.map;

import org.foo.dto.ProjectDTO;
import org.foo.enums.Status;
import org.foo.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {
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
    public void complete(ProjectDTO projectDTO) {
        projectDTO.setStatus(Status.COMPLETE);
        super.save(projectDTO.getProjectCode(), projectDTO);
    }
}
