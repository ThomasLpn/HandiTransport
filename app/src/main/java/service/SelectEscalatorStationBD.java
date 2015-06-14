package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Classe qui va appeler un webservice pour sélectionner toutes les escalators d'une station
 * Created by user on 25/05/2015.
 */
public class SelectEscalatorStationBD {

    /**
     * Méthode qui va sélectionner dans la BD tous les escalator d'une station
     * @param paramPost en paramètre on passe la station pour lequel on veut sélectionner les escalators
     * @return si le webservices à bien fonciotnné on retourne la liste des escalator de la station, sinon faux
     */
    public String[] selectEscalatorStation(List<NameValuePair> paramPost){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("selectescalatorstation.php",paramPost);

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
