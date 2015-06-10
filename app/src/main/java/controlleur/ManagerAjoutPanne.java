package controlleur;

import android.app.Activity;
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

import metier.PopUp;
import miagesorbonne.Handitransport.R;
import service.AjoutPanneBD;
import service.SelectAllStationBD;
import service.SelectAscenseurStationBD;
import service.SelectEscalatorStationBD;

/**
 * classe qui permet de gérer les événements sur l'activité AjoutPanne
 * Created by user on 23/05/2015.
 */
public class ManagerAjoutPanne {
    private Activity activite;
    private PopUp popup;
    private AjoutPanneBD serviceAjoutPanne;
    private SelectAllStationBD serivceSelectAllStation;
    private SelectEscalatorStationBD serviceSelectEscalator;
    private SelectAscenseurStationBD serviceSelectAscenseur;

    /**
     * Constructeur de ManagerAjoutPanne
     * @param activite l'activité correspond à celle de la classe AjoutPanne
     */
    public ManagerAjoutPanne(Activity activite) {
        this.activite=activite;
        this.popup = new PopUp();
        serviceAjoutPanne=new AjoutPanneBD();
        serivceSelectAllStation=new SelectAllStationBD();
        serviceSelectEscalator=new SelectEscalatorStationBD();
        serviceSelectAscenseur=new SelectAscenseurStationBD();
    }

    /**
     * Méthode qui permet de proposer une liste déroulante pour la sélection de la station
     * Lorque l'on sélectionne la station on met à jout la liste des escalaltor/ ascensseur
     */
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

    /**
     * Méthode pour mettre à jour la liste des ascensseurs et des escalators selon la station
     * @param station on passe en paramètre la station pour lequel on chercher les ascenseurs et les escalators
     */
    public void initialisationEscaAs(String station){
        List<NameValuePair> listPost = new ArrayList<>(1);
        RadioGroup radioGroup = (RadioGroup) activite.findViewById(R.id.choixTypePanne);
        listPost.add(new BasicNameValuePair("nomLigne",station));

        String[] ESCASC;

        if (activite.findViewById(R.id.ascenseur).getId()==radioGroup.getCheckedRadioButtonId()){
            ESCASC = serviceSelectAscenseur.selectAscenseurStation(listPost);
        } else {
            ESCASC = serviceSelectEscalator.selectEscalatorStation(listPost);
        }

        ArrayAdapter<String> adapterEscasc = new ArrayAdapter<>(activite,android.R.layout.simple_spinner_item,ESCASC);
        adapterEscasc.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Spinner spinner = (Spinner) activite.findViewById(R.id.listeAscenseurEscalator);
        spinner.setAdapter(adapterEscasc);
    }

    /**
     * Méthode qui permet de créer un listener sur nos radios boutons.
     * A chaque modification de nos radios bouton la liste des ascenseurs / escalator est mise à jour
     */
    public void modificationGroupeRadioBouton(){
        RadioGroup radioGroup = (RadioGroup) activite.findViewById(R.id.choixTypePanne);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                AutoCompleteTextView text = (AutoCompleteTextView) activite.findViewById(R.id.rechercheStation);
                initialisationEscaAs(text.getText().toString());
            }
        });
    }

    /**
     * Méthode qui va récupérer toutes les informations de l'écran et envoyer une requêtes POST avec ces infos pour insérer une panne dans notre BD
     * @param boutonValider
     */
    public void validationPanne(Button boutonValider){
        boutonValider.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //liste de paramètre post que nous allons envoyer
                List<NameValuePair> listPost = new ArrayList<>(7);

                Spinner spinner = (Spinner) activite.findViewById(R.id.listeAscenseurEscalator);
                listPost.add(new BasicNameValuePair("materiel",(String)spinner.getSelectedItem()));

                //On récupère les infos rentrées par l'utilisateur
                AutoCompleteTextView text = (AutoCompleteTextView) activite.findViewById(R.id.rechercheStation);
                listPost.add(new BasicNameValuePair("station",text.getText().toString()));
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
