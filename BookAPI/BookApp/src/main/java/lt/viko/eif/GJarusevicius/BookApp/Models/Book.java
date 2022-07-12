package lt.viko.eif.GJarusevicius.BookApp.Models;


import org.w3c.dom.Text;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Book {
    @Id
    private String id;
    private String title;
    private Long pages;
    @ElementCollection
    private List<String> authorList = new ArrayList<>();
    private String publishedDate;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;

    public Book() {
    }

    public Book(String id, String title, Long pages, List<String> authorList, String publishedDate, String description) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.authorList = authorList;
        this.publishedDate = publishedDate;
        this.description = description;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public Long getPages() {
        return pages;
    }
    public void setPages(Long pages) {
        this.pages = pages;
    }

    public List<String> getAuthorList() {
        return authorList;
    }
    public void setAuthorList(List<String> authorList) {
        this.authorList = authorList;
    }

    public String getPublishedDate() {
        return publishedDate;
    }
    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
