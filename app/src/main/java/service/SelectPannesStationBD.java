package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Classe qui va appeler un webservice pour sélectionner toutes les pannes sur une station
 * Created by user on 06/06/2015.
 */
public class SelectPannesStationBD {

    /**
     * Méthode qui va appeler un webservices pour selectionner toutes les pannes sur une station
     * @param paramPost on passe en paramètre la station pour lequel on souhaite avoir la liste des pannes
     * @return si le webservice à fonctionner alors on retourne la liste des pannes sur la station sinon on retourne faux
     */
    public String[] selectPannesStation(List<NameValuePair> paramPost){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("selectpannesstation.php",paramPost);

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resRequete.getEntity().getContent()));
            String tmp = reader.readLine();
            tmp = tmp.substring(4,tmp.length()-2);
            tmp = tmp.replace("\"","");
            res = tmp.split(":");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return res;
    }






}
