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
        total = total + books.stream().mapToDouble(Book::getQty).sum() * 100;
        switch (books.size()) {
            case 4:
                total = total * 0.8;
                break;
            case 3:
                total = total * 0.9;
                break;
            case 2:
                total = total * 0.95;
                break;
            case 1:
                total = total * 1;
                break;
            case 0:
                total = 0;
                break;
        }
        return total;
    }
}
