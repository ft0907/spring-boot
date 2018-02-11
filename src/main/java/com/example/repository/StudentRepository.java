package com.example.repository;

import org.springframework.stereotype.Repository;

import com.example.domain.Student;

@Repository
public interface StudentRepository extends BaseRepository<Student, Long> {

}
