package br.com.templatemicroservice.repository;

import br.com.templatemicroservice.model.BaseEntity;
import br.com.templatemicroservice.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {}
