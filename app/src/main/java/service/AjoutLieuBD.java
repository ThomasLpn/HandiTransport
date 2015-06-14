package service;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Classe qui va appeler un webservice pour ajouter un lieu à notre BD
 * Created by user on 07/06/2015.
 */
public class AjoutLieuBD {

    /**
     * Méthode qui va appeler le webservice
     * @param paramPost la liste des paramètres qui vont être passées par la méthode POST
     * @return vrai si l'ajout à la base de données est réussi
     */
    public boolean ajouterLieu(List<NameValuePair> paramPost){
        //le premier paramètre correspond au nom de notre weservice
        Bd.demandeService("addplace.php",paramPost);
        return true;
    }
}
