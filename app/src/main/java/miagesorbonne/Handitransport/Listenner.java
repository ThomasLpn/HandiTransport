package miagesorbonne.Handitransport;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.View;


/**
 * Created by user on 05/04/2015.
 */

/**
 * La classe Listenner l'activité main
 * Cette classe permet de créer des listenner sur chaque bouton de l'activité main
 * Avec ces boutons on va pouvoir ouvrir de nouvelles activités
 */
public class Listenner implements View.OnClickListener {

    Intent intent;
    Activity act;

    /**
     * Méthode pour créer un listenner sur un bouton. Avec ce bouton on va pouvoir ouvrir une nouvelle activité
     * @param inte le contexte de l'activité
     * @param classe la classe qui correspond à l'activité que l'on souhaite ouvrir
     * @param act l'activité dans lequel se trouve le bouton sur lequel on va associé ce listenner
     */
    public Listenner(Context inte, Class classe, Activity act){
        intent = new Intent(inte, classe);
        this.act=act;
    }

    @Override
    public void onClick(View v) {
        act.startActivity(intent);
    }
}
