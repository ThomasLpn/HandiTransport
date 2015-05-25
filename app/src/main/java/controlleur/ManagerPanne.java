package controlleur;

import android.app.Activity;

import metier.PopUp;
import miagesorbonne.Handitransport.R;
import service.AjoutPanneBd;
import service.SelectAllStationBD;
import service.SelectEscalatorStationBD;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by user on 23/05/2015.
 */
public class ManagerPanne {
    private Activity activite;
    private PopUp popup;
    private AjoutPanneBd serviceAjoutPanne;
    private SelectAllStationBD serivceSelectAllStation;
    private SelectEscalatorStationBD serviceSelectEscalator;

    public ManagerPanne(Activity activite) {
        this.activite=activite;
        this.popup = new PopUp();
        serviceAjoutPanne=new AjoutPanneBd();
        serivceSelectAllStation=new SelectAllStationBD();
        serviceSelectEscalator=new SelectEscalatorStationBD();
    }

    public void initilisationRechercheStation(){
        String [] STATIONS = serivceSelectAllStation.selectAllStation();
        ArrayAdapter<String> adapterStation = new ArrayAdapter<>(activite, android.R.layout.simple_dropdown_item_1line,STATIONS);
        AutoCompleteTextView text = (AutoCompleteTextView) activite.findViewById(R.id.rechercheStation);
        text.setAdapter(adapterStation);
        text.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AutoCompleteTextView text = (AutoCompleteTextView) activite.findViewById(R.id.rechercheStation);
                initialisationEscaAs(text.getText().toString());
            }
        });
    }

    public void initialisationEscaAs(String station){
        List<NameValuePair> listPost = new ArrayList<>(1);
        listPost.add(new BasicNameValuePair("nomLigne",station));
        String[] ESCASC = serviceSelectEscalator.selectAscenseurStation(listPost);
        popup.creationPopup(activite,"Résultat requête",ESCASC[0]+" "+ESCASC.length);
        ArrayAdapter<String> adapterEscasc = new ArrayAdapter<>(activite,android.R.layout.simple_spinner_item,ESCASC);
        adapterEscasc.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Spinner spinner = (Spinner) activite.findViewById(R.id.listeAscenseurEscalator);
        spinner.setAdapter(adapterEscasc);
    }

    public void validationPanne(Button boutonValider){
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //liste de paramètre post que nous allons envoyer
                List<NameValuePair> listPost = new ArrayList<>(7);

                //On récupère les infos rentrées par l'utilisateur
                listPost.add(new BasicNameValuePair("station","1"));

                RadioButton ascensseur = (RadioButton) activite.findViewById(R.id.ascenseur);
                RadioGroup rg = (RadioGroup) activite.findViewById(R.id.choixTypePanne);
                int selectionne = rg.getCheckedRadioButtonId();
                String as="0";
                String es="0";
                if(selectionne == ascensseur.getId()){
                    as="1";
                }else{
                    es="1";
                }
                listPost.add(new BasicNameValuePair("ascenseur",as));
                listPost.add(new BasicNameValuePair("escalator",es));
                TextView detail = (TextView)activite.findViewById(R.id.detailsPannes);
                listPost.add(new BasicNameValuePair("detail",detail.getText().toString()));

                detail.setText("");

                if (serviceAjoutPanne.ajouterPanne(listPost)){
                    popup.creationPopup(activite,"Résultat requête","Incident signalé");
                }
            }
        });
    }
}
