import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import praktikum.IngredientType;

@RunWith(Parameterized.class)
public class IngredientTypeParameterizedTest {
    String expectedType;

    public IngredientTypeParameterizedTest(String expectedType) {
        this.expectedType = expectedType;
    }

    @Parameterized.Parameters(name = "Тестовые данные: тип ингридиента {0}")
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeEnum() {
        Assert.assertEquals("Предполагается, что ожидаемый тип существует и равен значению expectedType", expectedType, IngredientType.valueOf(expectedType).name());
    }

}