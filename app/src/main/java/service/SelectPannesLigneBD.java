package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Classe qui va appeler un webservice pour sélectionner toutes pannes sur une ligne
 * Created by user on 02/06/2015.
 */
public class SelectPannesLigneBD {

    /**
     * Méthode qui va appeler un webservice pour séléctionner toutes les pannes selon une ligne
     * @param paramPost on passe en paramètre la ligne pour lequel on souhaite avoir les pannes
     * @return si le webservice à fonctionner on retourne la liste des pannes, sinon faux
     */
    public String[] selectPannesLigne(List<NameValuePair> paramPost){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("selectpannesligne.php",paramPost);

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
