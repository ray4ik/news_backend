package article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleNewsController {

    @Autowired
    private ArticleService service;

    @GetMapping("")
    public  List<ArticleNews> getAllListArcticle() {
        return service.getAllListArcticle();
    }

    @GetMapping("/{id}")
    public ArticleNews getById(@PathVariable Integer id) {
            return service.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public ArticleNews create(@RequestBody ArticleNews newArticle){
        service.create(newArticle);
        return newArticle;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id){
        service.delete(id);
    }

    @PutMapping("/{id}")
    public ArticleNews update(@RequestBody ArticleNews updatedArticle){
        service.update(updatedArticle);
        return updatedArticle;
    }
}
