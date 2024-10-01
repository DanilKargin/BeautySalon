package com.example.demo.mappers;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.fasterxml.jackson.databind.cfg.MapperConfig;
import org.mapstruct.Mapper;

@Mapper
public interface EmployeeMapper {
    Employee toEmployee(EmployeeDTO dto);
    EmployeeDTO toDTO(Employee employee);
}
