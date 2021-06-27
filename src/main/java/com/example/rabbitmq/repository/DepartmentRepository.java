package com.example.rabbitmq.repository;


import com.example.rabbitmq.entity.Department;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository  extends MongoRepository<Department, Long> {
}
