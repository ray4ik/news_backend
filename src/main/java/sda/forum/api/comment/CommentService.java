package sda.forum.api.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.forum.api.article.ArticleNewsRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repoCo;

    public List<Comment> getAll(){
        return repoCo.findAll();
    }

    public Optional<Comment> getById(Long id)
    {
        return repoCo.findById(id);
    }

    public Comment create(Comment newComment) {
        return repoCo.save(newComment);
    }

    public Comment update(Comment updatedComment) {
        return repoCo.save(updatedComment);
    }

    public void delete (Long id) {
        repoCo.deleteById(id);
    }
}
