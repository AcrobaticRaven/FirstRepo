package org.example.MappingsPractice.Service;

import org.example.MappingsPractice.Model.Course;
import org.example.MappingsPractice.Repository.ICourseRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CourseService {

    @Autowired
    ICourseRepo courseRepo;

    public List<Course>getAllCourses(){
       return courseRepo.findAll();
    }

    public String addCourse(Course course){
        courseRepo.save(course);
        return "Course has been added";
    }

    public String updateCourse(Long Id,String couseTitle, String courseDescription,String courseDuration){
        Optional<Course>courseOptional = courseRepo.findById(Id);
        if(courseOptional.isPresent()){
            Course course = courseOptional.get();
            course.setCourseDescription(courseDescription);
            course.setCourseDuration(courseDuration);
            course.setCourseTitle(couseTitle);
            courseRepo.save(course);
            return "Course has been updated";
        }return "Course could not be found for Id : " + Id;
    }

    public String deleteCourse(Long Id){
        Optional<Course>courseoptional = courseRepo.findById(Id);
        if(courseoptional.isPresent()){
            Course course = courseoptional.get();
            courseRepo.delete(course);
            return "Course has been removed ";
        }return "could not find a course of Id : " + Id;
    }
}
