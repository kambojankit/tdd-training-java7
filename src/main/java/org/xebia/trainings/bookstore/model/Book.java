package org.xebia.trainings.bookstore.model;

public class Book {

    private String title;
    private int price;

    public Book(String title, int price) {
		// TODO Auto-generated constructor stub
        this.title = title;
        this.price = price;
	}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;

        Book book = (Book) o;

        if (title != null ? !title.equals(book.title) : book.title != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        return title != null ? title.hashCode() : 0;
    }


    public int getPrice() {
        return price;
    }
}
