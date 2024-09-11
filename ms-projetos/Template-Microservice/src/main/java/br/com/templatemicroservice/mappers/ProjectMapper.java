package br.com.templatemicroservice.mappers;

import br.com.templatemicroservice.model.Project;
import br.com.templatemicroservice.dto.ProjectDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProjectMapper {

    private final ModelMapper mapper;

    public ProjectMapper(ModelMapper mapper) {
        this.mapper = mapper;
    }

    public Project toProject(ProjectDTO vo) {
        return mapper.map(vo, Project.class);
    }

    public ProjectDTO toProjectVO(Project entity)
    {
        return mapper.map(entity, ProjectDTO.class);
    }

    public List<Project> toProjectList(List<ProjectDTO> entities) {
        return entities.stream()
                .map(this::toProject)
                .collect(Collectors.toList());
    }

    public List<ProjectDTO> toProjectVOList(List<Project> entities) {
        return entities.stream()
                .map(this::toProjectVO)
                .collect(Collectors.toList());
    }
}
