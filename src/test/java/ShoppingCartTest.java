import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import tdd.practice.shoppingcart.Book;
import tdd.practice.shoppingcart.ShoppingCart;

import static org.junit.Assert.assertEquals;


public class ShoppingCartTest {
    private ShoppingCart cart;

    @Before
    public void prepare_shopping_cart() {
        cart = new ShoppingCart();
    }

    @Test
    public void 第一集買了一本_其他都沒買_價格應為100元() {
        // arrange初始化
        cart.add(new Book("HarryPotterVol.1", 1));

        // act目標執行動作
        double expected = 100;
        double actual = cart.calculate();

        // assert(expected, actual)驗證
        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void 第一集買了一本_第二集也買了一本_價格應為190元() {
        cart.add(new Book("HarryPotterVol.1", 1));
        cart.add(new Book("HarryPotterVol.2", 1));

        double expected = 190;
        double actual = cart.calculate();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void 一二三集各買了一本_價格應為270元() {
        cart.add(new Book("HarryPotterVol.1", 1));
        cart.add(new Book("HarryPotterVol.2", 1));
        cart.add(new Book("HarryPotterVol.3", 1));

        double expected = 270;
        double actual = cart.calculate();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void 一二三四集各買了一本_價格應為320元() {
        cart.add(new Book("HarryPotterVol.1", 1));
        cart.add(new Book("HarryPotterVol.2", 1));
        cart.add(new Book("HarryPotterVol.3", 1));
        cart.add(new Book("HarryPotterVol.4", 1));

        double expected = 320;
        double actual = cart.calculate();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void 一次買了整套_一二三四五集各買了一本_價格應為375元() {
        cart.add(new Book("HarryPotterVol.1", 1));
        cart.add(new Book("HarryPotterVol.2", 1));
        cart.add(new Book("HarryPotterVol.3", 1));
        cart.add(new Book("HarryPotterVol.4", 1));
        cart.add(new Book("HarryPotterVol.5", 1));

        double expected = 375;
        double actual = cart.calculate();

        assertEquals(expected, actual, 0.0);
    }

    @Test
    public void 一二集各買了一本_第三集買了兩本_價格應為370元() {
        cart.add(new Book("HarryPotterVol.1", 1));
        cart.add(new Book("HarryPotterVol.2", 1));
        cart.add(new Book("HarryPotterVol.3", 2));

        double expected = 370;
        double actual = cart.calculate();

        assertEquals(expected, actual, 0.0);
    }
}
