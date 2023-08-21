package com.example.demo.Controller;


import com.example.demo.Api.ApiResponse;
import com.example.demo.Model.Course;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.CourseService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/ll")
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(courseService.get());
    }

    @PostMapping("/add/{Teacher_id}")
    public ResponseEntity add(@RequestBody @Valid Course course,@PathVariable Integer Teacher_id){
        courseService.add(course,Teacher_id);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity update(@PathVariable Integer id,@RequestBody @Valid Course course){
        courseService.update(id,course);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        courseService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }

    @GetMapping("/find/{id}")
    public ResponseEntity find(@PathVariable Integer id){
        return ResponseEntity.status(200).body(courseService.find(id));
    }

}
