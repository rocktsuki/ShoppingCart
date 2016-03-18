package tdd.practice.shoppingcart;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class ShoppingCart {

    private List<Book> books;

    private Map<Integer, Double> discountMap;

    public ShoppingCart() {
        this.books = new ArrayList<>();
        this.discountMap = new HashMap<Integer, Double>() {{
            put(1, 1.0);
            put(2, 0.95);
            put(3, 0.9);
            put(4, 0.8);
            put(5, 0.75);
        }};
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
        double maxQty = books.stream().mapToDouble(Book::getQty).max().getAsDouble();
        List<List<Book>> groups = new ArrayList<>();
        List<Book> prepareGroup;
        for (int index = 0; index < maxQty; index++) {
            prepareGroup = new ArrayList<>();
            for (Book book : books) {
                if (book.getQty() > 0) {
                    book.setQty(book.getQty() - 1);
                    prepareGroup.add(book);
                }
            }
            groups.add(prepareGroup);
        }
        for (List<Book> group : groups) {
            total = total + group.size() * 100 * discountMap.get(group.size());
        }
        return total;
    }

}
