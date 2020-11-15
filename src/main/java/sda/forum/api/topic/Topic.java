package sda.forum.api.topic;

import sda.forum.api.article.Article;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "topic")
public class Topic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    // Each topic can have many articles and each article can belong to many topics
    @ManyToMany(mappedBy = "topics")
    private List<Article> articles;

    public Topic () {
    }

    public Topic(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
