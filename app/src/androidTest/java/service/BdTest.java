package service;

import junit.framework.TestCase;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

public class BdTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();

    }

    public void tearDown() throws Exception {

    }

    public void testDemandeService() throws Exception {
        List<NameValuePair> listPost = new ArrayList<>(7);
        listPost.add(new BasicNameValuePair("categorie","Restaurent"));
        listPost.add(new BasicNameValuePair("nomLieu","Le restaurent du petit pêcheur"));
        listPost.add(new BasicNameValuePair("adresseLieu","90 rue de tolbiac"));
        listPost.add(new BasicNameValuePair("cpLieu","75013"));
        listPost.add(new BasicNameValuePair("villeLieu","Paris"));
        listPost.add(new BasicNameValuePair("noteLieu","3"));
        listPost.add(new BasicNameValuePair("commentaireLieu","Les plats ne sont pas très bon, mais le restaurent est accessible"));
        assertNotNull( new Bd().demandeService("ajoutlieu.php",listPost));
    }

    public void testDemandeService1() throws Exception {
        assertNotNull(new Bd().demandeService("selectallstation.php"));

    }
}