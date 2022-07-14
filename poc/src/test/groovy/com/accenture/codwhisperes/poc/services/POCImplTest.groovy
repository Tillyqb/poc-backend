package com.accenture.codwhisperes.poc.services

import com.accenture.codewhisperers.poc.models.Employee
import com.accenture.codewhisperers.poc.repositories.POCRepo
import com.accenture.codewhisperers.poc.services.POCImpl
import spock.lang.Specification


class POCImplTest extends Specification {
  def "should return a list of employees"() {
    given:
    def pocImpl = new POCImpl(pocRepo: Mock(POCRepo))
    Employee employee1 = new Employee("1", "J1234", "Jake", "Thomas")
    Employee employee2 = new Employee("2", "A3143", "Amy", "Jacob")
    def testEmployees = [employee1, employee2]
    pocImpl.pocRepo.findAll() >> testEmployees
    when:
    def results = pocImpl.getAllEmployees()
    then:
    results == testEmployees
  }
  
  def "'findByFirstName' should return a list of employees with the desired first_name"() {
    given:
    def pocImpl = new POCImpl(pocRepo: Mock(POCRepo))
    Employee employee1 = new Employee("1", "J1234", "Jake", "Thomas")
    def testEmployees = [employee1]
    pocImpl.pocRepo.findByFirst_name("Jake") >> testEmployees
    when:
    def results = pocImpl.getEmployeeByFirst_name("Jake")
    then:
    results == testEmployees
  }
  
  def "'deleteById' should delete a single entry form the database"() {
    given:
    def pocImpl = new POCImpl(pocRepo: Mock(POCRepo))
    Employee employee1 = new Employee("1", "J1234", "Jake", "Thomas")
    Employee employee2 = new Employee("2", "A3143", "Amy", "Jacob")
    def testEmployees = [employee1, employee2]
    pocImpl.pocRepo.deleteByEid("J1234") >> 1
    when:
    def results = pocImpl.removeByEid("J1234")
    then:
    results
  }
  
  def "'updateByEid' should return the updated object"() {
    given:
    def pocImpl = new POCImpl(pocRepo: Mock(POCRepo))
    Employee newEmployee = new Employee("2", "A3143", "Amy", "Jacob")
    pocImpl.pocRepo.save(newEmployee) >> newEmployee
    pocImpl.pocRepo.findByEid(newEmployee.getEid()) >> newEmployee
    when:
    pocImpl.pocRepo.save(newEmployee)
    newEmployee.setSecond_name("Jacobson")
    def Employee results = pocImpl.updateEmployee(newEmployee)
    then:
    results.getSecond_name() == "Jacobson"
  }
}