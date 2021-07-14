import com.example.storage_sp.applications.StorStatus;
import com.example.storage_sp.applications.StorageLogic;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class Tests {
    private int boxes = 8;
    // тесты с хешмапой
    @Test
    public void testHash(){
        StorageLogic storageLogic = new StorageLogic(boxes);
        StorStatus storStatus = new StorStatus();
        for (int i = 0; i < 20; i++) {
            storageLogic.addItem("keyboard", "newKeyboard", "newDescription");
        }
        for (int i = 0; i < 2; i++) {
            storageLogic.addItem("monitor", "newMonitor", "newDescription");
        }
        storageLogic.takeItem(5);
        storStatus.listOfOccupiedPlacesInfo();
        Assert.assertTrue(storStatus.getEmptyPlace(34));

        //int j = 0;
        //for (int i = 0, k = storageLogic.getShelfs(); i < boxes; i++, k+=storageLogic.getShelfs())
        //for (; j < k; j++)
        //for (int i = 0; i < boxes; i++)

        //System.out.println("place" + storageLogic.getShelfs() + "is empty");
        /*HashMap<Integer, Item> getMap = storStatus.getStorageStatus();
        for (Map.Entry<Integer, Item> entry: getMap.entrySet()) {
            System.out.println(entry.getKey() +"; Value: " + entry.getValue());
        }*/
    }
    // подсчет KPI
    @Test
    public void testCalcKPI() {
        StorageLogic storageLogic = new StorageLogic(boxes);
        double kpi = 0;
        double currentCase;
        double idealCase = 0;
        for (int i = 0; i < 20; i++) {
            storageLogic.addItem("keyboard", "newKeyboard", "newDescription");
        }
        for (int i = 0; i < 20; i++) {
            storageLogic.addItem("monitor", "newMonitor", "newDescription");
        }

        int amount = 8;
        int temp = storageLogic.getShelfs();
        for (int j = 0, k = 0; j < amount; j++) {
            if (j % temp != 0)
                idealCase += k;
            else {
                k++;
                idealCase += k;
            }
        }
        for (int i = 0; i < amount; i++) {
            storageLogic.takeItem("monitor");
        }
        currentCase = storageLogic.getIterations();
        kpi = idealCase/currentCase;
        System.out.println("iC = " + idealCase + "; cC = " + currentCase + "; KPI = " + kpi);

    }

    @Test
    public void testAddDel() {
        StorageLogic storageLogic = new StorageLogic(boxes);
        // добавляем несколько предметов по типу.
        // место, на которое кладется предмет устанавливается автоматически (ближайшее свободное)
        for (int i = 0; i < 20; i++) {
            storageLogic.addItem("keyboard", "newKeyboard", "newDescription");
            Assert.assertEquals("newKeyboard", storageLogic.getItemFS(i).getBrandN());
            Assert.assertEquals("newDescription", storageLogic.getItemFS(i).getDescription());
        }
        for (int i = 0; i < 20; i++) {
            storageLogic.addItem("monitor", "newMonitor", "newDescription");
            Assert.assertEquals("newMonitor", storageLogic.getItemFS(i+20).getBrandN());
            Assert.assertEquals("newDescription", storageLogic.getItemFS(i+20).getDescription());
        }
        // забираем несколько предметов по типу (самые ближние)

        Assert.assertEquals("monitor", storageLogic.takeItem("monitor").getType());
        //Assert.assertEquals("newDescription", storage.takeItem(i).getDescription());
    }
    // Негативный тест
    @Test
    public void expectedExceptions() {
        StorageLogic storageLogic = new StorageLogic(boxes);
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            storageLogic.takeItem("mouse");
        });
        String expectedMessage = "No item with such type";
        String actualMessage = exception.getMessage();
        Assert.assertTrue(actualMessage.contains(expectedMessage));
    }
    // Позитивный тест (добавлен ли новый предмет)
    @Test
    public void isPositive() {
        StorageLogic storageLogic = new StorageLogic(boxes);
        storageLogic.addItem("keyboard", "NewKeyboard", "NewKeyboardDescription");
        Assert.assertTrue(storageLogic.itemIsAdded(0));

    }
}
