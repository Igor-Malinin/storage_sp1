import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.KPI;
import com.example.storage_sp.domain.Storage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class TestAddDelete {
    private int boxes = 8;
    @Test
    public void testCalcKPI() {
        Storage storage = new Storage(boxes);
        double kpi = 0;
        double currentCase;
        double idealCase = 0;
        //Storage storage = new Storage();
        for (int i = 0; i < 20; i++) {
            storage.addItem("keyboard", "newKeyboard", "newDescription");
        }
        for (int i = 0; i < 20; i++) {
            storage.addItem("monitor", "newMonitor", "newDescription");
        }
        int amount = 17;
        int temp = 0;
        for (int i = 0; i < amount; i++) {
            if (i <= boxes)
                idealCase = amount;
            else {
                idealCase = boxes;
                temp = amount % boxes;
                if (temp == 0) {
                for(int q = 1, k = 2; q < amount/boxes; q++,k++)
                    for(int j = 0; j < (amount - boxes); j++)
                            idealCase += k;
                }
                else {
                    for(int q = 0, k = 2; q < amount/boxes; q++,k++)
                        for(int j = 0; j < (amount - boxes); j++)
                            idealCase += k;
                }
            }

            storage.takeItem("monitor");
        }
        currentCase = storage.getIterations();
        idealCase = 27;
        kpi = idealCase/currentCase;
        System.out.println("iC = " + idealCase + "; cC = " + currentCase + "; KPI = " + kpi);

    }
    // подсчет KPI
    @Test
    public void testAddDel() {
        Storage storage = new Storage(boxes);
        // добавляем несколько предметов по типу.
        // место, на которое кладется предмет устанавливается автоматически (ближайшее свободное)
        for (int i = 0; i < 20; i++) {
            storage.addItem("keyboard", "newKeyboard", "newDescription");
            Assert.assertEquals("newKeyboard", storage.getItemFS(i).getBrandN());
            Assert.assertEquals("newDescription", storage.getItemFS(i).getDescription());
        }
        for (int i = 0; i < 20; i++) {
            storage.addItem("monitor", "newMonitor", "newDescription");
            Assert.assertEquals("newMonitor", storage.getItemFS(i+20).getBrandN());
            Assert.assertEquals("newDescription", storage.getItemFS(i+20).getDescription());
        }
        // забираем несколько предметов по типу (самые ближние)

        Assert.assertEquals("monitor", storage.takeItem("monitor").getType());
        //Assert.assertEquals("newDescription", storage.takeItem(i).getDescription());
    }
    // Негативный тест
    @Test
    public void expectedExceptions() {
        Storage storage = new Storage(boxes);
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            storage.takeItem("mouse");
        });
        String expectedMessage = "No item with such type";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
    // Позитивный тест (добавлен ли новый предмет)
    @Test
    public void isPositive() {
        Storage storage = new Storage(boxes);
        storage.addItem("keyboard", "NewKeyboard", "NewKeyboardDescription");
        Assert.assertTrue(storage.itemIsAdded(0));

    }
}
