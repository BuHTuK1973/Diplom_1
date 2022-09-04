import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {

    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;
    @Mock
    Ingredient ingredientSecond;

    @Test
    public void setBunsTest(){
        Burger burger = new Burger();
        burger.setBuns(bun);
        Assert.assertEquals("Поле не соотвествует установленному значению", bun, burger.bun);
    }

    @Test
    public void addIngredientTest() {
        Burger burger = new Burger();
        int coreSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int actualSize = burger.ingredients.size();
        Assert.assertEquals("Размер списка не соответсвует ожидаемому результату", coreSize + 1, actualSize);
    }

    @Test
    public void removeIngredientTest() {
        Burger burger = new Burger();
        int coreSize = burger.ingredients.size();
        burger.addIngredient(ingredient);
        int actualSize = burger.ingredients.size();
        burger.removeIngredient(actualSize - 1);
        int finalSize = burger.ingredients.size();
        Assert.assertEquals("Размер списка не соответсвует ожидаемому результату", coreSize, finalSize);
    }

    @Test
    public void moveIngredientTest() {
        Burger burger = new Burger();
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        int actualSize = burger.ingredients.size();
        burger.moveIngredient(actualSize - 1, 0);
        Assert.assertEquals("Размер списка не соответсвует ожидаемому результату", ingredientSecond, burger.ingredients.get(0));
    }

    @Test
    public void getPriceTest() {
        float mockPrice = 2;
        float mockPriceWithSecondIngredient = 5;
        float actualPrice;
        float expectedPrice = 11;
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        Mockito.when(bun.getPrice()).thenReturn(mockPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(mockPrice);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(mockPriceWithSecondIngredient);
        actualPrice = burger.getPrice();
        Assert.assertEquals("Ожидаемая цена не соответсвует фактическому", expectedPrice, actualPrice, 0);
    }

    @Test
    public void getReceiptTest() {
        float mockPrice = 2;
        float mockPrice2 = 5;
        String mockBunName = "Булочка c маком";
        String mockIngredientName = "Кетчуп";
        String mockIngredientSecondName = "Майонез";
        IngredientType sauce = IngredientType.SAUCE;
        String expectedReceiptString = "(==== Булочка c маком ====)\r\n" +
                "= sauce Кетчуп =\r\n" +
                "= sauce Майонез =\r\n" +
                "(==== Булочка c маком ====)\r\n" +
                "\r\n" +
                "Price: 11,000000\r\n";
        Burger burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredientSecond);
        Mockito.when(bun.getPrice()).thenReturn(mockPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(mockPrice);
        Mockito.when(ingredientSecond.getPrice()).thenReturn(mockPrice2);
        Mockito.when(bun.getName()).thenReturn(mockBunName);
        Mockito.when(ingredient.getName()).thenReturn(mockIngredientName);
        Mockito.when(ingredientSecond.getName()).thenReturn(mockIngredientSecondName);
        Mockito.when(ingredient.getType()).thenReturn(sauce);
        Mockito.when(ingredientSecond.getType()).thenReturn(sauce);
        String actualReceiptString = burger.getReceipt();
        Assert.assertEquals("Ожидаемый рецепт не соответсвует фактическому", expectedReceiptString, actualReceiptString);
    }

}