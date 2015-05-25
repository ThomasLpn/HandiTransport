package miagesorbonne.Handitransport;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.SearchView;
import android.widget.Spinner;
import android.widget.Toast;

import controlleur.ManagerPanne;


public class AjoutPanne extends ActionBarActivity {

    private ManagerPanne manager;
    private static final String[] STATIONS = new String[]{"Gare de Lyon", "Nationale", "Odéon", "Gare Montparnasse"};
    private static final String[] ESCASC = new String[]{"Ascensseur 1","Ascensseur 2","Ascensseur 3"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        manager = new ManagerPanne(this);
        setContentView(R.layout.activity_ajout_panne);
        Button validation = (Button) findViewById(R.id.ajoutPanneBoutonValider);
        manager.validationPanne(validation);

        ArrayAdapter<String> adapterStation = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line,STATIONS);
        AutoCompleteTextView text = (AutoCompleteTextView) findViewById(R.id.rechercheStation);
        text.setAdapter(adapterStation);


        ArrayAdapter<String> adapterEscasc = new ArrayAdapter<>(this,android.R.layout.simple_spinner_item,ESCASC);
        adapterEscasc.setDropDownViewResource(android.R.layout.simple_spinner_item);
        Spinner spinner = (Spinner) findViewById(R.id.listeAscenseurEscalator);
        spinner.setAdapter(adapterEscasc);
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
