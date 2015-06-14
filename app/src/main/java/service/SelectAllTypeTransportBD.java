package service;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Classe qui va appeler un webservice pour sélectionner toutes les types de transport à partir de notre BD
 * Created by user on 31/05/2015.
 */
public class SelectAllTypeTransportBD {

    /**
     * Méthode qui va chercher dans la base de données tous les types de transports existant
     * @return si le webservice à bien fonctionner, les types de transport sont retournés sinon faux
     */
    public String[] selectAllTypeTransport(){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("selectalltypetransport.php");

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
