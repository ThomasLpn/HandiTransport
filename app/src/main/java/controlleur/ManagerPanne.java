package controlleur;

import android.app.Activity;
import miagesorbonne.Handitransport.R;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by user on 23/05/2015.
 */
public class ManagerPanne {
    private Activity activite;


    public ManagerPanne(Activity activite) {
        this.activite=activite;
    }

    public void validationPanne(Button boutonValider){
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //liste de paramètre post que nous allons envoyer
                List<NameValuePair> listPost = new ArrayList<>(7);




                //On récupère les infos rentrées par l'utilisateur

                TextView detail = (TextView)activite.findViewById(R.id.detailsPannes);
                listPost.add(new BasicNameValuePair("station","1"));
                listPost.add(new BasicNameValuePair("escalator","1"));
                listPost.add(new BasicNameValuePair("ascenseur","0"));
                listPost.add(new BasicNameValuePair("date",new SimpleDateFormat("yyyyMMdd").format(new Date())));
                listPost.add(new BasicNameValuePair("detail",detail.getText().toString()));

                detail.setText("");

                //On lie la liste des paramètre à l'instance HttpPost
                HttpPost httpost = new HttpPost("http://10.0.2.2/handitransport/webservices/ajouterpanne.php");
                try {
                    httpost.setEntity(new UrlEncodedFormEntity(listPost, "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }

                //On envoie la requête et on récupère la réponse
                HttpClient httpclient = new DefaultHttpClient();
                try {

                    HttpResponse response = httpclient.execute(httpost);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
