package lv.helloit.bootcamp.sweeter;

import java.time.LocalDateTime;
import java.util.Objects;

public class Sweet {
    private Long id;
    private String content;
    private String author;
    private LocalDateTime datePosted;
    private LocalDateTime dateLastUpdate;

    public LocalDateTime getDateLastUpdate() {
        return dateLastUpdate;
    }

    public void setDateLastUpdate(LocalDateTime dateLastUpdate) {
        this.dateLastUpdate = dateLastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public LocalDateTime getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(LocalDateTime datePosted) {
        this.datePosted = datePosted;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Sweet sweet = (Sweet) o;
        return Objects.equals(id, sweet.id) &&
                Objects.equals(content, sweet.content) &&
                Objects.equals(author, sweet.author) &&
                Objects.equals(datePosted, sweet.datePosted) &&
                Objects.equals(dateLastUpdate, sweet.dateLastUpdate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, content, author, datePosted, dateLastUpdate);
    }

    @Override
    public String toString() {
        return "Sweet{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                ", datePosted=" + datePosted +
                ", dateLastUpdate=" + dateLastUpdate +
                '}';
    }

}
