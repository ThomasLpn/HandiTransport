package controlleur;

import android.app.Activity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.Spinner;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import metier.PopUp;
import miagesorbonne.Handitransport.R;
import service.AjoutLieuBD;

/**
 * Classe qui permet de gérer les événement sur l'activité AjoutLieu
 * Created by user on 07/06/2015.
 */
public class ManagerAjoutLieu {
    private Activity activite;
    private AjoutLieuBD ajoutLieuBD;
    private PopUp popUp;

    /**
     * Constructeur de ManagerAjoutLieu
     * @param activite l'activité correspond à celle de la classe AjoutLieu
     */
    public ManagerAjoutLieu(Activity activite){
        this.activite=activite;
        this.ajoutLieuBD = new AjoutLieuBD();
        this.popUp = new PopUp();
    }

    /**
     * Méthode qui permet de créer un Listenner sur le bouton de création de lieu
     */
    public void listennerCreationLieu(){
        //On récupère le bouton
        Button buttonCreation = (Button) activite.findViewById(R.id.validerAjoutLieu);
        buttonCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            //La méthode qui va être déclanger lors du clic sur le bouton
            public void onClick(View v) {
                //la liste des variables post qui von être passé à notre script PHP
                List<NameValuePair> listPost = new ArrayList<>();

                //on récupère les valeurs de tout les champs
                Spinner spinner = (Spinner) activite.findViewById(R.id.listeCategorie);
                EditText lieu = (EditText) activite.findViewById(R.id.nomLieu);
                EditText adresse = (EditText) activite.findViewById(R.id.adresseLieu);
                EditText cp = (EditText) activite.findViewById(R.id.cpLieu);
                EditText ville = (EditText) activite.findViewById(R.id.villeLieu);
                RatingBar note = (RatingBar) activite.findViewById(R.id.noteLieu);
                EditText commentaire = (EditText) activite.findViewById(R.id.commentaireLieu);

                //On ajoutes les valeurs des champs à notre liste de variable POST
                listPost.add(new BasicNameValuePair("categorie",(String)spinner.getSelectedItem()));
                listPost.add(new BasicNameValuePair("nomLieu",lieu.getText().toString()));
                listPost.add(new BasicNameValuePair("adresseLieu",adresse.getText().toString()));
                listPost.add(new BasicNameValuePair("cpLieu",cp.getText().toString()));
                listPost.add(new BasicNameValuePair("villeLieu",ville.getText().toString()));
                listPost.add(new BasicNameValuePair("noteLieu",note.getRating()+""));
                listPost.add(new BasicNameValuePair("commentaireLieu",commentaire.getText().toString()));

                //On appelle la méthode qui va envoyer une requête à la base de données pour ajouter un lieu
                ajoutLieuBD.ajouterLieu(listPost);
                //On créer un popup qui informe l'utilisateur que le lieu à bien été ajouté
                popUp.creationPopup(activite, "Résultat", "Lieu bien ajouté");

            }
        });

    }

    /**
     * Méthode qui va initialiser la liste de catégories des lieux
     */
    public void intitialiserCategorie(){
        String[] CATEGORIE = {"Bar","Restaurant","WC","Cinéma","Tabac"};
        ArrayAdapter<String> categorieLieu = new ArrayAdapter<>(activite,android.R.layout.simple_spinner_item,CATEGORIE);
        categorieLieu.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Spinner spinner = (Spinner) activite.findViewById(R.id.listeCategorie);
        spinner.setAdapter(categorieLieu);
    }
}
