package com.example.demo.rest;

import com.example.demo.dto.EmployeeDTO;
import com.example.demo.service.EmployeeService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.Parameter;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.util.MimeTypeUtils.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping("employees")
@FieldDefaults(level= AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public class EmployeeController {
    EmployeeService employeeService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<EmployeeDTO>> showEmployeeList(
        @PageableDefault()
        Pageable pageable
    ){
        return ResponseEntity.ok(employeeService.getEmployeeList(pageable));
    }
    @PostMapping
    public void addEmployee(@RequestBody EmployeeDTO newEmployee){

    }

    @GetMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> findEmployee(@PathVariable
                                                    Long id){
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PutMapping(path = "/{id}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<EmployeeDTO> editEmployee(@RequestBody EmployeeDTO newEmployee,
                                                    @PathVariable
                                                    Long id){
        return ResponseEntity.ok(employeeService.editEmployee(newEmployee, id));
    }

    @DeleteMapping(path = "/{id}")
    public void deleteEmployee(@PathVariable
                               Long id){
        employeeService.deleteEmployee(id);
    }
}
