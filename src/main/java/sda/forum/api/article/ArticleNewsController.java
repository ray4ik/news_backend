package sda.forum.api.article;

import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleNewsController {

    @Autowired
    private ArticleService service;

    @GetMapping("")
    public  List<ArticleNews> getAllListArcticle(@RequestParam String sort) {
        return service.getAllListArcticle(sort);
    }

    @GetMapping("/{id}")
    public ArticleNews getById(@PathVariable Long id) {
            return service.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ArticleNews create(@RequestBody ArticleNews newArticle){
        service.create(newArticle);
        return newArticle;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("")
    public ArticleNews update(@RequestBody ArticleNews updatedArticle)
    {
        service.update(updatedArticle);
        return updatedArticle;
    }
}
