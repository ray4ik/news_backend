package sda.forum.api.article;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleRepository repo;


    public  List<Article> getAllListArcticle(String sort) {
        return repo.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("title") ? Article::getTitle : Article::getAuthor))
                .collect(Collectors.toList());
    }

    public  List<Article> getAllListArcticle() {
        return repo.findAll();
    }


    public Optional<Article> getById(Long id) {
        return repo.findById(id);
    }

    public Article create(Article newArticle){
        return repo.save(newArticle);
    }



    public void delete (Long id) {
       repo.deleteById(id);
    }

    public void update(Article updatedArticle)  {
        repo.save(updatedArticle);
    }
}
