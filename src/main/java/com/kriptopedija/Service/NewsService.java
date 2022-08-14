package com.kriptopedija.Service;

import com.kriptopedija.Models.DTOs.NewsDto;
import com.kriptopedija.Models.News;

import java.util.List;
import java.util.Optional;

public interface NewsService {

    List<News> findAll();
    Optional<News> findById(Long Id);
    Optional<News> save(NewsDto newsDto);
    Optional<News> edit(Long Id, NewsDto newsDto);
    void deleteById(Long Id);

}
