package org.example.MappingsPractice.Controller;

import org.example.MappingsPractice.Model.Student;
import org.example.MappingsPractice.Service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;


    @GetMapping("Students")
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }


    @PutMapping("student")
    public String updateStudent(@RequestParam Long Id, @RequestParam String name, @RequestParam String age, @RequestParam String pnumber,@RequestParam String branch, @RequestParam String department){
        return studentService.updateStudentDetails(Id,name,age,pnumber,branch,department);
    }

    @PostMapping("student")
    public String addStudent(@RequestBody Student student){
        return studentService.addStudentDetails(student);
    }

    @DeleteMapping("student/{Id}")
    public String deleteStudent(@PathVariable Long Id){
        return studentService.deleteStudentDetails(Id);
    }
}
