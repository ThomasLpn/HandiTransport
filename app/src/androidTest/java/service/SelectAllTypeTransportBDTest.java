package service;

import junit.framework.TestCase;

public class SelectAllTypeTransportBDTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testSelectAllTypeTransport() throws Exception {
        assertEquals(true, new SelectAllStationBD().selectAllStation());
    }
}