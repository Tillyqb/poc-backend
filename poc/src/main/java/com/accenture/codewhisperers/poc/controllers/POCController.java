package com.accenture.codewhisperers.poc.controllers;

import com.accenture.codewhisperers.poc.models.Employee;
import com.accenture.codewhisperers.poc.services.POCImpl;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@RestController
@Slf4j
public class POCController {
  @Autowired
  private final String className = getClass().getSimpleName() + ".";
  private static final String START = "INIT ";
  private static final String SUCCESS = "PASS ";
  private static final String ERROR = "WARN ";
  private POCImpl pocImpl;

  @GetMapping("/findAll")
  public List<Employee> getAll(){
    return pocImpl.getAllEmployees();
  }

  @GetMapping("/findByFirst_name/{first_name}")
  public List<Employee> getByFirstName(@PathVariable String first_name) {
    return pocImpl.getEmployeeByFirst_name(first_name);
  }

  @PutMapping(value = "/update")
  public ResponseEntity<Object> updateEmployeeInfo(Employee employee) {
    String outputReadout = className + Thread.currentThread().getStackTrace()[1].getMethodName() + " ";
    try {
      pocImpl.updateEmployee(employee);
      return new ResponseEntity<>("Record ID: " + employee.getEid() + "\nRegistration Updated", HttpStatus.ACCEPTED);
    } catch (Exception e) {
      return new ResponseEntity<>( "Registration Rejected",HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/deleteByEid/{eid}")
  public boolean deleteEmployeeByEid(@PathVariable String eid) {
    return pocImpl.removeByEid(eid);
  }
}
