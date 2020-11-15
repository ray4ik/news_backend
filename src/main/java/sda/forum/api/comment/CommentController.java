package sda.forum.api.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService commentService;

    @GetMapping("")
    public List<Comment> getAll(
            @RequestParam (required = false) String sort,
            @RequestParam (required = false) Long articleId) {

        if (sort == null) {
            sort = "authorName";
        }

        if (articleId == null ){
            return commentService.getAll(sort);
        } else {
            return commentService.getAllbyArticleId(articleId);
        }

    }

    @GetMapping("/{id}")
    public Comment getById(@PathVariable Long id) {
        return commentService.getById(id)
                .orElseThrow(() ->  new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Comment create(@RequestBody Comment newComment){
            commentService.create(newComment);
            return newComment;
    }

    @PutMapping("")
    public Comment update(@RequestBody Comment updatedComment)
    {
        commentService.update(updatedComment);
        return updatedComment;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        commentService.delete(id);
    }

}
