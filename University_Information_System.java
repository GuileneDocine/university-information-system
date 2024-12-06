/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

 package com.mycompany.university_information_system;

 /**
  *
  * @author GENIUS ELECTRONICS
  */
 
 import java.util.ArrayList;
 import java.util.List;
 import java.util.Scanner;
 
 // Class representing a Professor
 class Professor {
     private String Name;
 
     public Professor(String name) {
         this.Name = name;
     }
 
     public String getName() {
         return Name;
     }
 
     @Override
     public String toString() {
         return Name;
     }
 }
 
 // Class representing a Student
 class Student {
     private String Name;
 
     public Student(String name) {
         this.Name = name;
     }
 
     public String getName() {
         return Name;
     }
 
     @Override
     public String toString() {
         return Name;
     }
 }
 
 // Class representing a Department
 class Department {
     private String name;
     private List<Professor> professors;
     private List<Student> students;
 
     public Department(String name) {
         this.name = name;
         this.professors = new ArrayList<>();
         this.students = new ArrayList<>();
     }
 
     public String getName() {
         return name;
     }
 
     public void addProfessor(Professor professor) {
         professors.add(professor);
     }
 
     public void addStudent(Student student) {
         students.add(student);
     }
 
     public List<Professor> getProfessors() {
         return professors;
     }
 
     public List<Student> getStudents() {
         return students;
     }
 
     @Override
     public String toString() {
         return "Department: " + name;
     }
 }
 
 // Class representing a University
 class University {
     private List<Department> departments;
 
     public University() {
         departments = new ArrayList<>();
     }
 
     public void addDepartment(Department department) {
         departments.add(department);
         System.out.println("Department added successfully!");
     }
 
     public Department findDepartment(String name) {
         for (Department dept : departments) {
             if (dept.getName().equalsIgnoreCase(name)) {
                 return dept;
             }
         }
         return null;
     }
 
     public void listDepartmentDetails() {
         for (Department dept : departments) {
             System.out.println(dept);
             System.out.println("Professors: " + dept.getProfessors());
             System.out.println("Students: " + dept.getStudents());
         }
     }
 }
 
  // Main class to run the University Information System
 public class University_Information_System {
     public static void main(String[] args) {
         Scanner scanner = new Scanner(System.in);
         University university = new University();
 
         int choice;
         do {
             System.out.println("\nWelcome to the University Information System");
             System.out.println("1. Add Department");
             System.out.println("2. Add Professor");
             System.out.println("3. Add Student");
             System.out.println("4. List Department Details");
             System.out.println("5. Exit");
             System.out.print("Enter your choice: ");
             choice = scanner.nextInt();
             scanner.nextLine(); // Consume newline
 
             switch (choice) {
                 case 1: // Add Department
                     System.out.print("Enter department name: ");
                     String deptName = scanner.nextLine();
                     university.addDepartment(new Department(deptName));
                     break;
 
                 case 2: // Add Professor
                     System.out.print("Enter department name: ");
                     deptName = scanner.nextLine();
                     Department department = university.findDepartment(deptName);
                     if (department != null) {
                         System.out.print("Enter professor name: ");
                         String profName = scanner.nextLine();
                         department.addProfessor(new Professor(profName));
                     } else {
                         System.out.println("Department not found!");
                     }
                     break;
 
                 case 3: // Add Student
                     System.out.print("Enter department name: ");
                     deptName = scanner.nextLine();
                     department = university.findDepartment(deptName);
                     if (department != null) {
                         System.out.print("Enter student name: ");
                         String studentName = scanner.nextLine();
                         department.addStudent(new Student(studentName));
                     } else {
                         System.out.println("Department not found!");
                     }
                     break;
 
                 case 4: // List Department Details
                     university.listDepartmentDetails();
                     break;
 
                 case 5: // Exit
                     System.out.println("Exiting the system.");
                     break;
 
                 default:
                     System.out.println("Invalid choice, please try again.");
             }
         } while (choice != 5);
 
         scanner.close();
     }
 }
 