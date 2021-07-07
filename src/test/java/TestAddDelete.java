import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestAddDelete {
    @Test
    public void testAdd() {
        Storage storage = new Storage();
        storage.addItem("newMonitor", "newDescription");
        Assert.assertEquals("newMonitor", storage.getItemFS(0).getBrandN());
        Assert.assertEquals("newDescription", storage.getItemFS(0).getDescription());

        //Assert.assertEquals("newMonitor", storage.takeItem(0).getBrandN());
        Assert.assertEquals("newDescription", storage.takeItem(0).getDescription());
    }
}
