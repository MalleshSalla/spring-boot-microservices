package com.departmentservice.app.service.impl;


import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;

import com.departmentservice.app.dto.DepartmentDto;
import com.departmentservice.app.entity.Department;
import com.departmentservice.app.mapper.DepartmentMapper;
import com.departmentservice.app.repository.DepartmentRepository;
import com.departmentservice.app.service.DepartmentService;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {

        // convert department dto to department jpa entity
        Department department = DepartmentMapper.mapToDepartment(departmentDto);

        Department savedDepartment = departmentRepository.save(department);

        DepartmentDto savedDepartmentDto = DepartmentMapper.mapToDepartmentDto(savedDepartment);

        return savedDepartmentDto;
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {

        Department department = departmentRepository.findByDepartmentCode(departmentCode);

        DepartmentDto departmentDto = DepartmentMapper.mapToDepartmentDto(department);

        return departmentDto;
    }
}