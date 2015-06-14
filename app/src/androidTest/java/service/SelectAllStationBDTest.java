package service;

import junit.framework.TestCase;

public class SelectAllStationBDTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testSelectAllStation() throws Exception {
        assertEquals(true, new SelectAllStationBD());
    }
}