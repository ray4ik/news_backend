package sda.forum.api.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sda.forum.api.topic.Topic;

import java.util.List;


@Repository
public interface ArticleRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByTopics_id(Long topicId);
}
