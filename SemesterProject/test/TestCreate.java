/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import Presentation.createservlet;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lasse
 */
public class TestCreate {

    @Test
    public void TestCreate() {
        createservlet cs = new createservlet();
        assertEquals(cs.createCheckup("hejsa", 3, 4), true);
    }

}

