package praktikum;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Random;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class BunModelTest {
    private static final Random RANDOM = new Random();
    private final String name;
    private final float price;

    public BunModelTest(String name, float price) {
        this.name = name;
        this.price = price;
    }

    @Parameterized.Parameters(name = "{index}: Bun(name={0}, price={1})")
    public static Object[][] getParameters() {
        return new Object[][]{
                {RandomStringUtils.randomAlphabetic(10), getRandomPrice()},
                {RandomStringUtils.randomAlphabetic(10), 700.0F},  // Тест с высокой ценой
                {RandomStringUtils.randomAlphabetic(10), 0.0F},    // Тест с нулевой ценой
                {RandomStringUtils.randomAlphabetic(10), -50.0F}   // Тест с отрицательной ценой
        };
    }

    private static float getRandomPrice() {
        return 1.0F + (99.0F * RANDOM.nextFloat());  // Генерация цены в диапазоне от 1.0 до 100.0
    }

    @Test
    public void getNameTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Имя булки не совпадает", name, bun.getName());
    }

    @Test
    public void getPriceTest() {
        Bun bun = new Bun(name, price);
        assertEquals("Цена булки не совпадает", price, bun.getPrice(), 0);
    }
}
