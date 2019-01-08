package com.novik.workbooks.domain;

import javax.persistence.*;

@Entity
public class Workbook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String body;
    private String description;
    private String name;
    private String spec;
    private String tag;
    private Long rate_id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User author;





    public Workbook(String body, String description, String name, String spec, String tag, User user) {
        this.name = name;
        this.spec = spec;
        this.description = description;
        this.tag = tag;
        this.body = body;
        this.author = user;
    }
    public Workbook(){}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpec() {
        return spec;
    }

    public void setSpec(String spec) {
        this.spec = spec;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Long getRate_id() {
        return rate_id;
    }

    public void setRate_id(Long rate_id) {
        this.rate_id = rate_id;
    }
    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
       }
}
