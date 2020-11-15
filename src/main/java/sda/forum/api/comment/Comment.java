package sda.forum.api.comment;

import sda.forum.api.article.Article;

import javax.persistence.*;


@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "body")
    private String body;

    @Column(name = "authorName")
    private String authorName;

    //many Comments to a singe article
    @ManyToOne
    private Article article;

    public Comment() {}

    public Comment(String title, String body, String authorName, Article article) {
        this.body = body;
        this.authorName = authorName;
        this.article = article;
    }

    public Long getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public void setAuthorName(String author) {
        this.authorName = author;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
