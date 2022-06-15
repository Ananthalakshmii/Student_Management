package com.accolite.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accolite.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long>{

}
