package article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArticleService {

    private static List<ArticleNews> listArticle = new ArrayList<>();

    static
    {
        listArticle.add(new ArticleNews(1, "5 best bakery in Stockholm", "Petrus, Lillabrorsbageri, Gunnarskonditori, Brod och salt, Fabrique",  "ray4ik"));
        listArticle.add(new ArticleNews(3, "5 best  Places in Stockholm", "Vasa, Haga, Gamla Stan, Djurgarden, Hammarby",  "ray4ik"));
    }

    public  List<ArticleNews> getAllListArcticle() {
        return listArticle;
    }


    public Optional<ArticleNews> getById(Integer id) {
        return listArticle.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }


    @PostMapping("/articles")
    public ArticleNews create(@RequestBody ArticleNews article){
        listArticle.add(article);
        return  article;
    }
}
