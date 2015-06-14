package miagesorbonne.Handitransport;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import controlleur.ManagerAjoutPanne;

/**
 * Classe qui correspond à l'activité Android d'ajout de Panne
 */
public class AjoutPanne extends ActionBarActivity {

    //Le manager de l'activité ajout lieu qui va gérer les intéractions avec l'utilisateur
    private ManagerAjoutPanne manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = new ManagerAjoutPanne(this);
        setContentView(R.layout.activity_ajout_panne);
        Button validation = (Button) findViewById(R.id.ajoutPanneBoutonValider);
        manager.validationPanne(validation);
        manager.initilisationRechercheStation();
        manager.modificationGroupeRadioBouton();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ajout_panne, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
