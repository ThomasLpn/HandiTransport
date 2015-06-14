package controlleur;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import metier.PopUp;
import miagesorbonne.Handitransport.R;
import service.DeletePanneIdBD;
import service.SelectPannesStationBD;
import service.UpdatePanneMaterielBD;

/**
 * classe qui permet de gérer les événements sur l'activité PanneDetails
 * Created by user on 06/06/2015.
 */
public class ManagerPanneDetails {

    Activity activite;
    SelectPannesStationBD selectPannesStationBD;
    String[] infosPanne;
    UpdatePanneMaterielBD updatePanneMaterielBD;
    DeletePanneIdBD deletePanneIdBD;

    /**
     * Constucteur de ManagerPanneDetails
     * @param activite
     */
    public ManagerPanneDetails(Activity activite){
        this.activite=activite;
        selectPannesStationBD=new SelectPannesStationBD();
        updatePanneMaterielBD=new UpdatePanneMaterielBD();
        deletePanneIdBD= new DeletePanneIdBD();
    }

    public void intialiserActivite(String nomStation, String materielEnPanne){
        List<NameValuePair> listePost = new ArrayList<>();
        listePost.add(new BasicNameValuePair("nomStation",nomStation));
        infosPanne=selectPannesStationBD.selectPannesStation(listePost);

        TextView panne = (TextView) activite.findViewById(R.id.descriptionAppareil);
        panne.setText(panne.getText()+" "+materielEnPanne); //infosPanne[0]+" "+infosPanne[1]

        TextView dateIncident = (TextView) activite.findViewById(R.id.dateIncident);
        dateIncident.setText(dateIncident.getText()+" "+infosPanne[2]);

        TextView dateMAJ = (TextView) activite.findViewById(R.id.maj);
        dateMAJ.setText(dateMAJ.getText()+" "+infosPanne[3]);

        TextView detail = (TextView) activite.findViewById(R.id.detailsPanne);
        detail.setText(detail.getText()+" "+infosPanne[4]);
    }

    public void toujoursEnPanne(){
        Button boutonActualiser = (Button) activite.findViewById(R.id.prblmNonRegle);
        boutonActualiser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp popUp=new PopUp();
                popUp.creationPopupConfirmation(activite,"Confirmation","Souhaitez vous confirmer l\'incident?");

                Intent intent = activite.getIntent();
                String materielEnPanne = intent.getStringExtra("Panne");

                List<NameValuePair> listePost = new ArrayList<>();
                listePost.add(new BasicNameValuePair("nomStation",(String) activite.getTitle()));
                listePost.add(new BasicNameValuePair("description",materielEnPanne));
                updatePanneMaterielBD.updatePanneId(listePost);
            }
        });

    }

    public void panneReglee(){
        Button boutonRegle = (Button) activite.findViewById(R.id.prblmRegle);
        boutonRegle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopUp popUp=new PopUp();
                popUp.creationPopupConfirmation(activite,"Confirmation","Souhaitez vous supprimer l\'incident?");

                Intent intent = activite.getIntent();
                String materielEnPanne = intent.getStringExtra("Panne");

                List<NameValuePair> listePost = new ArrayList<>();
                listePost.add(new BasicNameValuePair("nomStation",(String) activite.getTitle()));
                listePost.add(new BasicNameValuePair("description",materielEnPanne));
                deletePanneIdBD.deletePanneId(listePost);
            }
        });
    }


}
