package com.kriptopedija.Controllers;

import com.kriptopedija.Models.Course;
import com.kriptopedija.Models.DTOs.SubmitTestDto;
import com.kriptopedija.Models.Test;
import com.kriptopedija.Service.CourseService;
import com.kriptopedija.Service.TestService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping(value = {"/courses"})
@AllArgsConstructor
public class CourseController {

    private final CourseService courseService;
    private final TestService testService;

    @GetMapping
    private List<Course> findAll(){
        return courseService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Course> findById(@PathVariable Long id){
        return courseService.findById(id)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/test")
    public ResponseEntity<Test> findTestByCourseId(@PathVariable Long id){
        return testService.findTestByCourseId(id)
                .map(test -> ResponseEntity.ok().body(test))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

    // Implement submit Test to get points!
    @PostMapping("/{id}/test")
    public ResponseEntity<SubmitTestDto> submitTestByCourseId(@RequestBody SubmitTestDto submitTestDto){
        if (submitTestDto != null)
            return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

    @GetMapping("/search")
    public ResponseEntity<Course> findByName(@RequestParam String name){
        return courseService.findByName(name)
                .map(course -> ResponseEntity.ok().body(course))
                .orElseGet(()->ResponseEntity.notFound().build());
    }

}
