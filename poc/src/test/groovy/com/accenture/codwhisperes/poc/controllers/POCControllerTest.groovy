package com.accenture.codwhisperes.poc.controllers

import com.accenture.codewhisperers.poc.controllers.POCController
import com.accenture.codewhisperers.poc.models.Employee
import com.accenture.codewhisperers.poc.services.POCImpl;
import spock.lang.Specification;

class POCControllerTest extends Specification {
  def "'/findAll' should return a list of all employees"() {
    given:
      def pocController = new POCController(pocImpl: Mock(POCImpl))
      Employee employee1 = new Employee("1", "J1234", "Jake", "Thomas")
      Employee employee2 = new Employee("2", "A3143", "Amy", "Jacob")
      def testEmployees = [employee1, employee2]
      pocController.pocImpl.getAllEmployees() >> testEmployees
    when:
      def results = pocController.getAll()
    then:
      results == testEmployees
  }
  
  def "'/findByFirst_name' should return a list of employees with the proper first_name"() {
    given:
    def pocController = new POCController(pocImpl: Mock(POCImpl))
    Employee employee1 = new Employee("2", "A3143", "Amy", "Jacob")
    def testEmployees = [employee1]
    pocController.pocImpl.getEmployeeByFirst_name("Amy") >> testEmployees
    when:
    def results = pocController.getByFirstName("Amy")
    then:
    results == testEmployees
  }
  
  def "'/deleteByEid' should delete a listing in the database"() {
    given:
    def pocController = new POCController(pocImpl: Mock(POCImpl))
    Employee employee1 = new Employee("1", "J1234", "Jake", "Thomas")
    Employee employee2 = new Employee("2", "A3143", "Amy", "Jacob")
    def testEmployees = [employee1, employee2]
    pocController.pocImpl.removeByEid("J1234") >> 1
    when:
    def results = pocController.deleteEmployeeByEid("J1234")
    then:
    results
  }
  
  def "'/updateEmployee' should return success message"() {
    given:
    def pocController = new POCController(pocImpl: Mock(POCImpl))
    Employee newEmployee = new Employee("2", "A3143", "Amy", "Jacob")
    pocController.pocImpl.updateEmployee(newEmployee) >> newEmployee
    when:
    pocController.pocImpl.updateEmployee(newEmployee)
    newEmployee.setSecond_name("Jacobson")
    def results = pocController.updateEmployeeInfo(newEmployee)
    then:
    results.getStatusCode().toString().contains("202")
  }
}
