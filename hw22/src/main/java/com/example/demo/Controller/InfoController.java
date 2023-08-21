package com.example.demo.Controller;


import com.example.demo.Api.ApiResponse;
import com.example.demo.Dto.InfoDto;
import com.example.demo.Service.InfoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/gg")
public class InfoController {

    private final InfoService infoService;



    @PostMapping("/add")
    public ResponseEntity add(@RequestBody @Valid InfoDto infoDto){
        infoService.add(infoDto);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }



    @PutMapping("/update")
    public ResponseEntity update(@RequestBody @Valid InfoDto infoDto){
        infoService.update(infoDto);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        infoService.delete(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


}
