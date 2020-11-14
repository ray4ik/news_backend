package sda.forum.api.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @GetMapping("")
    public  List<Article> getAllListArcticle(@RequestParam (required = false) String sort) {
        if (sort == null) {
            sort = "title";
        }
        return service.getAllListArcticle(sort);
    }

    @GetMapping("/{id}")
    public Article getById(@PathVariable Long id) {
            return service.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Article create(@RequestBody Article newArticle){
        service.create(newArticle);
        return newArticle;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }

    @PutMapping("")
    public Article update(@RequestBody Article updatedArticle)
    {
        service.update(updatedArticle);
        return updatedArticle;
    }
}
