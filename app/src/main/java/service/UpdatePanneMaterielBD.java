package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Classe qui va appeler un webservice pour mettre à jour la date d'une panne
 * Created by user on 07/06/2015.
 */
public class UpdatePanneMaterielBD {


    /**
     * Méthode qui va permettre de mettre à jour la date d'une panne
     * @param paramPost en paramètre on passe la panne sur lequel on souhaite faire la mise à jour le la panne
     * @return on retourne vrai si la mise ç jour à eu lieu sinon faux
     */
    public String[] updatePanneId(List<NameValuePair> paramPost){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("updatepanneid.php",paramPost);

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
