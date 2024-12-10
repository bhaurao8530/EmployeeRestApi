package com.tutorialspoint.demo;

public class Employee {
   private String id;
   private String name;
   private String email;  // Changed varchar to String
   private double salary; 

  
   public String getId() {
      return id;
   }
   public void setId(String id) {
      this.id = id;
   }
   public String getName() {
      return name;
   }
   public void setName(String name) {
      this.name = name;
   }


   public String getEmail() {
      return email;
   }
   public void setEmail(String email) {
      this.email = email;
   }

  
   public double getSalary() {
      return salary;
   }
   public void setSalary(double salary) {
      this.salary = salary;
   }
}
