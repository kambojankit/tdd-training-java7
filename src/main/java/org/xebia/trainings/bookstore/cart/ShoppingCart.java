package org.xebia.trainings.bookstore.cart;

import org.xebia.trainings.bookstore.exception.EmptyShoppingCartException;
import org.xebia.trainings.bookstore.model.Book;
import sun.invoke.empty.Empty;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {

    int totalPrice;
    private List<Book> itemsInCart = new ArrayList<Book>();
	public void add(Book book) {
        itemsInCart.add(book);
	}

	public int checkout() {
        if(itemsInCart.size()==0){
            throw new EmptyShoppingCartException("You can't checkout an empty cart!!");
        }
        for(Book book : itemsInCart){
            totalPrice += book.getPrice();
        }
		return totalPrice;
	}

    public int size(){
        return itemsInCart.size();
    }

    public List<Book> items(){
        return itemsInCart;
    }

}
