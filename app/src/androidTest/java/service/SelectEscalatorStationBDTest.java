package service;

import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SelectEscalatorStationBDTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testSelectEscalatorStation() throws Exception {
        List<NameValuePair> listPost = new ArrayList<>();
        listPost.add(new BasicNameValuePair("nomStation","Gare de Lyon"));
        assertEquals(true, new SelectEscalatorStationBD().selectEscalatorStation(listPost));
    }
}