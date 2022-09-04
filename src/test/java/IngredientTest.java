import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import praktikum.Ingredient;
import praktikum.IngredientType;

public class IngredientTest {

    private IngredientType sauce;
    private String name;
    private float price;
    private Ingredient ingredient;

    @Before
    public void setup() {
        sauce = IngredientType.SAUCE;
        name = "Кетчунез";
        price = 5;
        ingredient = new Ingredient(sauce, name, price);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("Ожидалось, что Цена будет равна значению переменной price", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getPriceNameTest() {
        Assert.assertEquals("Ожидалось, что Имя будет равно значению переменной name", name, ingredient.getName());
    }

    @Test
    public void getPriceTypeTest() {
        Assert.assertEquals("Ожидалось, что Тип Ингредиента будет равно значению переменной sauce", sauce, ingredient.getType());
    }
}