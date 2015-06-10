package service;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Created by user on 07/06/2015.
 */
public class AjoutLieuBD {

    public boolean ajouterLieu(List<NameValuePair> paramPost){
        Bd.demandeService("addplace.php",paramPost);
        return true;
    }
}
