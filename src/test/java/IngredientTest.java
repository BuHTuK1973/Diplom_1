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
        name = "��������";
        price = 5;
        ingredient = new Ingredient(sauce, name, price);
    }

    @Test
    public void getPriceTest() {
        Assert.assertEquals("���������, ��� ���� ����� ����� �������� ���������� price", price, ingredient.getPrice(), 0);
    }

    @Test
    public void getPriceNameTest() {
        Assert.assertEquals("���������, ��� ��� ����� ����� �������� ���������� name", name, ingredient.getName());
    }

    @Test
    public void getPriceTypeTest() {
        Assert.assertEquals("���������, ��� ��� ����������� ����� ����� �������� ���������� sauce", sauce, ingredient.getType());
    }
}