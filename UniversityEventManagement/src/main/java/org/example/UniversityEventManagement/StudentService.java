package org.example.UniversityEventManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentService {
    @Autowired
    IStudentRepo studentRepo;

    public StudentService(IStudentRepo studentRepo) {
        this.studentRepo = studentRepo;
    }

    public String addStudent(Student student){
        studentRepo.save(student);
        return "student has been added";
    }
//this section still creates issues need to rectify it
    public String updateStudentDepartment(Integer Id, String department){
        Optional<Student>studentOptional = studentRepo.findById(Id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setDepartment(TYPE.valueOf(department));
            studentRepo.save(student);
            return "Student has been updated";
        }return "ID not found";
    }

    public String deleteStudent(Integer Id){
        Optional<Student>studentOptional = studentRepo.findById(Id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            studentRepo.delete(student);
            return "student has been removed";
        }return "Id could not be found";
    }

    public List<Student> getAllStudents(){
        return (List<Student>)studentRepo.findAll();
    }

    public Student getStudent(Integer Id) {
        return studentRepo.findById(Id).orElse(null);
    }
}
