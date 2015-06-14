package metier;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

/** Classe qui permet de créer une pop up sur une activité
 * Created by user on 24/05/2015.
 */
public class PopUp {

    /**
     * Médode pour créer une pop up sur une activité
     * @param activite l'activité dans laquelle va être créer une pop up
     * @param titre le titre de la pop up
     * @param contenu le contenu de la pop up
     */
    public void creationPopup(Activity activite, String titre, String contenu){

        new AlertDialog.Builder(activite)
                .setTitle(titre)
                .setMessage(contenu)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .show();

    }

    /**
     * Méthode qui permet de créer une pop up avec un bouton de confirmation ou d'annulation
     * Cette popp up est créé sur une Activity
     * @param activite activité sur lequel sera créé la popup de confirmation
     * @param titre le titre de la popup nouvellement créé
     * @param contenu le contenu de la popup
     */
    public void creationPopupConfirmation(Activity activite, String titre, String contenu){

        new AlertDialog.Builder(activite)
                .setTitle(titre)
                .setMessage(contenu)
                //Le bouton de confirmation qui sera traduit dans le langue de l'utilisateur
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                //Le bouton d'annulation qui sera traduit dans la langue de l'utilisateur
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

    }
}
