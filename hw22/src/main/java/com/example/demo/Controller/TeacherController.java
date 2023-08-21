package com.example.demo.Controller;


import com.example.demo.Api.ApiResponse;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.TeacherService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
public class TeacherController {

private final TeacherService teacherService;


@GetMapping("/get")
public ResponseEntity getAll(){
    return ResponseEntity.status(200).body(teacherService.getAll());
}

@PostMapping("/add")
public ResponseEntity add(@RequestBody @Valid Teacher teacher){
    teacherService.add(teacher);
    return ResponseEntity.status(200).body(new ApiResponse("added"));
}

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Teacher teacher){
        teacherService.update(id,teacher);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

@DeleteMapping("/delete/{id}")
public ResponseEntity delete(@PathVariable Integer id){
    teacherService.delete(id);
    return ResponseEntity.status(200).body(new ApiResponse("deleted"));
}


@GetMapping("/info/{id}")
public ResponseEntity info(@PathVariable Integer id){
    return ResponseEntity.status(200).body(teacherService.getInfo(id));
}
}
