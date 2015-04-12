package miagesorbonne.Handitransport;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.RelativeLayout;

public class MainActivity extends ActionBarActivity {
    RelativeLayout layout = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Traduction du menu soit en anglais soit en français
        Translater.menu(getResources(), this);

        //Passage de l'activité main à l'activité selectionnerLigne
        final Button selectionner = (Button) findViewById(R.id.autourDeMoi);
        selectionner.setOnClickListener(new Listenner(MainActivity.this,Pannes.class,this));

        //Passage de l'activité main à l'activité autourDeMoi
        //final Button selectionner2 = (Button) findViewById(R.id.autourDeMoi);
        //selectionner.setOnClickListener(new Listenner(MainActivity.this,Pannes.class,this));

        //Passage de l'activité main à l'activité selectionnerLigne
        //final Button selectionner = (Button) findViewById(R.id.autourDeMoi);
        //selectionner.setOnClickListener(new Listenner(MainActivity.this,Pannes.class,this));

        //Passage de l'activité main à l'activité selectionnerLigne
        //final Button selectionner = (Button) findViewById(R.id.autourDeMoi);
        //selectionner.setOnClickListener(new Listenner(MainActivity.this,Pannes.class,this));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
