package com.exp.persistence.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(schema = "public", name = "Book")
public class Book extends BaseEntity {

    private String name;

    @ManyToOne
    @JoinColumn(name = "book_category_id")
    BookCategory category;

    public Book(){}

    public Book(String name, BookCategory category) {
        this.name = name;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public BookCategory getCategory() {
        return category;
    }

    @JsonIgnore
    public void setCategory(BookCategory category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(name, book.name) &&
                Objects.equals(category, book.category);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, category);
    }
}
