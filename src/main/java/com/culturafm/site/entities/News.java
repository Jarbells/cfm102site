package com.culturafm.site.entities;

import jakarta.persistence.*;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tb_news")
public class News {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String subtitle;

    @Column(columnDefinition = "TEXT")
    private String content;

    private String author;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "publication_date")
    private Instant publicationDate;

    public News() {
    }

    public News(Long id, String title, String subtitle, String content, String author, String imageUrl, Instant publicationDate) {
        this.id = id;
        this.title = title;
        this.subtitle = subtitle;
        this.content = content;
        this.author = author;
        this.imageUrl = imageUrl;
        this.publicationDate = publicationDate;
    }

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getSubtitle() { return subtitle; }
    public void setSubtitle(String subtitle) { this.subtitle = subtitle; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }
    public Instant getPublicationDate() { return publicationDate; }
    public void setPublicationDate(Instant publicationDate) { this.publicationDate = publicationDate; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        News news = (News) o;
        return Objects.equals(id, news.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}