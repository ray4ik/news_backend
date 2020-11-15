package sda.forum.api.topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("")
    public List<Topic> getAll(
            @RequestParam (required = false) String sort,
            @RequestParam (required = false) Long articleId) {

        if (sort == null) {
            sort = "name";
        }

        if (articleId == null ){
            return topicService.getAll(sort);
        } else {
            return topicService.getAllbyArticleId(articleId);
        }
    }

    @GetMapping("/{id}")
    public Topic getById(@PathVariable Long id)
    {
        return topicService.getById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @PostMapping("")
    public Topic create(@RequestBody Topic newTopic){
        topicService.create(newTopic);
        return newTopic;
    }

    @PutMapping("")
    public Topic update(@RequestBody Topic updatedTopic)
    {
        topicService.update(updatedTopic);
        return updatedTopic;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        topicService.delete(id);
    }

}
