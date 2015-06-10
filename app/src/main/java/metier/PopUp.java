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

    public void créationPopupConfirmation(Activity activite, String titre, String contenu){

        new AlertDialog.Builder(activite)
                .setTitle(titre)
                .setMessage(contenu)
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // continue with delete
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .show();

    }
}
