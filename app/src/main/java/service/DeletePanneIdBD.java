package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Classe qui va appeler un webservice pour supprimer une panne de notre BD
 * Created by user on 07/06/2015.
 */
public class DeletePanneIdBD {


    /**
     * Méthode pour supprimer une panne de notre base de données
     * @param paramPost les paramètres qui vont être envoyés à notre webservice pour qu'il puisse supprimer la bonne panne
     * @return retourne vrai si la suppression à bien eu lieu, faux sinon
     */
    public String[] deletePanneId(List<NameValuePair> paramPost){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("deletepanneid.php",paramPost);

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
