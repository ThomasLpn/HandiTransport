package service;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

import propriete.Propriete;

/**
 * Created by user on 05/05/2015.
 */
public class Bd {



    public static HttpResponse demandeService(String nomService, List<NameValuePair> paramPost){

        HttpPost httpost = new HttpPost(Propriete.getAdresseService()+nomService);
        try {
            httpost.setEntity(new UrlEncodedFormEntity(paramPost, "UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //On envoie la requête et on récupère la réponse
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response=null;
        try {
            response = httpclient.execute(httpost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    public static HttpResponse demandeService(String nomService){
        HttpPost httpost = new HttpPost(Propriete.getAdresseService()+nomService);

        //On envoie la requête et on récupère la réponse
        HttpClient httpclient = new DefaultHttpClient();
        HttpResponse response=null;
        try {
            response = httpclient.execute(httpost);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}
