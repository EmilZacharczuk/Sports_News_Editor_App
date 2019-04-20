package com.codeclan.example.SportsNews.projections;

import com.codeclan.example.SportsNews.models.Article;
import com.codeclan.example.SportsNews.models.Journalist;
import com.codeclan.example.SportsNews.repositories.Articles.ArticleRepository;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name= "embedArticle", types= Journalist.class)
public interface JournalistProjection {
    String getFirstName();
    String getSurname();
    String getImage();
    List<Article> getArticles();
}