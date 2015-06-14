package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Classe qui va appeler un webservice pour sélectionner toutes les ascenseur d'une station
 * Created by user on 25/05/2015.
 */
public class SelectAscenseurStationBD {

    /**
     * Méthode qui va retourner tout les ascenseurs d'une station
     * @param paramPost en paramètre post on passe la station pour lequel on veut avoir les ascenseurs
     * @return si le webservice à bien fonctionné retourne la liste des ascenseurs sinon faux
     */
    public String[] selectAscenseurStation(List<NameValuePair> paramPost){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("selectascenseurstation.php",paramPost);

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
