package org.foo.service.map;

import org.foo.dto.ProjectDTO;
import org.foo.service.ProjectService;

import java.util.List;

public class ProjectServiceImpl extends AbstractMapService<ProjectDTO, String> implements ProjectService {
    @Override
    public ProjectDTO save(ProjectDTO object) {
        return super.save(object.getProjectCode(), object);
    }

    @Override
    public void update(ProjectDTO object) {
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
}
