package com.exp.persistence.entities;

import javax.persistence.*;

import java.util.List;
import java.util.Objects;


@Entity
@Table(schema = "public", name = "book_category")
public class BookCategory extends BaseEntity {

    private String name;
    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    List<Book> books;

    public BookCategory(){}
    public BookCategory(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BookCategory that = (BookCategory) o;
        return Objects.equals(name, that.name) &&
                Objects.equals(books, that.books);
    }

    @Override
    public int hashCode() {

        return Objects.hash(super.hashCode(), name, books);
    }
}
