package service;

import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class AjoutPanneBDTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testAjouterPanne() throws Exception {
        List<NameValuePair> listPost = new ArrayList<>(7);
        listPost.add(new BasicNameValuePair("station","Gare de Lyon"));
        listPost.add(new BasicNameValuePair("ascenseur","0"));
        listPost.add(new BasicNameValuePair("escalator","1"));
        listPost.add(new BasicNameValuePair("detail","Test d'ajout d'une panne à notre base de données"));
        assertEquals(true, new AjoutPanneBD().ajouterPanne(listPost));
    }
}