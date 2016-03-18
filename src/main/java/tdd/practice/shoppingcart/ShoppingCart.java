package tdd.practice.shoppingcart;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ShoppingCart {

    private List<Book> books;

    public ShoppingCart() {
        this.books = new ArrayList<Book>();
    }

    public void add(final Book newBook) {
        Stream<Book> filterSameBook = books.stream()
                .filter(x -> x.getName().equals(newBook.getName()));
        if (filterSameBook.count() > 0) {
            books.stream()
                    .filter(x -> x.getName().equals(newBook.getName()))
                    .forEach(x -> x.setQty(x.getQty() + newBook.getQty()));
        } else {
            books.add(newBook);
        }
    }

    public double calculate() {
        double total = 0;
        return total;
    }
}
