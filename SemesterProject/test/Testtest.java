import DataAccess.Datamappers.BuildingMapper;
import Service.DataException;
import Service.Entity.Building;
import Service.Entity.User;
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
        assertEquals(blist.get(blist.size()-1).getbName(),("test"));
    }
//    @Test
//    public void addUser() throws ClassNotFoundException, DataException {
//        EntityFacade ef = new EntityFacade();
//        List<User> ulist = ef.selectUsers();
//        assertTrue((lastUserInsert = ef.createUser(0, "Bob", "The Builder", "12345", "a@b.com", "customer", 1)) >= 0);
//        assertEquals(ulist.size()+1, ef.selectUsers().size());
//        System.out.println("last user insert: "+lastUserInsert);
//    }
//    @Test
//    public void deleteUser() throws ClassNotFoundException, DataException {
//        EntityFacade ef = new EntityFacade();
//        List<User> ulist = ef.selectUsers();
//        listsize = ulist.size();
//        assertTrue(ef.deleteUser(lastUserInsert));
//        assertEquals(ef.selectUsers().size(), listsize);
//        
//    }

    @Test
    public void deleteBuilding() throws DataException{
        
        EntityFacade ef = new EntityFacade();
        List<Building> blist = ef.selectBuildings();
        assertFalse("list not empty", blist.isEmpty());
        Building building = blist.get(blist.size()-1);
        boolean res1 = ef.deleteBuilding(building.getbID());
        assertTrue("building NOT deleted", res1);
        List<Building> blist2 = ef.selectBuildings();
        Building building2;
        if(blist2.isEmpty()) building2 = null;
        else building2 = blist2.get(blist2.size()-1);
        System.out.println("building 1: " + building);
        System.out.println("building 2: " + building2);
        System.out.println("blist: " + blist);
        System.out.println("blist2: " + blist2);
        assertNotEquals("buildings are the same", building, building2);
        try {
            boolean res = ef.deleteBuilding(building.getbID());
            if(!res) 
            fail("building deleted: "+(res?"Success" : "Failed"));
        } catch (Exception e) {
            
        }
    }
    
    
}
