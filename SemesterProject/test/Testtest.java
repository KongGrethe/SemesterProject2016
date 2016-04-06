import DataAccess.Datamappers.BuildingMapper;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author Joachim E. Christensen
 */
public class Testtest {
    
    @Test
    public void addBuilding() {
        BuildingMapper bm = new BuildingMapper();
        assertTrue(bm.createBuilding("test", "testvej", 0, 0, 0, 0, 0));
    }
    
    
}
