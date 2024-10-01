package com.example.demo.service;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.entity.Employee;
import com.example.demo.mappers.EmployeeMapper;
import com.example.demo.repository.EmployeeRepository;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@Transactional(readOnly = true)
public class EmployeeService {
    EmployeeRepository employeeRepository;
    EmployeeMapper employeeMapper;


    public List<EmployeeDTO> getEmployeeList(Pageable pageable){
        Page<Employee> employees = employeeRepository.findAll(pageable);

        return employees.stream()
                .map(employeeMapper::toDTO).toList();
    }
    @Transactional
    public void saveEmployee(EmployeeDTO newEmployee){
        if(employeeRepository.findById(newEmployee.id()).isPresent()){
            throw new RuntimeException("Can't add new employee: It's already exist");
        }
        employeeRepository.save(employeeMapper.toEmployee(newEmployee));
    }
    @Transactional
    public EmployeeDTO findById(Long id){
        return employeeMapper.toDTO(employeeRepository.findById(id).get());
    }

    @Transactional
    public EmployeeDTO editEmployee(EmployeeDTO newEmployee, Long id){
        return employeeMapper.toDTO(employeeRepository.save(employeeMapper.toEmployee(newEmployee)));
    }


    @Transactional
    public void deleteEmployee(Long id){
        employeeRepository.deleteById(id);
    }


}
