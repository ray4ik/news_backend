package sda.forum.api.article;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArticleNewsRepository extends JpaRepository<ArticleNews, Long> {
}
