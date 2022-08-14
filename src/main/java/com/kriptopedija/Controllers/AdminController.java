package com.kriptopedija.Controllers;

import com.kriptopedija.Models.Course;
import com.kriptopedija.Models.Crypto;
import com.kriptopedija.Models.DTOs.NewsDto;
import com.kriptopedija.Models.News;
import com.kriptopedija.Service.CourseService;
import com.kriptopedija.Service.CryptoService;
import com.kriptopedija.Service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping(value = {"/admin"})
@AllArgsConstructor
public class AdminController {

    private final NewsService newsService;
    private final CryptoService cryptoService;
    private final CourseService courseService;

    /* Course */
    @PostMapping("courses/add")
    public ResponseEntity<Course> saveCourse(@RequestBody Course course){
        return courseService.save(course)
                .map(theCourse -> ResponseEntity.ok().body(theCourse))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("courses/{id}/delete")
    public ResponseEntity<Course> deleteCourse(@PathVariable Long id){
        courseService.deleteById(id);
        if(courseService.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }


    /* News */
    @PostMapping("news/add")
    public ResponseEntity<News> saveNews(@RequestBody NewsDto newsDto){
        return newsService.save(newsDto)
                .map(news -> ResponseEntity.ok().body(news))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PutMapping("news/{id}/edit")
    public ResponseEntity<News> editNews(@PathVariable Long id, @RequestBody NewsDto newsDto){
        return newsService.edit(id, newsDto)
                .map(news -> ResponseEntity.ok().body(news))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("news/{id}/delete")
    public ResponseEntity<News> deleteNews(@PathVariable Long id){
        newsService.deleteById(id);
        if(newsService.findById(id).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

    /*
                                        Crypto
     */
    @PostMapping("crypto/add")
    public ResponseEntity<Crypto> saveCrypto(@RequestBody Crypto crypto){
        return cryptoService.save(crypto)
                .map(theCrypto -> ResponseEntity.ok().body(theCrypto))
                .orElseGet(()-> ResponseEntity.badRequest().build());
    }

    @PutMapping("crypto/{name}/edit")
    public ResponseEntity<Crypto> editCrpyto(@PathVariable String name, @RequestBody Crypto crypto){
        return cryptoService.edit(crypto)
                .map(theCrypto -> ResponseEntity.ok().body(theCrypto))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("crypto/{name}/delete")
    public ResponseEntity<Crypto> deleteCrypto(@PathVariable String name){
        cryptoService.deleteById(name);
        if(cryptoService.findById(name).isPresent()){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().build();
    }

}
