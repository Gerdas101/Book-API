package lt.viko.eif.GJarusevicius.BookApp.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.List;

@Entity
public class UserBook extends Book{
    private int pagesRead;
    private String notes;
    private boolean isFinished;
    @JsonIgnore
    @ManyToOne(
            cascade = CascadeType.ALL
    )
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public UserBook() {
    }

    public UserBook(String id, String title, Long pages, List<String> authorList, String publishedDate, String description, int pagesRead, String notes, boolean isFinished, User user) {
        super(id, title, pages, authorList, publishedDate, description);
        this.pagesRead = pagesRead;
        this.notes = notes;
        this.isFinished = isFinished;
        this.user = user;
    }

    public int getPagesRead() {
        return pagesRead;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
