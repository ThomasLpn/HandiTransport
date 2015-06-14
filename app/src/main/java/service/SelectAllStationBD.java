package service;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe qui va appeler un webservice pour sélectionner toutes les stations de notre BD
 * Created by user on 25/05/2015.
 */
public class SelectAllStationBD {

    /**
     * Méthode qui va appeler le webservice pour sélectionner toutes les stations
     * @return si la requête à bien fonctionner cela retourne la liste des stations sinon cela retourne faux
     */
    public String[] selectAllStation(){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("allstation.php");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resRequete.getEntity().getContent()));
            String tmp = reader.readLine();
            tmp = tmp.substring(5,tmp.length()-2);
            tmp = tmp.replace("\"","");
            res = tmp.split(":");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }
}
