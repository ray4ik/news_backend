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
import java.util.stream.Collectors;

@Service
public class ArticleService {

    public static Integer idCounter = 3;
    private static List<ArticleNews> listArticle = new ArrayList<>();

    static
    {
        listArticle.add(new ArticleNews(1, "5 best bakery in Stockholm", "Petrus, Lillabrorsbageri, Gunnarskonditori, Brod och salt, Fabrique",  "ray4ik"));
        listArticle.add(new ArticleNews(2, "5 best  Places in Stockholm", "Vasa, Haga, Gamla Stan, Djurgarden, Hammarby",  "ray4ik"));
    }

    public  List<ArticleNews> getAllListArcticle() {
        return listArticle;
    }


    public Optional<ArticleNews> getById(Integer id) {
        return listArticle.stream()
                .filter(a -> a.getId().equals(id))
                .findFirst();
    }

    public ArticleNews create(ArticleNews newArticle){
        add(newArticle);
        return newArticle;
    }

    static private boolean add(ArticleNews newArcitle) {
        newArcitle.setId(idCounter);
        idCounter++;
        return listArticle.add(newArcitle);
    }

    public void delete (Integer id) {
        listArticle = listArticle.stream()
                .filter(a -> !a.getId().equals(id))
                .collect((Collectors.toList()));
    }

    public void update(ArticleNews updatedArticle) {
        for (ArticleNews a : listArticle){
            if (a.getId().equals(updatedArticle.getId())){
                a.setTitle(updatedArticle.getTitle());
                a.setBody(updatedArticle.getBody());
                a.setAuthor(updatedArticle.getAuthor());
            }
        }
    }
}
