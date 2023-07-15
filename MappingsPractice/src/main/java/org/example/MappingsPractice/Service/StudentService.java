package org.example.MappingsPractice.Service;

import org.example.MappingsPractice.Model.Student;
import org.example.MappingsPractice.Repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    IStudentRepo studentRepo;


    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    public String addStudentDetails(Student student){
        studentRepo.save(student);
        return "Student details  has been added";
    }

    public String updateStudentDetails(Long Id,String Name, String Age, String number,String branch, String department){
        Optional<Student> studentOptional = studentRepo.findById(Id);
        if(studentOptional.isPresent()){
            Student student = studentOptional.get();
            student.setStudentBranch(branch);
            student.setStudentAge(Age);
            student.setStudentName(Name);
            student.setStudentPNumber(number);
            student.setStudentDepartment(department);
            studentRepo.save(student);
            return "Student details has been updated";
        }return "Student could not be found for Id : " + Id;
    }

    public String deleteStudentDetails(Long Id){

        Optional<Student>studentoptional = studentRepo.findById(Id);
        if(studentoptional.isPresent()){
            Student student = studentoptional.get();
            studentRepo.delete(student);
            return "Student details has been removed ";
        }return "could not find a student of Id : " + Id;
    }
}
