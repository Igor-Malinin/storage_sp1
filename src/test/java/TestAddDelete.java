import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestAddDelete {
    @Test
    public void testAdd() {
        Storage storage = new Storage();
        for (int i = 0; i < 10; i++) {
            storage.addItem("newMonitor № " + i, "newDescription № " + i);
            Assert.assertEquals("newMonitor № " + i, storage.getItemFS(i).getBrandN());
            Assert.assertEquals("newDescription № " + i, storage.getItemFS(i).getDescription());
        }
        for (int i = 0; i < 10; i++)
            //Assert.assertEquals("newMonitor № " + i, storage.takeItem(i).getBrandN());
            Assert.assertEquals("newDescription № " + i, storage.takeItem(i).getDescription());
    }
}
