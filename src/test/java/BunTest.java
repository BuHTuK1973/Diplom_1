import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {

    @Test
    public void getNameTest() {
        String expectedName = "�������";
        float bunPrice = 9;
        Bun bun = new Bun(expectedName, bunPrice);
        Assert.assertEquals("��������� ��������, ������� �� ����� ���������� expectedName", expectedName, bun.getName());
    }

    @Test
    public void getPriceTest() {
        String bunName = "�������";
        float expectedPrice = 9;
        Bun bun = new Bun(bunName, expectedPrice);
        Assert.assertEquals("��������� ��������, ������� �� ����� ���������� expectedPrice", expectedPrice, bun.getPrice(), 0);
    }
}