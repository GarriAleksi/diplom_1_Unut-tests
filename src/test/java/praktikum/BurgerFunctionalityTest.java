package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BurgerFunctionalityTest {

    private Burger burger;

    @Mock
    private Bun bun;

    @Mock
    private Ingredient ingredient1, ingredient2, ingredient3;

    @Before
    public void setUp() {
        // Инициализация объекта burger перед каждым тестом
        burger = new Burger();
    }

    @Test
    public void setBunTest() {
        // Тестирование установки булочки для бургера
        burger.setBuns(bun);

        // Проверка, что булочка установлена корректно
        assertEquals(bun.getName(), burger.bun.getName());
    }

    @Test
    public void addIngredientTest() {
        // Добавление ингредиента в бургер
        burger.addIngredient(ingredient1);

        // Проверка, что ингредиент добавлен
        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void removeIngredientTest() {
        // Добавление нескольких ингредиентов в бургер
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);
        assertEquals(3, burger.ingredients.size());

        // Удаление ингредиента и проверка уменьшения размера
        burger.removeIngredient(2);
        assertEquals(2, burger.ingredients.size());
    }

    @Test
    public void moveIngredientTest() {
        // Добавление нескольких ингредиентов в бургер
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        // Перемещение ингредиента и проверка правильности позиций
        burger.moveIngredient(1, 2);
        assertEquals(ingredient2, burger.ingredients.get(2));
        assertEquals(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void getPriceTest() {
        // Установка булочки и добавление ингредиентов
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Мокирование цен булочки и ингредиентов
        when(bun.getPrice()).thenReturn(20F);
        when(ingredient1.getPrice()).thenReturn(10F);
        when(ingredient2.getPrice()).thenReturn(2F);

        // Вычисление ожидаемой цены: (цена булочки * 2) + цена ингредиентов
        float expectedPrice = (20F * 2) + 10F + 2F;

        // Проверка вычисленной цены
        assertEquals(expectedPrice, burger.getPrice(), 0);
    }

    @Test
    public void getReceiptTest() {
        // Установка булочки и добавление ингредиентов
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        // Мокирование названий, цен и типов ингредиентов
        when(bun.getName()).thenReturn("burger");
        when(ingredient1.getName()).thenReturn("ingredient1");
        when(ingredient2.getName()).thenReturn("ingredient2");
        when(bun.getPrice()).thenReturn(20F);
        when(ingredient1.getPrice()).thenReturn(10F);
        when(ingredient2.getPrice()).thenReturn(2F);
        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);

        // Ожидаемый формат чека
        String expectedReceipt = "(==== burger ====)\r\n" +
                "= sauce ingredient1 =\r\n" +
                "= filling ingredient2 =\r\n" +
                "(==== burger ====)\r\n" +
                "\r\n" +
                "Price: 52,000000\r\n";

        // Проверка, что формат чека корректен
        assertEquals(expectedReceipt, burger.getReceipt());
    }
}
