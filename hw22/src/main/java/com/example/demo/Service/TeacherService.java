package com.example.demo.Service;


import com.example.demo.Api.ApiException;
import com.example.demo.Model.Info;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.InfoRepository;
import com.example.demo.Repository.TeacherRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final InfoRepository infoRepository;

    public List<Teacher> getAll(){
        return teacherRepository.findAll();
    }

    public void add(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void update(Integer id,Teacher teacher){
        Teacher teacher1 = teacherRepository.findTeacherById(id);
        if (teacher1==null){
            throw new ApiException("not found");
        }
        teacher1.setName(teacher.getName());
        teacher1.setAge(teacher.getAge());
        teacher1.setEmail(teacher.getEmail());
        teacher1.setSalary(teacher.getSalary());
        teacherRepository.save(teacher1);
    }

    public  void delete(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null){
            throw new ApiException("not found");
        }
        infoRepository.deleteById(id);
        teacherRepository.delete(teacher);
    }

    public Info getInfo(Integer id){
        Info info = infoRepository.findInfoById(id);
        if (info==null){
            throw new ApiException("not found");
        }
        return info;
    }


}
