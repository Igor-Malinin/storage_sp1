import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;
import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import java.io.IOException;

public class TestAddDelete {

    @Test
    public void testAddDel() {
        Storage storage = new Storage();
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
        for (int i = 0; i < 8; i++) {
            Assert.assertEquals("monitor", storage.takeItem("monitor").getType());
            //Assert.assertEquals("newDescription", storage.takeItem(i).getDescription());
        }
        // подсчет KPI
            System.out.println(storage.getKPI());

    }
    // Негативный тест
    @Test
    public void expectedExceptions() {
        Storage storage = new Storage();
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
        Storage storage = new Storage();
        storage.addItem("keyboard", "NewKeyboard", "NewKeyboardDescription");
        Assert.assertTrue(storage.itemIsAdded(0));

    }
}
