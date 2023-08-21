package com.example.demo.Service;


import com.example.demo.Model.Course;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.CourseRepository;
import com.example.demo.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;
    private final TeacherRepository teacherRepository;

    public List<Course> get(){
        return courseRepository.findAll();
    }


    public void add(Course course ,Integer teacher_id ){
        Teacher teacher = teacherRepository.findTeacherById(teacher_id);
        course.setTeacher(teacher);
        courseRepository.save(course);
    }

    public void update(Integer id,Course course){
        Course course1 = courseRepository.findCourseById(id);

        course1.setName(course.getName());
        courseRepository.save(course1);
    }

    public void delete(Integer id){
        Course course1 = courseRepository.findCourseById(id);
        courseRepository.delete(course1);
    }

    public Teacher find(Integer id){
        Course course1 = courseRepository.findCourseById(id);
        return course1.getTeacher();
    }



}
