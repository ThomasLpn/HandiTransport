package controlleur;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;

import java.util.ArrayList;
import java.util.List;

import metier.PopUp;
import miagesorbonne.Handitransport.PanneDetails;
import miagesorbonne.Handitransport.R;
import service.SelectAllTypeTransportBD;
import service.SelectLigneTypeBD;
import service.SelectPannesLigneBD;

/**
 * classe qui permet de gérer les événements sur l'activité Pannne
 * Created by user on 31/05/2015.
 */
public class ManagerPanne {
    Activity activite;
    String [] typeTransport;
    String [] nomLigne;
    String [] listePannes;
    List<Button> listeBoutonType;
    List<Button> listeBoutonLigne;
    PopUp popUp;
    SelectLigneTypeBD selectLigneTypeBD;
    SelectPannesLigneBD selectPannesLigneBD;
    ArrayAdapter<String> adapter;

    /**
     * Constructeur de ManagerPanne
     * @param activite Activité qui correspond à l'activité Pannes
     */
    public ManagerPanne(Activity activite){
        this.activite = activite;
        listeBoutonType = new ArrayList<>();
        listeBoutonLigne = new ArrayList<>();
        popUp = new PopUp();
        selectLigneTypeBD = new SelectLigneTypeBD();
        selectPannesLigneBD = new SelectPannesLigneBD();
    }

    /**
     * Mathode qui va permettre de créer dynamiquement un bouton par type de transport
     */
    public void initialiserBoutonRecherche(){
        LinearLayout linearLayout = (LinearLayout) activite.findViewById(R.id.typeTransport2);
        SelectAllTypeTransportBD selectAllTypeTransportBD = new SelectAllTypeTransportBD();
        typeTransport = selectAllTypeTransportBD.selectAllTypeTransport();

        listeBoutonType.add(new Button(activite));
        linearLayout.addView(listeBoutonType.get(0));
        listeBoutonType.get(0).setText(typeTransport[0]);
        initialiserListenerTypeTransport(0);

        for (int i=1; i<typeTransport.length;i++){
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.END_OF,listeBoutonType.get(i-1).getId());
            listeBoutonType.add(new Button(activite));
            listeBoutonType.get(i).setText(typeTransport[i]);
            listeBoutonType.get(i).setLayoutParams(params);
            linearLayout.addView(listeBoutonType.get(i));
            initialiserListenerTypeTransport(i);
        }

    }

    /**
     * Méthode qui permet de créer un listenner sur tout les boutons de type de transport. L'action ce déclange lors d'un clic
     * @param i le paramètre que l'on passe correspond à l'indice du bouton dans le tableau de bouton
     */
    private void initialiserListenerTypeTransport(final int i){
        listeBoutonType.get(i).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intitialiserBoutonLigne((String) listeBoutonType.get(i).getText());
            }
        });
    }

    /**
     * Méthode qui permet de mettre un listenner sur les boutons qui correspondent au ligne (M1, RER A,...)
     * L'action se déclange lors d'un clic sur le bouton.
     * @param i le rpamètre que l'on passe correspond à l'indice du bouton ligne dans le tableau de bouton de ligne
     */
    private void initialiserListenerLigne(final int i) {
        listeBoutonLigne.get(i).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ListView listView = (ListView) activite.findViewById(R.id.listPannes);
                List<NameValuePair> listePost = new ArrayList<>();
                listePost.add(new BasicNameValuePair("idLigne",(String) listeBoutonLigne.get(i).getText()));
                listePannes=selectPannesLigneBD.selectPannesLigne(listePost);
                adapter = new ArrayAdapter<String>(activite,android.R.layout.simple_list_item_1, android.R.id.text1,listePannes);
                listView.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });
        initialiserListenerPanne();
    }

    /**
     * Cette activite permet de créer un listenner sur les éléments de la liste des pannes
     * Cette activité va lancer une nouvelle activité qui va afficher les détails de la panne
     */
    private void initialiserListenerPanne(){
        final ListView listView = (ListView) activite.findViewById(R.id.listPannes);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String[] tabInfosPanne = listView.getItemAtPosition(position).toString().split("   ");
                Intent intent = new Intent(activite, PanneDetails.class);
                intent.putExtra("Station",tabInfosPanne[0]);
                intent.putExtra("Panne", tabInfosPanne[1]);
                activite.startActivity(intent);
            }
        });
    }


    /**
     * Méthode qui permet d'ajouter dynamiquement des boutons pour chaque ligne qui correpsond au type de ligne sélectionné
     * @param type les ligne doivent correspondre à ce type de transport
     */
    private void intitialiserBoutonLigne(String type){
        LinearLayout linearLayout = (LinearLayout) activite.findViewById(R.id.numeroLigne2);
        linearLayout.removeAllViewsInLayout();
        List<NameValuePair> listePost = new ArrayList<>();
        listePost.add(new BasicNameValuePair("typeLigne",type));
        nomLigne = selectLigneTypeBD.selectLigneType(listePost); // A MODIFIER ABSOLUMENT!!!!!!

        listeBoutonLigne.add(new Button(activite));
        linearLayout.addView(listeBoutonLigne.get(0));
        listeBoutonLigne.get(0).setText(nomLigne[0]);
        initialiserListenerLigne(0);

        for (int i=1; i<nomLigne.length;i++){
            RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
            params.addRule(RelativeLayout.END_OF,listeBoutonLigne.get(i-1).getId());
            listeBoutonLigne.add(new Button(activite));
            listeBoutonLigne.get(i).setText(nomLigne[i]);
            listeBoutonLigne.get(i).setLayoutParams(params);
            linearLayout.addView(listeBoutonLigne.get(i));
            initialiserListenerLigne(i);
        }
    }
}
