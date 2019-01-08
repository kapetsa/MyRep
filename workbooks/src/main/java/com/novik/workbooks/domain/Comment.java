package com.novik.workbooks.domain;


import javax.persistence.*;

@Entity
@Table(name = "comments")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String text;
    private String author;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "book_id")
    private Workbook book;

    public Comment(String text, User user, Long bookId) {
        this.text = text;
        this.author = user.getUsername();
        this.book = book;
    }

    public Comment(){};

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Workbook getBook() {
        return book;
    }

    public void setBook(Workbook book) {
        this.book = book;
    }
}
