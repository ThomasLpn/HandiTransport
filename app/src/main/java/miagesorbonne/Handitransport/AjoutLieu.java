package miagesorbonne.Handitransport;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import controlleur.ManagerAjoutLieu;

/**
 * Classe qui correspond à l'activité Android d'ajout de lieu
 */
public class AjoutLieu extends ActionBarActivity {

    //Manager de l'activité(IHM) qui va gérer les intéraction avec l'utilisateur
    ManagerAjoutLieu managerAjoutLieu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_lieu);
        managerAjoutLieu = new ManagerAjoutLieu(this);
        managerAjoutLieu.intitialiserCategorie();
        managerAjoutLieu.listennerCreationLieu();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_ajout_lieu, menu);
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
