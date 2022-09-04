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

    @Parameterized.Parameters(name = "�������� ������: ��� ����������� {0}")
    public static Object[][] getIngredientTypeData() {
        return new Object[][]{
                {"SAUCE"},
                {"FILLING"}
        };
    }

    @Test
    public void checkIngredientTypeEnum() {
        Assert.assertEquals("��������������, ��� ��������� ��� ���������� � ����� �������� expectedType", expectedType, IngredientType.valueOf(expectedType).name());
    }

}