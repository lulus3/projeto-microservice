package br.com.templatemicroservice.controller;

import br.com.templatemicroservice.service.ProjectService;
import br.com.templatemicroservice.utils.CustomMediaType;
import br.com.templatemicroservice.dto.ProjectDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    @Autowired
    ProjectService service;

    @GetMapping(produces = CustomMediaType.APPLICATION_JSON)
    public Page<ProjectDTO> listAllProjects(@PageableDefault(size = 10) Pageable pageable) {
        return service.findAllProjects(pageable);
    }

    @GetMapping(value = "/{id}",
            produces = CustomMediaType.APPLICATION_JSON)
    public ProjectDTO findProjectById(@PathVariable(value = "id") Long id) {
        return service.findProjectById(id);
    }

    @PostMapping(
            consumes = CustomMediaType.APPLICATION_JSON,
            produces = CustomMediaType.APPLICATION_JSON)
    public ResponseEntity<ProjectDTO> create(@RequestBody ProjectDTO projectDTO, UriComponentsBuilder uriBuilder) {

        ProjectDTO vo = service.save(projectDTO);
        URI address = uriBuilder.path("api/entity/{id}").buildAndExpand(projectDTO.getId()).toUri();

        return ResponseEntity.created(address).body(vo);
    }

    @PutMapping(value = "/{id}",
            consumes = CustomMediaType.APPLICATION_JSON,
            produces = CustomMediaType.APPLICATION_JSON)
    public ResponseEntity<ProjectDTO> update(@RequestBody ProjectDTO projectDTO, @PathVariable(value = "id") Long id) {
        ProjectDTO updated = service.updateProject(id, projectDTO);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ProjectDTO> delete(@PathVariable(value = "id") Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
