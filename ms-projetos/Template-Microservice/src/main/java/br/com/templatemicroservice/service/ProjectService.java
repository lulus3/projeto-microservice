package br.com.templatemicroservice.service;

import br.com.templatemicroservice.exceptions.RequiredObjectIsNullException;
import br.com.templatemicroservice.exceptions.ResourceNotFoundException;
import br.com.templatemicroservice.mappers.ProjectMapper;
import br.com.templatemicroservice.model.Project;
import br.com.templatemicroservice.repository.ProjectRepository;
import br.com.templatemicroservice.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProjectService {

    @Autowired
    ProjectRepository repository;

    @Autowired
    ProjectMapper mapper;

    public Page<ProjectDTO> findAllProjects(Pageable pageable) {

        return repository
                .findAll(pageable)
                .map(entity -> mapper.toProjectVO(entity));
    }

    public ProjectDTO findProjectById(Long id) {

        Project entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No project for this id!"));

        return mapper.toProjectVO(entity);
    }

    public ProjectDTO save(ProjectDTO projectDTO) {

        Project project = mapper.toProject(projectDTO);
        return mapper.toProjectVO(repository.save(project));
    }

    public ProjectDTO updateProject(Long id, ProjectDTO projectDTO) {

        if (projectDTO == null) throw new RequiredObjectIsNullException();

        Project entity = update(id, projectDTO);

        return mapper.toProjectVO(repository.save(entity));
    }

    public void delete(Long id) {

        Project entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No project for this ID!"));

        repository.delete(entity);
    }

    public Project update(Long id, ProjectDTO projectDTO) {

        Project project = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No project for this id!"));

        project.setProjectName(projectDTO.getName());
        project.setStartDate(projectDTO.getStartDate());
        project.setEndDate(projectDTO.getEndDate());

        return project;
    }
}
