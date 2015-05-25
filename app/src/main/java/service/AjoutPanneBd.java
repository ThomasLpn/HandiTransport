package service;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by user on 23/05/2015.
 */
public class AjoutPanneBd {

    public boolean ajouterPanne(List<NameValuePair> paramPost){
        Bd.demandeService("ajouterpanne.php",paramPost);
        return true;
    }
}
