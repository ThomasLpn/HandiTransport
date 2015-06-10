package service;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by user on 31/05/2015.
 */
public class SelectAllTypeTransportBD {

    public String[] selectAllTypeTransport(){
        String[] res=null;
        HttpResponse resRequete = Bd.demandeService("selectalltypetransport.php");

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
