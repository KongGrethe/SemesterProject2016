import DataAccess.Datamappers.BuildingMapper;
import Service.DataException;
import Service.EntityFacade;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Joachim E. Christensen
 */
public class Testtest {
    
    /*
    @Test
    public void addBuilding() {
        BuildingMapper bm = new BuildingMapper();
        assertTrue(bm.createBuilding("test", "testvej", 0, 0, 0, 0, 0));
    }
    @Test
    public void addUser() throws ClassNotFoundException, DataException {
        EntityFacade ef = new EntityFacade();
        assertTrue(ef.createUser(0, "Bob", "The Builder", "12345", "a@b.com", "customer", 1));
    }*/
    @Test
    public void deleteUser() throws ClassNotFoundException, DataException {
        EntityFacade ef = new EntityFacade();
        assertTrue(ef.deleteUser(4));
    }
    
}
