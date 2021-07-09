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
        for (int i = 0; i < 9; i++) {
            storage.addItem("monitor", "newMonitor", "newDescription");
            Assert.assertEquals("newMonitor", storage.getItemFS(i).getBrandN());
            Assert.assertEquals("newDescription", storage.getItemFS(i).getDescription());
        }
        // забираем несколько предметов по типу (самые ближние)
        for (int i = 0; i < 4; i++) {
            Assert.assertEquals("monitor", storage.takeItem("monitor").getType());
            //Assert.assertEquals("newDescription", storage.takeItem(i).getDescription());
        }
        //expectedException.expect(IllegalArgumentException.class);
        //expectedException.expectMessage("No item with such type");

        // Негативный тест
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            storage.takeItem("mouse");
        });
        String expectedMessage = "No item with such type";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));

        // Позитивный тест (добавлен ли новый предмет)
        storage.addItem("keyboard", "NewKeyboard", "NewKeyboardDescription");
        Assert.assertTrue(storage.itemIsAdded(0));
    }

}
