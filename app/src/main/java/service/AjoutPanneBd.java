package service;

import org.apache.http.NameValuePair;

import java.util.List;

/**
 * Classe qui va appeler un webservice pour ajouter une panne à notre BD
 * Created by user on 23/05/2015.
 */
public class AjoutPanneBD {

    /**
     * Méthode qui va appeler le webservice
     * @param paramPost la liste des paramètres qui vont être passé par la méthode POST
     * @return vrai si l'ajout à bien eu lieu sinon faux
     */
    public boolean ajouterPanne(List<NameValuePair> paramPost){
        //le nom du webservice
        Bd.demandeService("ajouterpanne.php",paramPost);
        return true;
    }
}
