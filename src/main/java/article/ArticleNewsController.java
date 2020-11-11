package article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleNewsController {

    private ArticleService service = new ArticleService();

    @GetMapping("/articles")
    public  List<ArticleNews> getAllListArcticle() {
        return service.getAllListArcticle();
    }

    @GetMapping("/articles/{id}")
    public ArticleNews getById(@PathVariable Integer id) {
            return service.getById(id)
                    .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/articles")
    public ArticleNews create(@RequestBody ArticleNews article){
        service.create(article);
        return article;
    }
}
