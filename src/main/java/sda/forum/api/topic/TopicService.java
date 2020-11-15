package sda.forum.api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sda.forum.api.comment.Comment;

import java.util.List;
import java.util.Optional;

@Service
public class TopicService {

    @Autowired
    private TopicRepository repo;

    public List<Topic> getAll()
    {
        return repo.findAll();
    }

    public Optional<Topic> getById(Long id) {
        return repo.findById(id);
    }

    public Topic create(Topic newTopic) {
        return repo.save(newTopic);
    }

    public Topic update(Topic updatedTopic) {
        return repo.save(updatedTopic);
    }

    public void delete (Long id) {
        repo.deleteById(id);
    }

   // public List<Topic> getAllbyArticleId(Long articleId) {
   //     return repo.findAllByArticleId(articleId);
   // }
}
