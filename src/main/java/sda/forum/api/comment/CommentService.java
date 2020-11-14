package sda.forum.api.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommentService {
    @Autowired
    private CommentRepository repoCo;

    public List<Comment> getAll(){
        return repoCo.findAll();
    }

    public List<Comment> getAll(String sort) {
        return repoCo.findAll().stream()
                .sorted(Comparator.comparing(sort.equals("title") ? Comment::getTitle : Comment::getAuthor))
                .collect(Collectors.toList());
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

    public List<Comment> getAllbyArticleId(Long articleId) {
        return repoCo.findAllByArticleId(articleId);
    }
}
