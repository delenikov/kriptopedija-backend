package com.kriptopedija.Service.Implementation;

import com.kriptopedija.Exceptions.NewsNotFoundException;
import com.kriptopedija.Models.DTOs.NewsDto;
import com.kriptopedija.Models.News;
import com.kriptopedija.Repository.NewsRepository;
import com.kriptopedija.Service.NewsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsRepository newsRepository;

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public Optional<News> findById(Long Id) {
        return newsRepository.findById(Id);
    }

    @Override
    public Optional<News> save(NewsDto newsDto) {
        if(newsRepository.findByName(newsDto.getName()).isPresent()){
            newsRepository.deleteByName(newsDto.getName());
        }
        News news = new News(newsDto.getName(), newsDto.getDescription(), newsDto.getText());
        newsRepository.save(news);
        return Optional.of(news);
    }

    @Override
    public Optional<News> edit(Long Id, NewsDto newsDto) {
        News news = newsRepository.findById(Id).orElseThrow(()-> new NewsNotFoundException(Id));
        news.setName(newsDto.getName());
        news.setDescription(newsDto.getDescription());
        news.setText(newsDto.getText());
        news.setDate(newsDto.getDate());
        newsRepository.save(news);
        return Optional.of(news);
    }

    @Override
    public void deleteById(Long Id) {
        newsRepository.deleteById(Id);
    }


}
