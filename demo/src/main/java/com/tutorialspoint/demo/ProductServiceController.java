package com.tutorialspoint.demo;


import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductServiceController {
   private static final Map<String, Employee> employeeRepo = new HashMap<>();
   static {
      Employee bhaurao = new Employee();
      bhaurao.setId("1");
      bhaurao.setName("Bhaurao");
      bhaurao.setEmail("bhaurao@gmail.com");
      bhaurao.setSalary(155565.55);
      employeeRepo.put(bhaurao.getId(), bhaurao);

      

      Employee pratik = new Employee();
      pratik.setId("2");
      pratik.setName("Pratik");
      pratik.setEmail("pratik@gmail.com");
      pratik.setSalary(255565.55);
      employeeRepo.put(pratik.getId(), pratik);
   }
   
   @DeleteMapping(value = "/employee/{id}")
   public ResponseEntity<Object> delete(@PathVariable("id") String id) { 
      employeeRepo.remove(id);
      return new ResponseEntity<>("Employee is Deleted Successsfully", HttpStatus.OK);
   }
   
   @PutMapping(value = "/employee/{id}")
   public ResponseEntity<Object> updateProduct(@PathVariable("id") String id, @RequestBody Employee employee) { 
      employeeRepo.remove(id);
      employee.setId(id);
      employeeRepo.put(id, employee);
      return new ResponseEntity<>("Employee is Updated Successsfully", HttpStatus.OK);
   }
   
   @PostMapping(value = "/employee")
   public ResponseEntity<Object> createProduct(@RequestBody Employee employee) {
      employeeRepo.put(employee.getId(), employee);
      return new ResponseEntity<>("Employee is Created Successfully", HttpStatus.CREATED);
   }
   
   @GetMapping(value = "/employee")
   public ResponseEntity<Object> getProduct() {
      return new ResponseEntity<>(employeeRepo.values(), HttpStatus.OK);
   }
}
