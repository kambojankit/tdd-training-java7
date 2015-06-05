package org.xebia.trainings.bookstore;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.xebia.trainings.bookstore.cart.ShoppingCart;
import org.xebia.trainings.bookstore.exception.EmptyShoppingCartException;
import org.xebia.trainings.bookstore.model.Book;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertEquals;

/**
 * Created by ankit on 05/06/15.
 */
public class ShoppingCartTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    public void cartSizeZeroWhenCartIdEmpty(){
        ShoppingCart cart = new ShoppingCart();
        assertEquals(0, cart.size());
    }

    @Test
    public void cartSizeShouldBeOneWhenOneBookAddedToCart(){
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Book("Effective Java", 40));
        assertEquals(1, cart.size());
    }

    @Test
    public void cartShouldHaveThreeBooksWhenWeAddThreeBookToEmptyCart(){
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Book("Effective Java", 40));
        cart.add(new Book("Clean Code", 60));
        cart.add(new Book("Head First java", 30));

        assertEquals(3, cart.size());
        assertEquals(new Book("Effective Java",40), cart.items().get(0));
        assertEquals(new Book("Clean Code",60), cart.items().get(1));
        assertEquals(new Book("Head First java",30), cart.items().get(2));
    }

    @Test
    public void cartAmountBeSameAsWhenSingleBookAddedToCart(){
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Book("Effective Java", 40));

        assertEquals(40, cart.checkout());
    }

    @Test
    public void cartShouldHaveCorrectTotalAtCheckout(){
        ShoppingCart cart = new ShoppingCart();
        cart.add(new Book("Effective Java", 40));
        cart.add(new Book("Clean Code", 60));
        cart.add(new Book("Head First java", 30));

        assertEquals(130, cart.checkout());
    }

    @Test()
    public void throwExceptionWhenCheckoutIsCalledOnEmptyCart() throws Exception{
        ShoppingCart cart = new ShoppingCart();
        expectedException.expect(EmptyShoppingCartException.class);
        expectedException.expectMessage("You can't checkout an empty cart!!");
        cart.checkout();
    }
}
