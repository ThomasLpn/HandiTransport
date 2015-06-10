package miagesorbonne.Handitransport;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
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

        //Pour le multithreading
        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Passage de l'activité main à l'activité selectionnerLigne
        final Button select = (Button) findViewById(R.id.autourDeMoi);
        select.setOnClickListener(new Listenner(MainActivity.this,AutourDeMoi.class,this));

        //Passage de l'activité main à l'activité ajoutPanne
        final Button select2 = (Button) findViewById(R.id.ajoutPanne);
        select2.setOnClickListener(new Listenner(MainActivity.this,AjoutPanne.class,this));

        //Passage de l'activité main à l'activité ajoutLieu
        final Button select3 = (Button) findViewById(R.id.ajoutLieu);
        select3.setOnClickListener(new Listenner(MainActivity.this,AjoutLieu.class,this));

        //Passage de l'activité main à l'activité selectionnerLigne
        final Button select4 = (Button) findViewById(R.id.pannes);
        select4.setOnClickListener(new Listenner(MainActivity.this,Pannes.class,this));
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
