package ru.vsu.cs.dpu;

public class Book {
    private String title;
    private String author;
    private int pages;
    private int yearPublishedIn;

    public Book() {
        this.title = "title";
        this.author = "author";
        this.pages = 0;
        this.yearPublishedIn = 1900;
    }
    public Book(String title, String author, int pages, int yearPublishedIn) {
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.yearPublishedIn = yearPublishedIn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getYearPublishedIn() {
        return yearPublishedIn;
    }

    public void setYearPublishedIn(int yearPublishedIn) {
        this.yearPublishedIn = yearPublishedIn;
    }
}
