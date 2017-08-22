package com.example.repository;

import java.io.Serializable;

import org.springframework.stereotype.Repository;

import com.example.domain.Student;

@Repository
public interface StudentRepository extends BaseRepository<Student, Serializable> {

}
