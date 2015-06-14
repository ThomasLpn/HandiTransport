package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Classe qui va appeler un webservice pour sélectionner toutes les lignes du même type (Metro, tram, ...)
 * Created by user on 31/05/2015.
 */
public class SelectLigneTypeBD {
    /**
     * Méthode qui va appeler un webservice pour sélectionner toute les lignes selon leur type
     * @param paramPost on passe en paramètre POST le type de transport
     * @return si le webservice à fonctionner, on retourne une liste de station sinon faux
     */
    public String[] selectLigneType(List<NameValuePair> paramPost){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("selectlignetype.php",paramPost);

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
