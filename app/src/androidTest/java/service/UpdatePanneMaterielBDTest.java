package service;

import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class UpdatePanneMaterielBDTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testUpdatePanneId() throws Exception {
        List<NameValuePair> listPost = new ArrayList<>();
        listPost.add(new BasicNameValuePair("nomStation","Gare de Lyon"));
        listPost.add(new BasicNameValuePair("description","Ascenseur numero un"));
        assertEquals(true, new UpdatePanneMaterielBD().updatePanneId(listPost));
    }
}