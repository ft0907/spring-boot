package com.example.web;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.domain.Student;

@RepositoryRestResource(path = "api")
public interface BaseRepository extends JpaRepository<Student, Long> {
}
