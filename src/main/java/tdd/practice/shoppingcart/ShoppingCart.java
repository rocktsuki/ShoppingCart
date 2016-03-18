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
        double sumQty = books.stream().mapToDouble(Book::getQty).sum();
        List<List<Book>> groups = new ArrayList<>();
        List<Book> prepareGroup;
        for (int index = 0; index < sumQty; index++) {
            prepareGroup = new ArrayList<Book>();
            for (Book book : books) {
                if (book.getQty() > 0) {
                    book.setQty(book.getQty() - 1);
                    prepareGroup.add(book);
                }
            }
            if (prepareGroup.size() > 0) {
                groups.add(prepareGroup);
            } else {
                break;
            }
        }
        for (List<Book> group : groups) {
            total = total + group.size() * 100 * getDiscount(group.size());
        }

        return total;
    }

    private double getDiscount(int bookQty) {
        double discount = 1;
        switch (bookQty) {
            case 2:
                discount = 0.95;
                break;
            case 3:
                discount = 0.9;
                break;
            case 4:
                discount = 0.8;
                break;
            case 5:
                discount = 0.75;
                break;
        }
        return discount;
    }
}
