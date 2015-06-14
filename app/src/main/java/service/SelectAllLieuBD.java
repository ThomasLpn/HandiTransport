package service;

import org.apache.http.HttpResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import metier.Endroit;

/**
 * Created by user on 14/06/2015.
 */
public class SelectAllLieuBD {


    public List<Endroit> selectAllLieu(){
        String[] res=null;
        List<Endroit> listeEndroit = new ArrayList<>();
        HttpResponse resRequete = Bd.demandeService("selectalllieu.php");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(resRequete.getEntity().getContent()));
            String tmp = reader.readLine();
            tmp = tmp.substring(4,tmp.length()-2);
            tmp = tmp.replace("\"","");
            res = tmp.split(":");

            for (int i = 0; i<res.length; i=i+9){
                listeEndroit.add(new Endroit(Integer.parseInt(res[i].trim()), res[i+1], res[i+2], res[i+3], res[i+4], res[i+5], Integer.parseInt(res[i+6].trim()), Integer.parseInt(res[i+7].trim()), res[i+8]));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listeEndroit;
    }
}
