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

}
