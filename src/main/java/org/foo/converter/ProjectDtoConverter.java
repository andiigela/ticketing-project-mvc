package org.foo.converter;

import org.foo.dto.ProjectDTO;
import org.foo.service.ProjectService;
import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class ProjectDtoConverter implements Converter<String, ProjectDTO> {
    ProjectService projectService;
    public ProjectDtoConverter(ProjectService projectService){
        this.projectService=projectService;
    }
    @Override
    public ProjectDTO convert(String projectId) {
        return projectService.findById(projectId);
    }
}
