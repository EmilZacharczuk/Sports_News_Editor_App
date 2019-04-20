package com.codeclan.example.SportsNews.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="articles")
public class Article {

    @Column(name="headline")
    private String headline;

    @Column(name="summary")
    private String summary;

    @Column(name="full_story")
    private String fullStory;

    @Column(name="date_created")
    private Date dateCreated;

    @Column(name="image")
    private String image;

    @Column(name="read_count")
    private int readCount;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "journalist_id", nullable = false)
    private Journalist journalist;

    public Article(String headline, String summary, String fullStory, Date dateCreated, String image, int readCount, Category category, Journalist journalist){
        this.headline = headline;
        this.summary = summary;
        this.fullStory = fullStory;
        this.dateCreated = dateCreated;
        this.image = image;
        this.readCount = readCount;
        this.category = category;
        this.journalist = journalist;

    }

    public Article(){};


    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getFullStory() {
        return fullStory;
    }

    public void setFullStory(String fullStory) {
        this.fullStory = fullStory;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getReadCount() {
        return readCount;
    }

    public void setReadCount(int readCount) {
        this.readCount = readCount;
    }

    public Long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Journalist getJournalist() {
        return journalist;
    }

    public void setJournalist(Journalist journalist) {
        this.journalist = journalist;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
