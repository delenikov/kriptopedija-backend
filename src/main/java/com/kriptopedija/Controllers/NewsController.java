package com.kriptopedija.Controllers;

import com.kriptopedija.Models.News;
import com.kriptopedija.Service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping(value = {"/news"})
@AllArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @GetMapping
    private List<News> findAll(){
        return newsService.findAll();
    }

    @GetMapping("/{id}")
    private ResponseEntity<News> findById(@PathVariable Long id){
        return newsService.findById(id)
                .map(news -> ResponseEntity.ok().body(news))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

}
