import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestDeletion {
    @Test
    public void testDelete() {
        Storage storage = new Storage();
        storage.addItem("newMonitor", "newDescription");

        //Assert.assertEquals("newMonitor", storage.takeItem(0).getBrandN());
        Assert.assertEquals("newDescription", storage.takeItem(0).getDescription());
    }
}
