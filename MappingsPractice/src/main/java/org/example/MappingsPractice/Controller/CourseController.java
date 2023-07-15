package org.example.MappingsPractice.Controller;

import org.example.MappingsPractice.Model.Course;
import org.example.MappingsPractice.Service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    CourseService courseService;



    @GetMapping("Courses")
    public List<Course> getAllCourses(){
        return courseService.getAllCourses();
    }


    @PutMapping("course")
    public String updateCourse(@RequestParam Long Id, @RequestParam String title, @RequestParam String description, @RequestParam String duration){
        return courseService.updateCourse(Id,title,description,duration);
    }

    @PostMapping("course")
    public String addCourse(@RequestBody Course course){
        return courseService.addCourse(course);
    }

    @DeleteMapping("course/{Id}")
    public String deleteCourse(@PathVariable Long Id){
        return courseService.deleteCourse(Id);
    }
}
