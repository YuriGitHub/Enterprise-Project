package io.khasang.enterprise.dao.interfaces;

import io.khasang.enterprise.model.News;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NewsDao {

    List<News> findAllNews();

    List<News> findLatestNews();

    void saveNews(News news);

    void deleteNewsById(int id);

    void deleteAllNews();

}