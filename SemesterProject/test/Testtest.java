
import Service.DataException;
import Service.Entity.Building;
import Service.EntityFacade;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Christian
 */
public class Testtest {

    int listsize;
    int lastUserInsert = -1;

    @Test
    public void addBuilding() throws DataException {
        EntityFacade ef = new EntityFacade();
        assertTrue(ef.createBuilding("test", "testvej", 0, 0, 0, 0, 1));
        List<Building> blist = ef.selectBuildings();
        assertEquals(blist.get(blist.size() - 1).getbName(), ("test"));
    }

    @Test
    public void deleteBuilding() throws DataException {

        EntityFacade ef = new EntityFacade();

        //Create buildinglist and verifying it is not empty. 
        List<Building> blist = ef.selectBuildings();
        assertFalse("list not empty", blist.isEmpty());

        //Get last building from list.
        Building building = blist.get(blist.size() - 1);

        //delete last building and verify.
        boolean res1 = ef.deleteBuilding(building.getbID());
        assertTrue("building NOT deleted", res1);

        //Fetch last building.
        List<Building> blist2 = ef.selectBuildings();
        Building building2;
        if (blist2.isEmpty()) {
            building2 = null;
        } else {
            building2 = blist2.get(blist2.size() - 1);
        }
        

        //Verify building can not be deleted again.
        assertNotEquals("buildings are the same", building, building2);
        System.out.println(blist);
        System.out.println(blist2);
        //res should return false, because builing does not exist.
        boolean res = ef.deleteBuilding(building2.getbID());
        assertFalse("Building is NOT deleted, something went wrong..", res);

    }

}

