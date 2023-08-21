package com.example.demo.Service;


import com.example.demo.Dto.InfoDto;
import com.example.demo.Model.Info;
import com.example.demo.Model.Teacher;
import com.example.demo.Repository.InfoRepository;
import com.example.demo.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InfoService {

    private final InfoRepository infoRepository;
    private final TeacherRepository teacherRepository;


    public void add(InfoDto infoDto){
        Teacher teacher = teacherRepository.findTeacherById(infoDto.getTeacher_Id());

        Info info = new Info(null,infoDto.getArea(),infoDto.getStreet(),infoDto.getBuilding(),teacher);
        infoRepository.save(info);
    }

    public void update(InfoDto infoDto){
        Info info = infoRepository.findInfoById(infoDto.getTeacher_Id());
        info.setArea(infoDto.getArea());
        info.setStreet(infoDto.getStreet());
        info.setBuilding(infoDto.getBuilding());

        infoRepository.save(info);

    }


    public void delete(Integer id){
        Info info = infoRepository.findInfoById(id);
        infoRepository.delete(info);
    }


}
