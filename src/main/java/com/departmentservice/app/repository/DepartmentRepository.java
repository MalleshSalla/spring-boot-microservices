package com.departmentservice.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.departmentservice.app.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Department findByDepartmentCode(String departmentCode);
}
