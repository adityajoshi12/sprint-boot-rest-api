package com.example.rabbitmq.services;

import com.example.rabbitmq.entity.Department;

import java.util.List;

public interface DepartmentService {
   public Department saveDepartment(Department department);

  public List<Department> getDepartments();

   Department getDepartmentById(Long id);

    void deleteDepartment(Long id);

    Department updateDepartment(Long id, Department department);
}
