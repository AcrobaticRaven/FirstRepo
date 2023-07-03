package org.example.UniversityEventManagement;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }
@PostMapping("student")
    public String addStudent(@Valid @RequestBody Student student){
        return studentService.addStudent(student);
    }

    //this section still creates issues need to rectify it
@PutMapping("student/Id/{Id}")
    public String updateStudentDepartment(@PathVariable Integer Id,@Valid @RequestBody String department){
        return studentService.updateStudentDepartment(Id, department);
    }
@DeleteMapping("student/{Id}")
    public String deleteStudent(@PathVariable Integer Id){
        return studentService.deleteStudent(Id);
    }
@GetMapping("students")
    public List<Student>getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("student/Id/{Id}")
    public Student getStudent(@PathVariable Integer Id){
        return studentService.getStudent(Id);
    }
}
