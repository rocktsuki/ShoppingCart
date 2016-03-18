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
        double sumQty = books.stream().mapToDouble(Book::getQty).sum();
        double total = sumQty * 100 * getDiscount(books.size());
        return total;
    }

    private double getDiscount(int bookQty) {
        double discount = 0;
        switch (bookQty) {
            case 5:
                discount = 0.75;
                break;
            case 4:
                discount = 0.8;
                break;
            case 3:
                discount = 0.9;
                break;
            case 2:
                discount = 0.95;
                break;
            case 1:
                discount = 1;
                break;
        }
        return discount;
    }
}
