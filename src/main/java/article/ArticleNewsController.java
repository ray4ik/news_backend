package article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ArticleNewsController {
    @Autowired
    private static List<ArticleNews> listArticle = new ArrayList<>();

    public ArticleNewsController(){
        listArticle.add(new ArticleNews(1, "5 best bakery in Stockholm", "Petrus, Lillabrorsbageri, Gunnarskonditori, Brod och salt, Fabrique",  "ray4ik"));
    }

    @GetMapping("/articles")
    public  List<ArticleNews> getAllListArcticle() {
        return listArticle;
    }

    @GetMapping("/articles/{id}")
    public ArticleNews getById(@PathVariable Integer id) {
        for (ArticleNews article :  listArticle) {
            if (article.getId().equals(id) ){
                return article;
            }
        }
        return null; // new ResponseStatusException(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/articles")
    public ArticleNews create(@RequestBody ArticleNews article){
        listArticle.add(article);
        return  article;
    }
}
