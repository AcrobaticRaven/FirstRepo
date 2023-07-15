package org.example.MappingsPractice.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity


public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    private String courseTitle;
    private String courseDescription;
    private String courseDuration;

    @ManyToMany
    @JoinTable(name = "course_student_join_table",joinColumns = @JoinColumn(name = "fk_course_id"),inverseJoinColumns = @JoinColumn(name = "fk_student_id"))
    List<Student>students;
}
