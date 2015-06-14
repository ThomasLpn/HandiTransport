package service;

import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class SelectPannesStationBDTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testSelectPannesStation() throws Exception {
        List<NameValuePair> listPost = new ArrayList<>();
        listPost.add(new BasicNameValuePair("typeLigne","Gare de Lyon"));
        assertEquals(true, new SelectPannesStationBD().selectPannesStation(listPost));
    }
}