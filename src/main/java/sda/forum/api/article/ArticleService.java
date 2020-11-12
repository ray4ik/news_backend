package sda.forum.api.article;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;


import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArticleService {

    @Autowired
    private ArticleNewsRepository repo;
    private static Long idCounter = 1L;


    public  List<ArticleNews> getAllListArcticle(String sort) {
        return (List<ArticleNews>) repo.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("title") ? ArticleNews::getTitle : ArticleNews::getAuthor))
                .collect(Collectors.toList());
    }


    public Optional<ArticleNews> getById(Long id) {
        return repo.findById(id);
    }

    public ArticleNews create(ArticleNews newArticle){
        newArticle.setId(idCounter);
        idCounter++;
        return repo.save(newArticle);
    }



    public void delete (Long id) {
       repo.deleteById(id);
    }

    public void update(ArticleNews updatedArticle) throws NotFoundException {
        ArticleNews old = repo.findById(updatedArticle.getId())
                .orElseThrow(() -> new NotFoundException(HttpStatus.NOT_FOUND.toString()));
        old.setBody(updatedArticle.getBody());
        old.setTitle(updatedArticle.getTitle());
        old.setAuthor(updatedArticle.getAuthor());
        repo.save(updatedArticle);
    }
}
