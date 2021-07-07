import com.example.storage_sp.domain.Item;
import com.example.storage_sp.domain.Storage;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class TestAddDelete {
    @Test
    public void testAdd() {
        Storage storage = new Storage();
        int place = 3;
        storage.addItem(place,"newMonitor", "newDescription");
        Assert.assertEquals("newMonitor", storage.getItemFS(place).getBrandN());
        Assert.assertEquals("newDescription", storage.getItemFS(place).getDescription());

        Assert.assertEquals("newMonitor", storage.takeItem(place).getBrandN());
        //Assert.assertEquals("newDescription", storage.takeItem(0).getDescription());
    }
}
